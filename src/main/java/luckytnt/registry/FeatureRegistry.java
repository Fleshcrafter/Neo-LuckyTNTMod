package luckytnt.registry;

import luckytnt.LuckyTNTMod;
import luckytnt.feature.Altar;
import luckytnt.feature.Grave;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FeatureRegistry {

	public static final DeferredHolder<Feature<?>, Grave> graves = LuckyTNTMod.featureRegistry.register("graves", () -> new Grave(NoneFeatureConfiguration.CODEC));
	public static final DeferredHolder<Feature<?>, Altar> altar = LuckyTNTMod.featureRegistry.register("altar", () -> new Altar(NoneFeatureConfiguration.CODEC));
}
