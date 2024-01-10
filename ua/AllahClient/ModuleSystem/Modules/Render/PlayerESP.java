package ua.AllahClient.ModuleSystem.Modules.Render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.AxisAlignedBB;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.util.RenderUtil;

public class PlayerESP extends Module {
	Minecraft mc = Minecraft.getMinecraft();
	AxisAlignedBB box = null;
	
	public PlayerESP() {
		super("PlayerESP", 0x00, Category.Render);
	}
	
	public void onRender2D() {
        for (Entity entity : mc.world.playerEntities) {
            if(entity != mc.player && entity != null) {
                entity.setGlowing(true);
            }
        }
    }

}
