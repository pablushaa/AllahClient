package ua.AllahClient.ModuleSystem.Modules.movement;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class Bhop extends Module {
	public Bhop() {
		super("Bhop", 0x00, Category.Movement);
	}
	
	public void onUpdate() {
		mc.gameSettings.keyBindForward.pressed = true;
		mc.player.setSprinting(true);
		if(mc.player.onGround) {
			mc.player.jump();
		}
	}
	
	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
		mc.player.setSprinting(false);
	}

}