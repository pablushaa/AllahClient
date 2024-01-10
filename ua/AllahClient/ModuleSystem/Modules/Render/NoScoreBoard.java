package ua.AllahClient.ModuleSystem.Modules.Render;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class NoScoreBoard extends Module {

	public static Module mod;
	public NoScoreBoard() {
		super("NoScoreBoard", 0x00, Category.Render);
		mod = this;
	}
}
