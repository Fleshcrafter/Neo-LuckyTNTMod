package luckytnt.client.renderer;

import luckytnt.entity.AngryMiner;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class AngryMinerRenderer extends HumanoidMobRenderer<AngryMiner, HumanoidModel<AngryMiner>>{

	public AngryMinerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<AngryMiner>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<AngryMiner>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel<AngryMiner>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}
	
	@Override
	public ResourceLocation getTextureLocation(AngryMiner entity) {
		return ResourceLocation.parse("luckytntmod:textures/angryminer.png");
	}
}
