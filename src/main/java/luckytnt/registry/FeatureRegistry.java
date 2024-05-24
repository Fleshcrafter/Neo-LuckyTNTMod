package luckytnt.registry;

import luckytnt.LuckyTNTMod;
import luckytnt.feature.Altar;
import luckytnt.feature.Grave;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber(modid = LuckyTNTMod.MODID, bus = Bus.MOD)
public class FeatureRegistry {
	
	public static final DeferredHolder<Feature<?>, Grave> graves = LuckyTNTMod.featureRegistry.register("graves", () -> new Grave(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Altar> altar = LuckyTNTMod.featureRegistry.register("altar", () -> new Altar(NoneFeatureConfiguration.CODEC));

	@SubscribeEvent
	public static void dummyRegisterEvent(NewRegistryEvent event) {	}
}
