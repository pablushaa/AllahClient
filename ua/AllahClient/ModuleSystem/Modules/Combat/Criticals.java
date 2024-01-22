package ua.AllahClient.ModuleSystem.Modules.Combat;

import net.minecraft.block.material.Material;
import net.minecraft.network.play.client.CPacketPlayer;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class Criticals extends Module {

	public static Criticals mod;
	
	public Criticals() {
		super("Criticals", 0x00, Category.Combat);
		mod = this;
	}
	
	public void doCrit() {
		if(!mc.player.isInWater() && !mc.player.isInsideOfMaterial(Material.LAVA) && mc.player.onGround) {
			double posX = mc.player.posX;
			double posY = mc.player.posY;
			double posZ = mc.player.posZ;
					
			mc.player.connection.sendPacket(new CPacketPlayer.Position(posX, posY + 0.0625D, posZ, true));
			mc.player.connection.sendPacket(new CPacketPlayer.Position(posX, posY, posZ, false));
			mc.player.connection.sendPacket(new CPacketPlayer.Position(posX, posY + 1.1E-5D, posZ, false));
			mc.player.connection.sendPacket(new CPacketPlayer.Position(posX, posY, posZ, false));
		}
	}

}
