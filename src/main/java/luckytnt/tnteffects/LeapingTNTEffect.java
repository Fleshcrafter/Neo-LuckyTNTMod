package luckytnt.tnteffects;

import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;

public class LeapingTNTEffect extends PrimedTNTEffect{

	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		if(((Entity)entity).getPersistentData().getInt("bounces") < 24) {
			ImprovedExplosion explosion = new ImprovedExplosion(entity.getLevel(), (Entity)entity, entity.getPos(), 10);
			explosion.doEntityExplosion(1.5f, true);
			explosion.doBlockExplosion(1f, 1f, 1f, 1.25f, false, false);
		} else {
			ImprovedExplosion explosion = new ImprovedExplosion(entity.getLevel(), (Entity)entity, entity.getPos(), 20);
			explosion.doEntityExplosion(2f, true);
			explosion.doBlockExplosion(1f, 1f, 1f, 1.5f, false, false);
		}
	}
	
	@Override
	public void explosionTick(IExplosiveEntity entity) {
		if(((Entity)entity).onGround()) {
			((Entity)entity).getPersistentData().putInt("bounces", ((Entity)entity).getPersistentData().getInt("bounces") + 1);
			((Entity)entity).setDeltaMovement(Math.random() * 1.5D - Math.random() * 1.5D, Math.random() * 2f, Math.random() * 1.5D - Math.random() * 1.5D);
			entity.getLevel().playSound(null, entity.x(), entity.y(), entity.z(), SoundEvents.SLIME_JUMP, SoundSource.MASTER, 1, 1);
			entity.getLevel().playSound((Entity)entity, toBlockPos(entity.getPos()), SoundEvents.GENERIC_EXPLODE.value(), SoundSource.BLOCKS, 4f, (1f + (entity.getLevel().getRandom().nextFloat() - entity.getLevel().getRandom().nextFloat()) * 0.2f) * 0.7f);
			
			if(((Entity)entity).getPersistentData().getInt("bounces") >= 24) {
				if(entity.getLevel() instanceof ServerLevel) {
					serverExplosion(entity);
				}
				entity.destroy();
			}
			if(((Entity)entity).getPersistentData().getInt("bounces") >= 1 && ((Entity)entity).getPersistentData().getInt("bounces") < 24 && entity.getLevel() instanceof ServerLevel) {
				serverExplosion(entity);
			}
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.LEAPING_TNT.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity entity) {
		return 100000;
	}
}
