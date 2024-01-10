package ua.AllahClient.ModuleSystem.Modules.Combat;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.EnumHand;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class CrystalAura extends Module {

	public CrystalAura() {
		super("CrystalAura", Keyboard.KEY_X, Category.Combat);
	}
	
    public void onUpdate() {
        for(Entity ent: mc.world.loadedEntityList) {
            if(ent instanceof EntityEnderCrystal) {
                if (mc.player.getDistanceToEntity(ent) <= 5) {
                    mc.playerController.attackEntity(mc.player, ent);
                    mc.player.swingArm(EnumHand.MAIN_HAND);
                }
            }
        }
    }
	
}
