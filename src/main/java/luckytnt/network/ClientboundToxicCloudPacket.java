package luckytnt.network;

import luckytnt.LuckyTNTMod;
import luckytnt.client.ClientAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientboundToxicCloudPacket implements CustomPacketPayload {
	
	public static final Type<ClientboundToxicCloudPacket> TYPE = new Type<>(new ResourceLocation(LuckyTNTMod.MODID, "toxic_cloud_packet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundToxicCloudPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundToxicCloudPacket::encode, ClientboundToxicCloudPacket::new);
	
	public final double size;
	public final int entityId;
	
	public ClientboundToxicCloudPacket(double size, int entityId) {
		this.size = size;
		this.entityId = entityId;
	}
	
	public ClientboundToxicCloudPacket(FriendlyByteBuf buffer) {
		size = buffer.readDouble();
		entityId = buffer.readInt();
	}
	
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeDouble(size);
		buffer.writeInt(entityId);
	}
	
	public void handle(IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			if(FMLLoader.getDist().isClient()) { 
				ClientAccess.setToxicCloudData(size, entityId);
			}
		});
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
