package ua.AllahClient.ModuleSystem.Modules.movement;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class Up extends Module {

	public Up() {
		super("Up", 0x00, Category.Movement);
	}
	
	public void onEnable() {
		mc.player.setPosition(mc.player.posX, mc.player.posY + 3, mc.player.posZ);
		this.enabled = false;
	}

}
