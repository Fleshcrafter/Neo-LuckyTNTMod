package luckytnt.entity;

import luckytnt.network.ClientboundStringNBTPacket;
import luckytnt.tnteffects.StructureTNTEffect;
import luckytntlib.entity.PrimedLTNT;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

public class PrimedStructureTNT extends PrimedLTNT{
	
	public PrimedStructureTNT(EntityType<PrimedLTNT> type, Level level) {
		super(type, level, new StructureTNTEffect());
	}
	
	@Override
	public void onAddedToWorld() {
		if(!level().isClientSide()) {
			PacketDistributor.sendToPlayersTrackingEntity(this, new ClientboundStringNBTPacket("structure", getPersistentData().getString("structure"), getId()));
      		//PacketHandler.CHANNEL.send(new ClientboundStringNBTPacket("structure", getPersistentData().getString("structure"), getId()), PacketDistributor.TRACKING_ENTITY.with(this));
      	}
	}
}
