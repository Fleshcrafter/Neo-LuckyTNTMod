package luckytnt;

import luckytnt.client.ClientAccess;
import luckytnt.config.LuckyTNTConfigs;
import luckytnt.registry.SoundRegistry;
import luckytntlib.registry.RegistryHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(LuckyTNTMod.MODID)
public class LuckyTNTMod {
	public static final String MODID = "luckytntmod";
	public static final DeferredRegister.Blocks blockRegistry = DeferredRegister.createBlocks(MODID);
	public static final DeferredRegister<BlockEntityType<?>> blockEntityRegistry = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MODID);
	public static final DeferredRegister.Items itemRegistry = DeferredRegister.createItems(MODID);
	public static final DeferredRegister<EntityType<?>> entityRegistry = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);
	public static final DeferredRegister<MobEffect> effectRegistry = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MODID);
	public static final DeferredRegister<Feature<?>> featureRegistry = DeferredRegister.create(BuiltInRegistries.FEATURE, MODID);
	public static final RegistryHelper RH = new RegistryHelper(blockRegistry, itemRegistry, entityRegistry);

	public LuckyTNTMod(IEventBus modEventBus, Dist dist, ModContainer modContainer) {
		SoundRegistry.SOUNDS.register(modEventBus);
		entityRegistry.register(modEventBus);
		blockEntityRegistry.register(modEventBus);
		blockRegistry.register(modEventBus);
		itemRegistry.register(modEventBus);
		effectRegistry.register(modEventBus);
		featureRegistry.register(modEventBus);
		LuckyTNTConfigs.registerCommonConfig(modContainer);
		
		if(dist.isClient()) {
			modContainer.registerExtensionPoint(IConfigScreenFactory.class, ClientAccess.getScreenFactory());
		}
	}
}
