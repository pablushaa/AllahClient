package ua.AllahClient.ModuleSystem.Modules.Misc;

import club.minnced.discord.rpc.*;
import net.minecraft.client.Minecraft;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class RPC extends Module {

	public static Module mod;
	public RPC() {
		super("RPC", 0x00, Category.Misc);
	}
	
	private static final String APPLICATION_ID = "1171528099779858502";
	private Minecraft mc = Minecraft.getMinecraft();

	public static DiscordRPC discordRPC = DiscordRPC.INSTANCE;
	private DiscordEventHandlers handlers = new DiscordEventHandlers();
	private DiscordRichPresence presence = new DiscordRichPresence();
	
	public void onEnable() {
	    discordRPC.Discord_Initialize(APPLICATION_ID, handlers, true, null);
	    
	    presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.details = "Playing Minecraft 1.12.2";
        presence.largeImageKey = "allahclient";
        presence.largeImageText = "1.12.2";
        presence.state = "Menus";
        
        discordRPC.Discord_UpdatePresence(presence);
        
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                discordRPC.Discord_UpdatePresence(presence);
                try {
                	if(!mc.isSingleplayer()) {
                    	try {
                    		presence.state = mc.getCurrentServerData().serverIP;
                    	}
                    	catch (Exception e) {
                    		presence.state = "Menus";
                    	}
                    }
                    else {
                    	presence.state = "Singleplayer";
                    }
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        });
        thread.start();
	}
	
	public void onDisable() {
		discordRPC.Discord_Shutdown();
	}
}
