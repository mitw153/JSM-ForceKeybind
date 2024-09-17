package mitw153.forcekeybind.mixins.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import mitw153.forcekeybind.ForceKeybind;
import mitw153.forcekeybind.jsmacros.FForceKeybind;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.wagyourtail.jsmacros.core.Core;

import java.util.List;
import java.util.function.Function;

import static mitw153.forcekeybind.ForceKeybind.mc;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
	@Unique
	private boolean shouldBypass() {
		return ForceKeybind.FORCE_KEYBIND && this.player != null && !mc.isPaused();
	}

	@Nullable
	@Shadow
	public ClientPlayerEntity player;

	@Inject(method = "createInitScreens", at = @At("HEAD"))
	public void createInitScreens(List<Function<Runnable, Screen>> list, CallbackInfo ci) {
		Core.getInstance().libraryRegistry.addLibrary(FForceKeybind.class);
	}

	@ModifyExpressionValue(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;", ordinal = 3))
	public Screen tick(Screen original) {
		return shouldBypass() ? null : original;
	}

	@ModifyExpressionValue(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;", ordinal = 6))
	public Screen tick2(Screen original) {
		return shouldBypass() ? null : original;
	}

	@ModifyExpressionValue(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;overlay:Lnet/minecraft/client/gui/screen/Overlay;", ordinal = 0))
	public Overlay tick3(Overlay original) {
		return shouldBypass() ? null : original;
	}
}