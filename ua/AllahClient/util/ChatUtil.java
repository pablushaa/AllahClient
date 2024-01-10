package ua.AllahClient.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtil {
	public static void sendClientMessage(String msg) {
        String prefix = "[§6AllahClient§r] ";

        Minecraft mc = Minecraft.getMinecraft();
        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(prefix + msg));
    }
}
