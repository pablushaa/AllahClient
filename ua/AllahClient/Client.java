package ua.AllahClient;

import net.minecraft.client.Minecraft;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.ModuleSystem.ModuleLoader;
import ua.AllahClient.ModuleSystem.Modules.Misc.RPC;
import ua.AllahClient.ModuleSystem.Modules.Misc.SWAT;
import ua.AllahClient.ModuleSystem.Modules.Render.HUD;
import ua.AllahClient.util.FileManager;
import viamcp.ViaMCP;

public class Client {

	public static String name = "AllahClient v1.0";
	public static String version = "1.0";
	public static ModuleLoader loader;
	public static Minecraft mc;
	public static FileManager fileMgr;
	
	public void setup(Minecraft minecraft) {
		mc = minecraft;
		loader = new ModuleLoader();
		loader.loadModules();
		fileMgr = new FileManager();
		fileMgr.init();
		System.out.println("[AllahClient] Activated!");
		HUD.mod.setToggled(true);
		ViaMCP.getInstance().start();
	}
	
	public static void stop() {
		Client.fileMgr.saveMods();
	}
	
	public static ModuleLoader mLoader() {
		return loader;
	}
	
	public static void onKeyPress(int bind) {
		if (mc.currentScreen == null) {
			for(Module m : loader.getModules()) {
				if(m == SWAT.mod && m.getBind() == bind) {
					m.toggle();
					return;
				}
				if(m.getBind() == bind && !SWAT.swatted) {
					m.toggle();
				}
			}
		}
	}
}
