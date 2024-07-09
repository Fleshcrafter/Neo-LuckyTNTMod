package luckytnt.network;

import luckytnt.LevelVariables;
import luckytnt.LuckyTNTMod;
import luckytnt.client.ClientAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientboundLevelVariablesPacket implements CustomPacketPayload {
	
	public static final Type<ClientboundLevelVariablesPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LuckyTNTMod.MODID, "level_variables_packet"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundLevelVariablesPacket> STREAM_CODEC = CustomPacketPayload.codec(ClientboundLevelVariablesPacket::encode, ClientboundLevelVariablesPacket::new);
	
	public final LevelVariables variables;
	
	public ClientboundLevelVariablesPacket(LevelVariables variables) {
		this.variables = variables;
	}
	
	public ClientboundLevelVariablesPacket(FriendlyByteBuf buffer) {
		variables = new LevelVariables();
		variables.read(buffer.readNbt());
	}
	
	public void encode(FriendlyByteBuf buffer) {
		buffer.writeNbt(variables.save(new CompoundTag()));
	}
	
	public void handle(IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			if(FMLLoader.getDist().isClient()) { 
				ClientAccess.syncLevelVariables(variables);
			}
		});
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
