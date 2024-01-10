package ua.AllahClient.ModuleSystem.Modules.Render;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class AntiOverlay extends Module {
	public static Module mod;
	public AntiOverlay() {
		super("AntiOverlay", 0x00, Category.Render);
		mod = this;
	}

}
