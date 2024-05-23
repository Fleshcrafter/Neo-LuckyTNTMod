package luckytnt.tnteffects;

import java.util.function.Supplier;

import luckytntlib.block.LTNTBlock;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ExplosionHelper;
import luckytntlib.util.explosions.IForEachBlockExplosionEffect;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;

public class FlatTNTEffect extends PrimedTNTEffect{
	private final int radius;
	private final int radiusY;
	private int fuse = 80;
	private Supplier<DeferredBlock<LTNTBlock>> block;
	
	public FlatTNTEffect(int radius, int radiusY, int fuse) {
		this.radius = radius;
		this.radiusY = radiusY;
		this.fuse = fuse;
	}
	
	public FlatTNTEffect(Supplier<DeferredBlock<LTNTBlock>> block, int radius, int radiusY, int fuse) {
		this.radius = radius;
		this.radiusY = radiusY;
		this.block = block;
		this.fuse = fuse;
	}
	
	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		ImprovedExplosion dummyExplosion = ImprovedExplosion.dummyExplosion(entity.getLevel());
		ExplosionHelper.doCylindricalExplosion(entity.getLevel(), entity.getPos(), radius, radiusY, new IForEachBlockExplosionEffect() {
			
			@Override
			public void doBlockExplosion(Level level, BlockPos pos, BlockState state, double distance) {
				if(pos.getY() >= entity.y() - 0.5f) {
					if(state.getExplosionResistance(level, pos, dummyExplosion) <= 100) {
						state.onBlockExploded(level, pos, dummyExplosion);
					}
				}
			}
		});
	}
	
	@Override
	public Block getBlock() {
		return block.get().get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return fuse;
	}
}
