package ua.AllahClient.ModuleSystem.Modules.Render;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

import org.lwjgl.input.Keyboard;

public class Light extends Module {

    public Light() {
        super("Light", Keyboard.KEY_L, Category.Render);
    }

    float gamma;

    public void onEnable() {
        Minecraft mc = Minecraft.getMinecraft();
        gamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 1000000f;
    }

    public void onDisable() {
        Minecraft mc = Minecraft.getMinecraft();
        mc.gameSettings.gammaSetting = gamma;
    }
}