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

public class ClientboundIntNBTPacket implements CustomPacketPayload {
	
	public static final Type<ClientboundIntNBTPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LuckyTNTMod.MODID, "int_nbt_packet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundIntNBTPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundIntNBTPacket::encode, ClientboundIntNBTPacket::new);
	
	public final String name;
	public final int tag;
	public final int entityId;
	
	public ClientboundIntNBTPacket(String name, int tag, int entityId) {
		this.name = name;
		this.tag = tag;
		this.entityId = entityId;
	}
	
	public ClientboundIntNBTPacket(FriendlyByteBuf buffer) {
		name = buffer.readUtf();
		tag = buffer.readInt();
		entityId = buffer.readInt();
	}
	
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeUtf(name);
		buffer.writeInt(tag);
		buffer.writeInt(entityId);
	}
	
	public void handle(IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			if(FMLLoader.getDist().isClient()) { 
				ClientAccess.setEntityIntTag(name, tag, entityId);
			}
		});
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
