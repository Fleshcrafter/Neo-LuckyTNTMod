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

public class ClientboundFreezeNBTPacket implements CustomPacketPayload {
	
	public static final Type<ClientboundFreezeNBTPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LuckyTNTMod.MODID, "freeze_nbt_packet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundFreezeNBTPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundFreezeNBTPacket::encode, ClientboundFreezeNBTPacket::new);
	
	public final String nbt;
	public final int value;
	
	public ClientboundFreezeNBTPacket(String nbt,int value) {
		this.nbt = nbt;
		this.value = value;
	}
	
	public ClientboundFreezeNBTPacket(FriendlyByteBuf buffer) {
		nbt = buffer.readUtf();
		value = buffer.readInt();
	}
	
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeUtf(nbt);
		buffer.writeInt(value);
	}
	
	public void handle(IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			if(FMLLoader.getDist().isClient()) {
				ClientAccess.updateEntityIntNBT(nbt, value);
			}
		});
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
