package ua.AllahClient.ModuleSystem.Modules.movement;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class AirJump extends Module {

	public AirJump() {
		super("AirJump", 0, Category.Movement);
	}
	
	public void onUpdate() {
        if(mc.gameSettings.keyBindJump.isPressed()) {
        	mc.player.jump();
        }
	}
}
