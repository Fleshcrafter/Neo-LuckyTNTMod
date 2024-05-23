package luckytnt.registry;

import luckytnt.LuckyTNTMod;
import luckytnt.network.ClientboundBooleanNBTPacket;
import luckytnt.network.ClientboundFreezeNBTPacket;
import luckytnt.network.ClientboundHydrogenBombPacket;
import luckytnt.network.ClientboundIntNBTPacket;
import luckytnt.network.ClientboundLevelVariablesPacket;
import luckytnt.network.ClientboundStringNBTPacket;
import luckytnt.network.ClientboundToxicCloudPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PacketRegistry {
	
	@SubscribeEvent
	public static void registerPayloads(RegisterPayloadHandlersEvent event) {
		PayloadRegistrar registry = event.registrar(LuckyTNTMod.MODID).versioned("1.0.0");
		registry.playToClient(ClientboundBooleanNBTPacket.TYPE, ClientboundBooleanNBTPacket.STREAM_CODEC, ClientboundBooleanNBTPacket::handle);
		registry.playToClient(ClientboundFreezeNBTPacket.TYPE, ClientboundFreezeNBTPacket.STREAM_CODEC, ClientboundFreezeNBTPacket::handle);
		registry.playToClient(ClientboundHydrogenBombPacket.TYPE, ClientboundHydrogenBombPacket.STREAM_CODEC, ClientboundHydrogenBombPacket::handle);
		registry.playToClient(ClientboundIntNBTPacket.TYPE, ClientboundIntNBTPacket.STREAM_CODEC, ClientboundIntNBTPacket::handle);
		registry.playToClient(ClientboundLevelVariablesPacket.TYPE, ClientboundLevelVariablesPacket.STREAM_CODEC, ClientboundLevelVariablesPacket::handle);
		registry.playToClient(ClientboundStringNBTPacket.TYPE, ClientboundStringNBTPacket.STREAM_CODEC, ClientboundStringNBTPacket::handle);
		registry.playToClient(ClientboundToxicCloudPacket.TYPE, ClientboundToxicCloudPacket.STREAM_CODEC, ClientboundToxicCloudPacket::handle);
	}
}
