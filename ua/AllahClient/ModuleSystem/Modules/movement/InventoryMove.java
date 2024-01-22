package ua.AllahClient.ModuleSystem.Modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class InventoryMove extends Module {
	//пасиба сосокгмд за строк клеент
	public InventoryMove() {
		super("InventoryMove", 0x00, Category.Movement);
	}
	
	public void onUpdate() {
		KeyBinding[] binds = {mc.gameSettings.keyBindForward,
							  mc.gameSettings.keyBindBack,
							  mc.gameSettings.keyBindLeft,
							  mc.gameSettings.keyBindRight,
							  mc.gameSettings.keyBindSprint,
							  mc.gameSettings.keyBindJump,
							  mc.gameSettings.keyBindSneak};
		
		for(KeyBinding bind : binds) {
			if(mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat)) {
				bind.setKeyBindState(bind.getKeyCode(), Keyboard.isKeyDown(bind.getKeyCode()));
			}
		}
	}

}
