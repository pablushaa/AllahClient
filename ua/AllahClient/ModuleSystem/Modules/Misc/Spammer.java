package ua.AllahClient.ModuleSystem.Modules.Misc;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class Spammer extends Module {
	public static float time = 1.5f;
	public static String text = "looolus";

	public Spammer() {
		super("Spammer", 0x00, Category.Misc);
	}
	
	public void onUpdate() {
		if (mc.player.ticksExisted % (20 * time) == 0) {
			mc.player.sendChatMessage(text);
		}
	}

}
