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

public class ClientboundStringNBTPacket implements CustomPacketPayload {
	
	public static final Type<ClientboundStringNBTPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LuckyTNTMod.MODID, "string_nbt_packet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundStringNBTPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundStringNBTPacket::encode, ClientboundStringNBTPacket::new);
	
	public final String name;
	public final String tag;
	public final int entityId;
	
	public ClientboundStringNBTPacket(String name, String tag, int entityId) {
		this.name = name;
		this.tag = tag;
		this.entityId = entityId;
	}
	
	public ClientboundStringNBTPacket(FriendlyByteBuf buffer) {
		name = buffer.readUtf();
		tag = buffer.readUtf();
		entityId = buffer.readInt();
	}
	
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeUtf(name);
		buffer.writeUtf(tag);
		buffer.writeInt(entityId);
	}
	
	public void handle(IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			if(FMLLoader.getDist().isClient()) { 
				ClientAccess.setEntityStringTag(name, tag, entityId);
			}
		});
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
