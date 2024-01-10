package ua.AllahClient.ModuleSystem.Modules.Render;

import java.awt.Graphics2D;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.clickgui.*;

public class ClickGui extends Module {
	private ClickGUI cgui;
	public ClickGui() {
		super("ClickGui", Keyboard.KEY_RSHIFT, Category.Render);
	}
	
	public void onEnable() {
		if(cgui == null) {
			this.cgui = new ClickGUI();
		}
		
		if (mc.currentScreen == null) {
			mc.displayGuiScreen(cgui);
		}
		this.enabled = false;
	}
}
