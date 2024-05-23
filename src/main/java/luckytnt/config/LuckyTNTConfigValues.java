package luckytnt.config;

import luckytnt.util.CustomTNTConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class LuckyTNTConfigValues {
	
	public static ModConfigSpec.IntValue ISLAND_HEIGHT;
	public static ModConfigSpec.IntValue DROP_HEIGHT;
	public static ModConfigSpec.IntValue MAXIMUM_DISASTER_TIME;
	public static ModConfigSpec.DoubleValue AVERAGE_DIASTER_INTENSITY;
	
	public static ModConfigSpec.EnumValue<CustomTNTConfig> CUSTOM_TNT_FIRST_EXPLOSION;
	public static ModConfigSpec.IntValue CUSTOM_TNT_FIRST_EXPLOSION_INTENSITY;
	
	public static ModConfigSpec.EnumValue<CustomTNTConfig> CUSTOM_TNT_SECOND_EXPLOSION;
	public static ModConfigSpec.IntValue CUSTOM_TNT_SECOND_EXPLOSION_INTENSITY;
	
	public static ModConfigSpec.EnumValue<CustomTNTConfig> CUSTOM_TNT_THIRD_EXPLOSION;
	public static ModConfigSpec.IntValue CUSTOM_TNT_THIRD_EXPLOSION_INTENSITY;

	public static ModConfigSpec.BooleanValue SEASON_EVENTS_ALWAYS_ACTIVE;
	
	public static ModConfigSpec.BooleanValue RENDER_CONTAMINATED_OVERLAY;
	
	public static ModConfigSpec.BooleanValue PRESENT_DROP_DESTROY_BLOCKS;
	
	public static void registerConfig(ModConfigSpec.Builder builder) {
		builder.comment("TNT Settings").push("Offsets");
		ISLAND_HEIGHT = builder.comment("Y offset of floating islands").defineInRange("islandHeight", 50, 20, 160);
		DROP_HEIGHT = builder.comment("Y offset of dropped projectiles").defineInRange("dropHeight", 200, 60, 400);
		builder.pop();
		builder.comment("Disaster Settings").push("Disasters");
		MAXIMUM_DISASTER_TIME  = builder.comment("Maximum duration of disasters in minutes").defineInRange("maximumTime", 12, 2, 24);
		AVERAGE_DIASTER_INTENSITY = builder.comment("Multiplier to the destructive capabilities of disasters").defineInRange("averageIntensity", 1d, 1d, 10d);
		builder.pop();
		builder.comment("Custom TNT Settings").push("First Explosion");
		CUSTOM_TNT_FIRST_EXPLOSION = builder.comment("Explosion Effect of the first Explosion").defineEnum("explosionType", CustomTNTConfig.NO_EXPLOSION);
		CUSTOM_TNT_FIRST_EXPLOSION_INTENSITY = builder.comment("Multiplier to the power of the first explosion").defineInRange("explosionIntensity", 1, 1, 20);
		builder.pop();
		builder.push("Second Explosion");
		CUSTOM_TNT_SECOND_EXPLOSION = builder.comment("Explosion Effect of the second Explosion").defineEnum("explosionType", CustomTNTConfig.NO_EXPLOSION);
		CUSTOM_TNT_SECOND_EXPLOSION_INTENSITY = builder.comment("Multiplier to the power of the second explosion").defineInRange("explosionIntensity", 1, 1, 20);
		builder.pop();
		builder.push("Third Explosion");
		CUSTOM_TNT_THIRD_EXPLOSION = builder.comment("Explosion Effect of the third Explosion").defineEnum("explosionType", CustomTNTConfig.NO_EXPLOSION);
		CUSTOM_TNT_THIRD_EXPLOSION_INTENSITY = builder.comment("Multiplier to the power of the third explosion").defineInRange("explosionIntensity", 1, 1, 20);
		builder.pop();
		builder.comment("Special Events Settings").push("Event Settings");
		SEASON_EVENTS_ALWAYS_ACTIVE = builder.comment("Whether season specific events ignore the date").define("seasonEventsAlwaysActive", false);
		PRESENT_DROP_DESTROY_BLOCKS = builder.comment("Whether the Present Drop destroys blocks").define("presentDropDestroy", true);
		builder.pop();
		builder.comment("Contaminated Effect Overlay Settings").push("Render Overlay Settings");
		RENDER_CONTAMINATED_OVERLAY = builder.comment("Whether an Overlay is rendererd while the Contaminated Effect is active").define("renderContaminatedOverlay", true);
		builder.pop();
	}
}
