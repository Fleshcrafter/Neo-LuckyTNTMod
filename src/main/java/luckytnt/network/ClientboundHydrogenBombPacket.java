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

public class ClientboundHydrogenBombPacket implements CustomPacketPayload {
	
	public static final Type<ClientboundHydrogenBombPacket> TYPE = new Type<>(new ResourceLocation(LuckyTNTMod.MODID, "hydrogen_bomb_packet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundHydrogenBombPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundHydrogenBombPacket::encode, ClientboundHydrogenBombPacket::new);
	
	public final int entityId;
	
	public ClientboundHydrogenBombPacket(int entityId) {
		this.entityId = entityId;
	}
	
	public ClientboundHydrogenBombPacket(FriendlyByteBuf buffer) {
		entityId = buffer.readInt();
	}
	
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeInt(entityId);
	}
	
	public void handle(IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			if(FMLLoader.getDist().isClient()) {
				ClientAccess.displayHydrogenBombParticles(entityId);
			}
		});
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
