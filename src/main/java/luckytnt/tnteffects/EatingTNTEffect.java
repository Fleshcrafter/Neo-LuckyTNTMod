package luckytnt.tnteffects;

import java.util.List;

import luckytnt.network.ClientboundIntNBTPacket;
import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.network.PacketDistributor;

public class EatingTNTEffect extends PrimedTNTEffect{

	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		ImprovedExplosion explosion = new ImprovedExplosion(entity.getLevel(), (Entity)entity, entity.getPos(), 10 + Mth.floor((1f/7.5f) * entity.getPersistentData().getInt("eatLevel")));
		explosion.doEntityExplosion(1.5f + entity.getPersistentData().getInt("eatLevel") / 300f, true);
		explosion.doBlockExplosion();
	}
	
	@Override
	public void explosionTick(IExplosiveEntity entity) {
		if(entity.getPersistentData().getInt("eatLevel") < 300) {
			List<ItemEntity> items = entity.getLevel().getEntitiesOfClass(ItemEntity.class, new AABB(entity.getPos().add(-10, -10, -10), entity.getPos().add(10, 10, 10)));
			for(ItemEntity item : items) {
				item.setDeltaMovement(entity.getPos().add(item.getPosition(1).scale(-1)).normalize());
				if(entity.getPos().distanceTo(item.getPosition(1)) < 1) {
					entity.getPersistentData().putInt("eatLevel", Mth.clamp(entity.getPersistentData().getInt("eatLevel") + item.getItem().getCount(), 0, 300));
					if(entity.getLevel() instanceof ServerLevel) {
						PacketDistributor.sendToPlayersTrackingEntity((Entity)entity, new ClientboundIntNBTPacket("eatLevel", entity.getPersistentData().getInt("eatLevel"), ((Entity)entity).getId()));
					}
					item.discard();
				}
			}
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.EATING_TNT.get();
	}
	
	@Override
	public float getSize(IExplosiveEntity entity) {
		return 1f + entity.getPersistentData().getInt("eatLevel") / 300f;
	}
		
	@Override
	public int getDefaultFuse(IExplosiveEntity entity) {
		return 400;
	}
}
