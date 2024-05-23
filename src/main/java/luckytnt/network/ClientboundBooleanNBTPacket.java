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

public class ClientboundBooleanNBTPacket implements CustomPacketPayload {
	
	public static final Type<ClientboundBooleanNBTPacket> TYPE = new Type<>(new ResourceLocation(LuckyTNTMod.MODID, "boolean_nbt_packet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundBooleanNBTPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundBooleanNBTPacket::encode, ClientboundBooleanNBTPacket::new);
	
	public final String name;
	public final boolean tag;
	public final int entityId;
	
	public ClientboundBooleanNBTPacket(String name, boolean tag, int entityId) {
		this.name = name;
		this.tag = tag;
		this.entityId = entityId;
	}
	
	public ClientboundBooleanNBTPacket(FriendlyByteBuf buffer) {
		name = buffer.readUtf();
		tag = buffer.readBoolean();
		entityId = buffer.readInt();
	}
	
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeUtf(name);
		buffer.writeBoolean(tag);
		buffer.writeInt(entityId);
	}
	
	public void handle(IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			if(FMLLoader.getDist().isClient()) {
				ClientAccess.setEntityBooleanTag(name, tag, entityId);
			}
		});
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
