package luckytnt.client;

import luckytnt.LevelVariables;
import luckytnt.client.gui.ConfigScreen;
import luckytnt.util.NuclearBombLike;
import luckytntlib.util.IExplosiveEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class ClientAccess {
	
	private static final IConfigScreenFactory configScreenFactory = new IConfigScreenFactory() {

		@Override
		public Screen createScreen(Minecraft minecraft, Screen modListScreen) {
			return new ConfigScreen();
		}
	};
	
	public static void setEntityStringTag(String name, String tag, int id) {
		Minecraft minecraft = Minecraft.getInstance();
		Entity ent = minecraft.level.getEntity(id);
		if(ent != null) {
			ent.getPersistentData().putString(name, tag);
		}
	}
	
	public static void setEntityBooleanTag(String name, boolean tag, int id) {
		Minecraft minecraft = Minecraft.getInstance();
		Entity ent = minecraft.level.getEntity(id);
		if(ent != null) {
			ent.getPersistentData().putBoolean(name, tag);
		}
	}
	
	public static void setEntityIntTag(String name, int tag, int id) {
		Minecraft minecraft = Minecraft.getInstance();
		Entity ent = minecraft.level.getEntity(id);
		if(ent != null) {
			ent.getPersistentData().putInt(name, tag);
		}
	}
	
	public static void syncLevelVariables(LevelVariables variables) {
		LevelVariables.clientSide = variables;
	}
	
	public static void setToxicCloudData(double size, int id) {
		Minecraft minecraft = Minecraft.getInstance();
		Entity ent = minecraft.level.getEntity(id);
		if(ent != null) {
			ent.getPersistentData().putDouble("size", size);
		}
	}
	
	@SuppressWarnings("resource")
	public static void updateEntityIntNBT(String nbt, int value) {
		Player player = Minecraft.getInstance().player;
		if(player != null) {
			player.getPersistentData().putInt(nbt, value);
		}
	}
	
	public static void displayHydrogenBombParticles(int id) {
		Minecraft minecraft = Minecraft.getInstance();
		Entity ent = minecraft.level.getEntity(id);
		if(ent != null) {
			if(ent instanceof IExplosiveEntity ient) {
				if(ient.getEffect() instanceof NuclearBombLike effect) {
					effect.displayMushroomCloud(ient);
				}
			}
		}
	}
	
	public static IConfigScreenFactory getScreenFactory() {
		return configScreenFactory;
	}
}
