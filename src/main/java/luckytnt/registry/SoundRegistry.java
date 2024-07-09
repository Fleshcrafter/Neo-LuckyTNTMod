package luckytnt.registry;

import luckytnt.LuckyTNTMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NewRegistryEvent;

@EventBusSubscriber(modid = LuckyTNTMod.MODID, bus = Bus.MOD)
public class SoundRegistry {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, LuckyTNTMod.MODID);
	
	public static DeferredHolder<SoundEvent, SoundEvent> SAY_GOODBYE = register("say_goodbye");
	public static DeferredHolder<SoundEvent, SoundEvent> DEATH_RAY = register("death_ray");
	public static DeferredHolder<SoundEvent, SoundEvent> VACUUM_CLEANER_START = register("vacuum_cleaner_start");
	public static DeferredHolder<SoundEvent, SoundEvent> VACUUM_CLEANER = register("vacuum_cleaner");
	
	public static DeferredHolder<SoundEvent, SoundEvent> register(String name){
		return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(LuckyTNTMod.MODID, name)));
	}

	@SubscribeEvent
	public static void dummyRegisterEvent(NewRegistryEvent event) {	}
}
