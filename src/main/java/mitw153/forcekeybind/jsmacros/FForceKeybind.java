package mitw153.forcekeybind.jsmacros;

import mitw153.forcekeybind.ForceKeybind;
import xyz.wagyourtail.jsmacros.core.library.BaseLibrary;
import xyz.wagyourtail.jsmacros.core.library.Library;

@SuppressWarnings("unused")
@Library("ForceKeybind")
public class FForceKeybind extends BaseLibrary {
	public void set(boolean on) {
		ForceKeybind.FORCE_KEYBIND = on;
	}
}