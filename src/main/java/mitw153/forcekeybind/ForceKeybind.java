package mitw153.forcekeybind;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForceKeybind implements ClientModInitializer {
	public static final String MOD_ID = "scriptlab";
	@SuppressWarnings("unused")
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftClient mc;
	public static boolean FORCE_KEYBIND = false;

	@Override
	public void onInitializeClient() {
		mc = MinecraftClient.getInstance();
	}
}