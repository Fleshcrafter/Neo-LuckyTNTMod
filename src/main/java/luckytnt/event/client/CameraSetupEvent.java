package luckytnt.event.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ViewportEvent.ComputeCameraAngles;

@EventBusSubscriber(value = Dist.CLIENT)
public class CameraSetupEvent {

	@SubscribeEvent
	public static void setupCameraAngles(ComputeCameraAngles event) {
		Minecraft minecraft = Minecraft.getInstance();
		LocalPlayer player = minecraft.player;
		if(player != null && player.getPersistentData().getInt("shakeTime") >= 1) {
			float shakeAmount = 4f;
			event.setYaw(event.getYaw() + (float)shakeAmount * (float)Math.cos((Math.random() * 5f + 1f) * 3d * ((float)player.getPersistentData().getInt("shakeTime")) / 20f));
			event.setPitch(event.getPitch() + (float)shakeAmount * (float)Math.cos((Math.random() * 3f + 1f) * 3d * ((float)player.getPersistentData().getInt("shakeTime")) / 20f));
			event.setRoll(event.getRoll() + (float)shakeAmount * (float)Math.cos((Math.random() * 4f + 1f) * 3d * ((float)player.getPersistentData().getInt("shakeTime")) / 20f));
		}
	}
}
