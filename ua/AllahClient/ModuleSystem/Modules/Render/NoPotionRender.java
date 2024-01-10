package ua.AllahClient.ModuleSystem.Modules.Render;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class NoPotionRender extends Module {
	public static Module mod;
	public NoPotionRender() {
		super("NoPotionRender", 0x00, Category.Render);
		mod = this;
	}
}
