package ua.AllahClient.ModuleSystem.Modules.Player;

import net.minecraft.network.play.client.CPacketPlayer;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class NoFall extends Module {

	public NoFall() {
		super("NoFall", 0x00, Category.Player);
	}
	
	public void onUpdate() {
		if(mc.player.fallDistance > 1.0f) {
			mc.player.connection.sendPacket(new CPacketPlayer(true));
		}
	}

}
