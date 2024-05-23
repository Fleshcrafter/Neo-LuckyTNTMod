package luckytnt.registry;

import luckytnt.client.model.BombModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ModelRegistry {

	@SubscribeEvent
	public static void registerModels(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(BombModel.LAYER_LOCATION, BombModel::createBodyLayer);
	}
}
