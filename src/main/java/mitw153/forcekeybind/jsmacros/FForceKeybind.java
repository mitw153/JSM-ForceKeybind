package mitw153.forcekeybind.jsmacros;

import mitw153.forcekeybind.ForceKeybind;
import xyz.wagyourtail.jsmacros.core.language.BaseScriptContext;
import xyz.wagyourtail.jsmacros.core.library.Library;
import xyz.wagyourtail.jsmacros.core.library.PerExecLibrary;

@SuppressWarnings("unused")
@Library("ForceKeybind")
public class FForceKeybind extends PerExecLibrary {
	private BaseScriptContext<?> wrappedContext;

	public FForceKeybind(BaseScriptContext<?> context) {
		super(context);
	}

	public void set(boolean on) {
		ForceKeybind.FORCE_KEYBIND = on;
	}
}