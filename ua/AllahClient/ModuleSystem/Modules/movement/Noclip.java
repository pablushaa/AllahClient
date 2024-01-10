package ua.AllahClient.ModuleSystem.Modules.movement;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class Noclip extends Module {

	public Noclip() {
		super("Noclip", 0x00, Category.Movement);
	}

	public void onUpdate() {
		mc.player.noClip = true;
	}

}
