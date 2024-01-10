package ua.AllahClient.ModuleSystem.Modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_V, Category.Movement);
    }

    public void onUpdate() {
        if(this.enabled) {
            if(mc.player.onGround) {
                mc.player.motionX *= 1.65;
                mc.player.motionZ *= 1.65;
            }
        }
    }
}
