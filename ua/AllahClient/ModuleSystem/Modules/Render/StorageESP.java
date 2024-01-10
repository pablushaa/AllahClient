package ua.AllahClient.ModuleSystem.Modules.Render;

import java.awt.Color;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.util.RenderUtil;

public class StorageESP extends Module {

	public StorageESP() {
		super("StorageESP", 0x00, Category.Render);
	}
	
	public void onRender() {
		for(TileEntity entity : mc.world.loadedTileEntityList) {
			if (entity instanceof TileEntityChest) {
				RenderUtil.blockESP(entity.getPos());
			}
		}
	}

}
