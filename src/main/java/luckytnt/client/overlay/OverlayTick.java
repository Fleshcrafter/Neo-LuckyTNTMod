package luckytnt.client.overlay;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import luckytnt.config.LuckyTNTConfigValues;
import luckytnt.registry.EffectRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(value = {Dist.CLIENT})
public class OverlayTick {
	
	private static float contaminatedAmount = 0;
	
	@SuppressWarnings("resource")
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onOverlayRender(RenderGuiEvent.Post event) {
		if(Minecraft.getInstance().player != null) {
			GuiGraphics graphics = event.getGuiGraphics();
			Player player = Minecraft.getInstance().player;
			int w = graphics.guiWidth();
			int h = graphics.guiHeight();
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			if(player.getPersistentData().getInt("freezeTime") > 0 && !player.hasEffect(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(EffectRegistry.CONTAMINATED_EFFECT.get()))) {
				RenderSystem.setShaderColor(1f, 1f, 1f, (float)(player.getPersistentData().getInt("freezeTime")) / 1200f);
				RenderSystem.setShaderTexture(0, ResourceLocation.parse("luckytntmod:textures/powder_snow_outline.png"));
				graphics.blit(ResourceLocation.parse("luckytntmod:textures/powder_snow_outline.png"), 0, 0, 0, 0, w, h, w, h);
			} else if(player.hasEffect(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(EffectRegistry.CONTAMINATED_EFFECT.get())) && LuckyTNTConfigValues.RENDER_CONTAMINATED_OVERLAY.get()) {
				RenderSystem.setShaderColor(1f, 1f, 1f, contaminatedAmount);
				RenderSystem.setShaderTexture(0, ResourceLocation.parse("luckytntmod:textures/contaminated_outline.png"));
				graphics.blit(ResourceLocation.parse("luckytntmod:textures/contaminated_outline.png"), 0, 0, 0, 0, w, h, w, h);
				contaminatedAmount = Mth.clamp(contaminatedAmount + 0.025f, 0f, 1f);
			} else if(contaminatedAmount > 0){
				RenderSystem.setShaderColor(1f, 1f, 1f, contaminatedAmount);
				RenderSystem.setShaderTexture(0, ResourceLocation.parse("luckytntmod:textures/contaminated_outline.png"));
				graphics.blit(ResourceLocation.parse("luckytntmod:textures/contaminated_outline.png"), 0, 0, 0, 0, w, h, w, h);
				contaminatedAmount = Mth.clamp(contaminatedAmount - 0.025f, 0f, 1f);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.disableBlend();
			RenderSystem.enableDepthTest();
			RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
		}
	}
}
