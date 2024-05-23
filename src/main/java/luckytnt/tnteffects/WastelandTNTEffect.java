package luckytnt.tnteffects;

import java.util.List;

import luckytnt.registry.BlockRegistry;
import luckytnt.util.Materials;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.common.IPlantable;

public class WastelandTNTEffect extends PrimedTNTEffect {
	
	public static List<Block> GRASS = List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.MYCELIUM, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS);
	public static List<Block> DIRT = List.of(Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT);

	@Override
	public void serverExplosion(IExplosiveEntity ent) {
		doVaporizeExplosion(ent, 75, true);
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity ent) {
		for (int count = 0; count < 100; count++) {
			ent.getLevel().addParticle(ParticleTypes.CLOUD, true, ent.x() + Math.random() * 30 - Math.random() * 30, ent.y() + 0.5f, ent.z() + Math.random() * 30 - Math.random() * 30, 0, 0, 0);
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.WASTELAND_TNT.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return 180;
	}
	
	public static void doVaporizeExplosion(IExplosiveEntity ent, double radius, boolean dryArea) {
		if(!ent.getLevel().isClientSide()) {
			for(double offX = -radius; offX <= radius; offX++) {
				for(double offY = -radius; offY <= radius; offY++) {
					for(double offZ = -radius; offZ <= radius; offZ++) {
						double distance = Math.sqrt(offX * offX + offY * offY + offZ * offZ);
						BlockPos pos = new BlockPos(Mth.floor(ent.x() + offX), Mth.floor(ent.y() + offY), Mth.floor(ent.z() + offZ));
						BlockPos posDown = pos.offset(0, -1, 0);
						BlockState state = ent.getLevel().getBlockState(pos);
						BlockState stateDown = ent.getLevel().getBlockState(posDown);
						
						if(distance <= radius) {
							if(state.getBlock() instanceof LiquidBlock || Materials.isWaterPlant(state) || state.is(Blocks.BUBBLE_COLUMN)) {
								ent.getLevel().setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
							}
							if(state.hasProperty(BlockStateProperties.WATERLOGGED) && state.getValue(BlockStateProperties.WATERLOGGED)) {
								ent.getLevel().setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, false), 3);
							}
							if(dryArea) {
								if(Materials.isPlant(state)) {
									if(stateDown.canSustainPlant(ent.getLevel(), posDown, Direction.UP, (IPlantable)Blocks.DEAD_BUSH)) {
										ent.getLevel().setBlock(pos, Blocks.DEAD_BUSH.defaultBlockState(), 3);
									}
								}
								if(GRASS.contains(state.getBlock())) {
									ent.getLevel().setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
								} else if(DIRT.contains(state.getBlock())) {
									ent.getLevel().setBlock(pos, Blocks.SAND.defaultBlockState(), 3);
								} else if(state.is(BlockTags.WOOL)) {
									ent.getLevel().setBlock(pos, Blocks.WHITE_WOOL.defaultBlockState(), 3);
								} else if(state.getBlock() instanceof WetSpongeBlock) {
									ent.getLevel().setBlock(pos, Blocks.SPONGE.defaultBlockState(), 3);
								} else if(state.is(BlockTags.ICE) || state.is(BlockTags.SNOW) || state.is(BlockTags.LEAVES)) {
									ent.getLevel().setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
								}
							}
						}
					}
				}
			}
		}
	}
}
