package luckytnt.config;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class LuckyTNTConfigs {
	
	public static void registerCommonConfig(ModContainer container) {
		ModConfigSpec.Builder S_BUILDER = new ModConfigSpec.Builder();
		LuckyTNTConfigValues.registerConfig(S_BUILDER);
		container.registerConfig(ModConfig.Type.COMMON, S_BUILDER.build());
	}
}
