package ua.AllahClient.ModuleSystem.Modules.Render;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import ua.AllahClient.Client;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.util.RoundUtil;

public class HUD extends Module {
	
	public static Module mod;
	public HUD() {
		super("HUD", Keyboard.KEY_NONE, Category.Render);
		mod = this;
	}

	public void onRender2D() {
		int y = 5;
        final int[] counter = {1};
        Minecraft mc = Minecraft.getMinecraft();
        FontRenderer fr = mc.fontRendererObj;

        ScaledResolution sr = new ScaledResolution(mc);
        RoundUtil.drawSelectRoundedRect(0, 0, 150, 30, 0, 0, 20, 0, 0xCF0F0F0F);
        fr.drawStringWithShadow("Allah Client " + Client.version + " | " +
                Minecraft.getDebugFPS() + " FPS", 5, 5, -1);
        fr.drawStringWithShadow("Salam, §6" + mc.getSession().getUsername(), 5,
                15, 0xffffff);
        
        for (Module module : Client.loader.modules) {
            if(module.isEnabled()) {
                fr.drawStringWithShadow(module.getName(), sr.getScaledWidth() - 4 -
                        fr.getStringWidth(module.getName()), y, rainbow(counter[0] * 300));

                y += 10;
                counter[0]++;
            }
        }
	}
	
	public static int rainbow(int delay) {
        double rainbowState = Math.ceil(System.currentTimeMillis() + delay) / 20.0;
        rainbowState %= 360;
        return Color.getHSBColor((float) (rainbowState / 360.0f), 0.5f, 1f).getRGB();
    }
}
