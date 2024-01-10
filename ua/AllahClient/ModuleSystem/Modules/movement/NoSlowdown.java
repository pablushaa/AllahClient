package ua.AllahClient.ModuleSystem.Modules.movement;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class NoSlowdown extends Module {
	public static Module mod;
	public NoSlowdown() {
		super("NoSlowdown", 0x00, Category.Movement);
		mod = this;
	}

}
