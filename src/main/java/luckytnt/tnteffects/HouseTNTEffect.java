package luckytnt.tnteffects;

import java.util.function.Supplier;

import luckytnt.LuckyTNTMod;
import luckytntlib.block.LTNTBlock;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.neoforged.neoforge.registries.DeferredBlock;

public class HouseTNTEffect extends PrimedTNTEffect{

	private final Supplier<DeferredBlock<LTNTBlock>> TNT;
	private final String house;
	private final int offX;
	private final int offZ;
	
	public HouseTNTEffect(Supplier<DeferredBlock<LTNTBlock>> TNT, String house, int offX, int offZ) {
		this.TNT = TNT;
		this.house = house;
		this.offX = offX;
		this.offZ = offZ;
	}
	
	@Override
	public Block getBlock() {
		return TNT.get().get();
	}

	@SuppressWarnings("resource")
	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		StructureTemplate template = ((ServerLevel)entity.getLevel()).getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath(LuckyTNTMod.MODID, house));
		if(template != null) {
			template.placeInWorld((ServerLevel)entity.getLevel(), toBlockPos(entity.getPos()).offset(offX, 0, offZ), toBlockPos(entity.getPos()).offset(offX, 0, offZ), new StructurePlaceSettings(), entity.getLevel().random, 3);
		}
	}
}
