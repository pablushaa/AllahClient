package ua.AllahClient.ModuleSystem.Modules.Misc;

import java.io.File;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import ua.AllahClient.Client;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.util.FileManager;

public class SWAT extends Module {
	public static boolean swatted = false;
	public static Module mod;
	public SWAT() {
		super("SWAT", Keyboard.KEY_F10, Category.Misc);
		mod = this;
	}
	
	public void onEnable() {
		swatted = true;
		RPC.discordRPC.Discord_Shutdown();
		for(Module m : Client.loader.getModules()) {
            if(m != this) {
                m.setToggled(false);
            }
        }
		
		Display.setTitle("Minecraft 1.12.2");
		FileManager.deleteFolder(new File("alah"));
		FileManager.deleteFolder(new File("ViaMCP"));
	}
	
	public void onDisable() {
        Display.setTitle(Client.name);
        swatted = false;
    }
}
