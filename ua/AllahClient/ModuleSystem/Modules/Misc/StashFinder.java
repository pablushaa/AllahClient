package ua.AllahClient.ModuleSystem.Modules.Misc;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.util.ChatUtil;

public class StashFinder extends Module {

	public StashFinder() {
		super("StashFinder", 0x00, Category.Misc);
	}
	
	int counter = 0;
	public ArrayList<TileEntity> found = new ArrayList<TileEntity>(); // тихо спиздил и ушел называется я сам придумал

	public void onUpdate() {
		for (TileEntity c : mc.world.loadedTileEntityList) {
			if(!found.contains(c)) {
				if (c instanceof TileEntityChest) {
	                counter++;
	                found.add(c);
	            }
	            if (c instanceof TileEntityShulkerBox) {
	                counter++;
	                found.add(c);
	            }
	            if(counter > 5) {
	                ChatUtil.sendClientMessage("Found stash at " + getCoords(c.getPos()));
	                counter = 0;
	                return;
	            }
			}
        }
	}
	
	public String getCoords(BlockPos p) {
		return "X: " + Integer.toString(p.getX()) + " " +
			"Y: " + Integer.toString(p.getY()) + " " +
			"Z: " + Integer.toString(p.getZ());
	}
	
}
