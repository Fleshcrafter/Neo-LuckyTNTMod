package luckytnt.registry;

import java.util.List;

import luckytnt.LuckyTNTMod;
import luckytnt.item.DeathRayRayItem;
import luckytnt.item.VacuumCleaner;
import luckytntlib.item.LDynamiteItem;
import luckytntlib.item.LTNTMinecartItem;
import luckytntlib.item.LuckyDynamiteItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber(modid = LuckyTNTMod.MODID, bus = Bus.MOD)
public class ItemRegistry {

	//Dynamite
	public static final DeferredItem<LDynamiteItem> DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("dynamite", EntityRegistry.DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> DYNAMITE_X5 = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("dynamite_x5", EntityRegistry.DYNAMITE_X5, "dy");
	public static final DeferredItem<LDynamiteItem> DYNAMITE_X20 = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("dynamite_x20", EntityRegistry.DYNAMITE_X20, "dy");
	public static final DeferredItem<LDynamiteItem> DYNAMITE_X100 = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("dynamite_x100", EntityRegistry.DYNAMITE_X100, "dy");
	public static final DeferredItem<LDynamiteItem> DYNAMITE_X500 = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("dynamite_x500", EntityRegistry.DYNAMITE_X500, "dy");
	public static final DeferredItem<LDynamiteItem> FIRE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("fire_dynamite", EntityRegistry.FIRE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> SNOW_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("snow_dynamite", EntityRegistry.SNOW_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> DYNAMITE_FIREWORK = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("dynamite_firework", EntityRegistry.DYNAMITE_FIREWORK, "dy");
	public static final DeferredItem<LDynamiteItem> NUCLEAR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("nuclear_dynamite", EntityRegistry.NUCLEAR_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> FREEZE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("freeze_dynamite", EntityRegistry.FREEZE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> FLOATING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("floating_dynamite", EntityRegistry.FLOATING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> SPHERE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("sphere_dynamite", EntityRegistry.SPHERE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> FLAT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("flat_dynamite", EntityRegistry.FLAT_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> MININGFLAT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("miningflat_dynamite", EntityRegistry.MININGFLAT_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> VAPORIZE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("vaporize_dynamite", EntityRegistry.VAPORIZE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> METEOR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("meteor_dynamite", EntityRegistry.METEOR_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> CUBIC_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("cubic_dynamite", EntityRegistry.CUBIC_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> GROVE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("grove_dynamite", EntityRegistry.GROVE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ENDER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("ender_dynamite", EntityRegistry.ENDER_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ARROW_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("arrow_dynamite", EntityRegistry.ARROW_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> LIGHTNING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("lightning_dynamite", EntityRegistry.LIGHTNING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> DIGGING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("digging_dynamite", EntityRegistry.DIGGING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> COMPACT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("compact_dynamite", EntityRegistry.COMPACT_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ANIMAL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("animal_dynamite", EntityRegistry.ANIMAL_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> OCEAN_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("ocean_dynamite", EntityRegistry.OCEAN_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> SPIRAL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("spiral_dynamite", EntityRegistry.SPIRAL_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> CHEMICAL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("chemical_dynamite", EntityRegistry.CHEMICAL_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> REACTION_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("reaction_dynamite", EntityRegistry.REACTION_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> HELLFIRE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("hellfire_dynamite", EntityRegistry.HELLFIRE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> FLOATING_ISLAND_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("floating_island_dynamite", EntityRegistry.FLOATING_ISLAND_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ERUPTING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("erupting_dynamite", EntityRegistry.ERUPTING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> SHATTERPROOF_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("shatterproof_dynamite", EntityRegistry.SHATTERPROOF_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> LAVA_OCEAN_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("lava_ocean_dynamite", EntityRegistry.LAVA_OCEAN_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> WOOL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("wool_dynamite", EntityRegistry.WOOL_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> NUCLEAR_WASTE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("nuclear_waste_dynamite", EntityRegistry.NUCLEAR_WASTE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> TIMER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("timer_dynamite", EntityRegistry.TIMER_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> GRAVITY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("gravity_dynamite", EntityRegistry.GRAVITY_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> WITHERING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("withering_dynamite", EntityRegistry.WITHERING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> SENSOR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("sensor_dynamite", EntityRegistry.SENSOR_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> RAINBOW_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("rainbow_dynamite", EntityRegistry.RAINBOW_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ROULETTE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("roulette_dynamite", EntityRegistry.ROULETTE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> BOUNCING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("bouncing_dynamite", EntityRegistry.BOUNCING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> IGNITER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("igniter_dynamite", EntityRegistry.IGNITER_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> MULTIPLYING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("multiplying_dynamite", EntityRegistry.MULTIPLYING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> RANDOM_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("random_dynamite", EntityRegistry.RANDOM_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> HOMING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("homing_dynamite", EntityRegistry.HOMING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> PULSE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("pulse_dynamite", EntityRegistry.PULSE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> PHYSICS_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("physics_dynamite", EntityRegistry.PHYSICS_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> PICKY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("picky_dynamite", EntityRegistry.PICKY_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> CLUSTER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("cluster_dynamite", EntityRegistry.CLUSTER_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> TUNNELING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("tunneling_dynamite", EntityRegistry.TUNNELING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> XRAY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("xray_dynamite", EntityRegistry.XRAY_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> FARMING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("farming_dynamite", EntityRegistry.FARMING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> BIG_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("big_dynamite", EntityRegistry.BIG_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ICE_METEOR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("ice_meteor_dynamite", EntityRegistry.ICE_METEOR_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> HONEY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("honey_dynamite", EntityRegistry.HONEY_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ULTRALIGHT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("ultralight_dynamite", EntityRegistry.ULTRALIGHT_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> ACCELERATING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("accelerating_dynamite", EntityRegistry.ACCELERATING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> NETHER_GROVE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("nether_grove_dynamite", EntityRegistry.NETHER_GROVE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> LUSH_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("lush_dynamite", EntityRegistry.LUSH_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> DRIPSTONE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("dripstone_dynamite", EntityRegistry.DRIPSTONE_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> END_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("end_dynamite", EntityRegistry.END_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> CHRISTMAS_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("christmas_dynamite", EntityRegistry.CHRISTMAS_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> PRISM_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("prism_dynamite", EntityRegistry.PRISM_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> RING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("ring_dynamite", EntityRegistry.RING_DYNAMITE, "dy");
	public static final DeferredItem<LDynamiteItem> SCULK_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItemViaProjectile("sculk_dynamite", EntityRegistry.SCULK_DYNAMITE, "dy");
	
	public static final DeferredItem<LDynamiteItem> LUCKY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem(LuckyTNTMod.itemRegistry, "lucky_dynamite", () -> new LuckyDynamiteItem(new Item.Properties(), LuckyTNTMod.RH.dynamiteLists.get("dy")), "dy", false, true);
	
	//Minecart
	public static final DeferredItem<LTNTMinecartItem> TNT_X5_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x5_minecart", () -> EntityRegistry.TNT_X5_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> TNT_X20_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x20_minecart", () -> EntityRegistry.TNT_X20_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> TNT_X100_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x100_minecart", () -> EntityRegistry.TNT_X100_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> TNT_X500_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x500_minecart", () -> EntityRegistry.TNT_X500_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> DIGGING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("digging_tnt_minecart", () -> EntityRegistry.DIGGING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> DRILLING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("drilling_tnt_minecart", () -> EntityRegistry.DRILLING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> SPHERE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("sphere_tnt_minecart", () -> EntityRegistry.SPHERE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> FLOATING_ISLAND_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("floating_island_minecart", () -> EntityRegistry.FLOATING_ISLAND_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> OCEAN_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ocean_tnt_minecart", () -> EntityRegistry.OCEAN_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> HELLFIRE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("hellfire_tnt_minecart", () -> EntityRegistry.HELLFIRE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> FIRE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("fire_tnt_minecart", () -> EntityRegistry.FIRE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> SNOW_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("snow_tnt_minecart", () -> EntityRegistry.SNOW_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> FREEZE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("freeze_tnt_minecart", () -> EntityRegistry.FREEZE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> VAPORIZE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("vaporize_tnt_minecart", () -> EntityRegistry.VAPORIZE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> GRAVITY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("gravity_tnt_minecart", () -> EntityRegistry.GRAVITY_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> LIGHTNING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lightning_tnt_minecart", () -> EntityRegistry.LIGHTNING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> CUBIC_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("cubic_tnt_minecart", () -> EntityRegistry.CUBIC_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ARROW_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("arrow_tnt_minecart", () -> EntityRegistry.ARROW_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> TIMER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("timer_tnt_minecart", () -> EntityRegistry.TIMER_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> FLAT_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("flat_tnt_minecart", () -> EntityRegistry.FLAT_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> MININGFLAT_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("miningflat_tnt_minecart", () -> EntityRegistry.MININGFLAT_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> COMPACT_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("compact_tnt_minecart", () -> EntityRegistry.COMPACT_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ANIMAL_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("animal_tnt_minecart", () -> EntityRegistry.ANIMAL_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ERUPTING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("erupting_tnt_minecart", () -> EntityRegistry.ERUPTING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> GROVE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("grove_tnt_minecart", () -> EntityRegistry.GROVE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ENDER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ender_tnt_minecart", () -> EntityRegistry.ENDER_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> METEOR_SHOWER_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("meteor_shower_minecart", () -> EntityRegistry.METEOR_SHOWER_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> INVERTED_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("inverted_tnt_minecart", () -> EntityRegistry.INVERTED_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> NUCLEAR_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("nuclear_tnt_minecart", () -> EntityRegistry.NUCLEAR_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> CHEMICAL_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("chemical_tnt_minecart", () -> EntityRegistry.CHEMICAL_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> REACTION_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("reaction_tnt_minecart", () -> EntityRegistry.REACTION_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> VILLAGE_DEFENSE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("village_defense_minecart", () -> EntityRegistry.VILLAGE_DEFENSE_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ZOMBIE_APOCALYPSE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("zombie_apocalypse_minecart", () -> EntityRegistry.ZOMBIE_APOCALYPSE_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> SHATTERPROOF_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("shatterproof_tnt_minecart", () -> EntityRegistry.SHATTERPROOF_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> LAVA_OCEAN_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lava_ocean_tnt_minecart", () -> EntityRegistry.LAVA_OCEAN_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> WOOL_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("wool_tnt_minecart", () -> EntityRegistry.WOOL_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> SAY_GOODBYE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("say_goodbye_minecart", () -> EntityRegistry.SAY_GOODBYE_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ANGRY_MINERS_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("angry_miners_minecart", () -> EntityRegistry.ANGRY_MINERS_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> WITHERING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("withering_tnt_minecart", () -> EntityRegistry.WITHERING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> PUMPKIN_BOMB_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("pumpkin_bomb_minecart", () -> EntityRegistry.PUMPKIN_BOMB_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> NUCLEAR_WASTE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("nuclear_waste_tnt_minecart", () -> EntityRegistry.NUCLEAR_WASTE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> AIR_STRIKE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("air_strike_minecart", () -> EntityRegistry.AIR_STRIKE_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> SPAMMING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("spamming_tnt_minecart", () -> EntityRegistry.SPAMMING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ROULETTE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("roulette_tnt_minecart", () -> EntityRegistry.ROULETTE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> XRAY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("xray_tnt_minecart", () -> EntityRegistry.XRAY_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> FARMING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("farming_tnt_minecart", () -> EntityRegistry.FARMING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> SWAP_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("swap_tnt_minecart", () -> EntityRegistry.SWAP_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> IGNITER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("igniter_tnt_minecart", () -> EntityRegistry.IGNITER_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> BUTTER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("butter_tnt_minecart", () -> EntityRegistry.BUTTER_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> PHYSICS_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("physics_tnt_minecart", () -> EntityRegistry.PHYSICS_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> ORE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ore_tnt_minecart", () -> EntityRegistry.ORE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> REDSTONE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("redstone_tnt_minecart", () -> EntityRegistry.REDSTONE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> RANDOM_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("random_tnt_minecart", () -> EntityRegistry.RANDOM_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> TURRET_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("turret_tnt_minecart", () -> EntityRegistry.TURRET_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> PULSE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("pulse_tnt_minecart", () -> EntityRegistry.PULSE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> PICKY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("picky_tnt_minecart", () -> EntityRegistry.PICKY_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> BIG_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("big_tnt_minecart", () -> EntityRegistry.BIG_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> HONEY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("honey_tnt_minecart", () -> EntityRegistry.HONEY_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> EATING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("eating_tnt_minecart", () -> EntityRegistry.EATING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> LUSH_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lush_tnt_minecart", () -> EntityRegistry.LUSH_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> GEODE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("geode_tnt_minecart", () -> EntityRegistry.GEODE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> NETHER_GROVE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("nether_grove_tnt_minecart", () -> EntityRegistry.NETHER_GROVE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> DRIPSTONE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("dripstone_tnt_minecart", () -> EntityRegistry.DRIPSTONE_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> END_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("end_tnt_minecart", () -> EntityRegistry.END_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> PRISM_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("prism_tnt_minecart", () -> EntityRegistry.PRISM_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> RING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ring_tnt_minecart", () -> EntityRegistry.RING_TNT_MINECART, "m");
	public static final DeferredItem<LTNTMinecartItem> SCULK_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("sculk_tnt_minecart", () -> EntityRegistry.SCULK_TNT_MINECART, "m");
	
	public static final DeferredItem<LTNTMinecartItem> LUCKY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lucky_tnt_minecart", () -> new LTNTMinecartItem(new Item.Properties().stacksTo(1), () -> EntityRegistry.LUCKY_TNT_MINECART), "m", false, true);
	
	//Other
	public static final DeferredItem<Item> NUCLEAR_WASTE = LuckyTNTMod.itemRegistry.register("nuclear_waste", () -> new BlockItem(BlockRegistry.NUCLEAR_WASTE.get(), new Item.Properties()));
	public static final DeferredItem<Item> RED_CANDY = LuckyTNTMod.itemRegistry.register("red_candy", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().fast().nutrition(1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 2), 1).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0), 1).build())));
	public static final DeferredItem<Item> GREEN_CANDY = LuckyTNTMod.itemRegistry.register("green_candy", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().fast().nutrition(1).effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 2), 1).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2), 1).build())));
	public static final DeferredItem<Item> BLUE_CANDY = LuckyTNTMod.itemRegistry.register("blue_candy", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().fast().nutrition(1).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0), 1).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500, 2), 1).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 0).build())));
	public static final DeferredItem<Item> PURPLE_CANDY = LuckyTNTMod.itemRegistry.register("purple_candy", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().fast().nutrition(1).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 3), 1).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 2000, 1), 1).build())));
	public static final DeferredItem<Item> YELLOW_CANDY = LuckyTNTMod.itemRegistry.register("yellow_candy", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().fast().nutrition(1).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2000, 3), 1).build())));;
	public static final DeferredItem<Item> URANIUM_INGOT = LuckyTNTMod.itemRegistry.register("uranium_ingot", () -> new Item(new Item.Properties()));
	public static final DeferredItem<Item> ANTIMATTER = LuckyTNTMod.itemRegistry.register("antimatter", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)) {
		@Override
		public void appendHoverText(ItemStack stack, Item.TooltipContext ctx, List<Component> components, TooltipFlag flag) {
			super.appendHoverText(stack, ctx, components, flag);
			components.add(Component.translatable("item.antimatter.info"));
		}
	});
	public static final DeferredItem<Item> URANIUM_ORE = LuckyTNTMod.itemRegistry.register("uranium_ore", () -> new BlockItem(BlockRegistry.URANIUM_ORE.get(), new Item.Properties()));
	public static final DeferredItem<Item> DEEPSLATE_URANIUM_ORE = LuckyTNTMod.itemRegistry.register("deepslate_uranium_ore", () -> new BlockItem(BlockRegistry.DEEPSLATE_URANIUM_ORE.get(), new Item.Properties()));
	public static final DeferredItem<Item> GUNPOWDER_ORE = LuckyTNTMod.itemRegistry.register("gunpowder_ore", () -> new BlockItem(BlockRegistry.GUNPOWDER_ORE.get(), new Item.Properties()));
	public static final DeferredItem<Item> DEEPSLATE_GUNPOWDER_ORE = LuckyTNTMod.itemRegistry.register("deepslate_gunpowder_ore", () -> new BlockItem(BlockRegistry.DEEPSLATE_GUNPOWDER_ORE.get(), new Item.Properties()));
	public static final DeferredItem<Item> CONFIGURATION_WAND = LuckyTNTMod.itemRegistry.register("configuration_wand", () -> new Item(new Item.Properties().stacksTo(1)) {
		@Override
		public void appendHoverText(ItemStack stack, Item.TooltipContext ctx, List<Component> components, TooltipFlag flag) {
			super.appendHoverText(stack, ctx, components, flag);
			components.add(Component.translatable("item.configuration_wand.info"));
		}
	});
	public static final DeferredItem<Item> OBSIDIAN_RAIL = LuckyTNTMod.itemRegistry.register("obsidian_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_RAIL.get(), new Item.Properties()) {
		@Override
		public void appendHoverText(ItemStack stack, Item.TooltipContext ctx, List<Component> components, TooltipFlag flag) {
			super.appendHoverText(stack, ctx, components, flag);
			components.add(Component.translatable("item.obsidian_rail.info"));
		}
	});
	public static final DeferredItem<Item> OBSIDIAN_POWERED_RAIL = LuckyTNTMod.itemRegistry.register("obsidian_powered_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_POWERED_RAIL.get(), new Item.Properties()) {
		@Override
		public void appendHoverText(ItemStack stack, Item.TooltipContext ctx, List<Component> components, TooltipFlag flag) {
			super.appendHoverText(stack, ctx, components, flag);
			components.add(Component.translatable("item.obsidian_rail.info"));
		}
	});
	public static final DeferredItem<Item> OBSIDIAN_ACTIVATOR_RAIL = LuckyTNTMod.itemRegistry.register("obsidian_activator_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_ACTIVATOR_RAIL.get(), new Item.Properties()) {
		@Override
		public void appendHoverText(ItemStack stack, Item.TooltipContext ctx, List<Component> components, TooltipFlag flag) {
			super.appendHoverText(stack, ctx, components, flag);
			components.add(Component.translatable("item.obsidian_rail.info"));
		}
	});
	public static final DeferredItem<Item> OBSIDIAN_DETECTOR_RAIL = LuckyTNTMod.itemRegistry.register("obsidian_detector_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_DETECTOR_RAIL.get(),new Item.Properties()) {
		@Override
		public void appendHoverText(ItemStack stack, Item.TooltipContext ctx, List<Component> components, TooltipFlag flag) {
			super.appendHoverText(stack, ctx, components, flag);
			components.add(Component.translatable("item.obsidian_rail.info"));
		}
	});
	public static final DeferredItem<LDynamiteItem> DEATH_RAY_RAY = LuckyTNTMod.RH.registerDynamiteItem(LuckyTNTMod.itemRegistry, "death_ray_ray", () -> new DeathRayRayItem(), "none", false, true);
	public static final DeferredItem<Item> VACUUM_CLEANER = LuckyTNTMod.itemRegistry.register("vacuum_cleaner", () -> new VacuumCleaner());
	public static final DeferredItem<Item> TOXIC_STONE = LuckyTNTMod.itemRegistry.register("toxic_stone", () -> new BlockItem(BlockRegistry.TOXIC_STONE.get(), new Item.Properties()));

	@SubscribeEvent
	public static void dummyRegisterEvent(NewRegistryEvent event) {	}
}
