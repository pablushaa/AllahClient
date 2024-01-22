package ua.AllahClient.ModuleSystem.Modules.Combat;

import java.util.Comparator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class TriggerBot extends Module {

	public TriggerBot() {
		super("TriggerBot", 0x00, Category.Combat);
	}
	
	public void onUpdate() {
		if (mc.player.getCooledAttackStrength(0) == 1) {
			try {
				RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
				if (objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY && objectMouseOver != null) {
					if(Criticals.mod.enabled) {
						Criticals.mod.doCrit();
					}
					mc.clickMouse();
				}
			} catch(Exception ignored) {}
		}
	}

}
