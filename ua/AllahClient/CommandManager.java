package ua.AllahClient;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import ua.AllahClient.ModuleSystem.Modules.Combat.KillAura;
import ua.AllahClient.ModuleSystem.Modules.Misc.Spammer;
import ua.AllahClient.ModuleSystem.Modules.Render.PlayerESP;
import ua.AllahClient.ModuleSystem.Modules.movement.Fly;
import ua.AllahClient.util.ChatUtil;

public class CommandManager {
	Minecraft mc = Minecraft.getMinecraft();
	
	public void onCommand(String c) {
		if(c.startsWith("#help set")) {
			ChatUtil.sendClientMessage("spammer: time, text");
			ChatUtil.sendClientMessage("fly: speed");
			ChatUtil.sendClientMessage("killaura: range, clientrot [bool], hitbox [bool] (works only in client rotations)");
			ChatUtil.sendClientMessage("playersp: mode (boxed, glow)");
			return;
		}
		if(c.startsWith("#help")) {
			ChatUtil.sendClientMessage("#help set - shows the modules and their settings");
			ChatUtil.sendClientMessage("#set - sets the value of module");
			ChatUtil.sendClientMessage("#info (moduleName) - shows module settings");
			ChatUtil.sendClientMessage("#move x, y, z - moves you in position");
		}
		
		
		if(c.startsWith("#set spammer time ")) {
			Spammer.time = Float.parseFloat(c.replace("#set spammer time ", ""));
			ChatUtil.sendClientMessage("Succesfully set time to " + c.replace("#set spammer time ", ""));
		}
		if(c.startsWith("#set spammer text ")) {
			String text = c.replace("#set spammer text ", "");
			Spammer.text = text;
			ChatUtil.sendClientMessage("Succesfully set text to " + text);
		}
		
		if(c.startsWith("#set fly speed ")) {
			Fly.sped = Float.parseFloat(c.replace("#set fly speed ", "")) / 10;
			ChatUtil.sendClientMessage("Succesfully set speed to " + c.replace("#set fly speed ", ""));
		}
		
		if(c.startsWith("#set killaura range ")) {
			KillAura.range = Float.parseFloat(c.replace("#set killaura range ", ""));
			ChatUtil.sendClientMessage("Succesfully set range to " + c.replace("#set killaura range ", ""));
		}
		
		if(c.startsWith("#set killaura clientrot ")) {
			KillAura.clientrot = Boolean.parseBoolean(c.replace("#set killaura clientrot ", ""));
			ChatUtil.sendClientMessage("Succesfully set client rotations to " + c.replace("#set killaura clientrot ", ""));
		}
		
		if(c.startsWith("#set killaura hitbox ")) {
			if(KillAura.clientrot) {
				KillAura.hitbox = Boolean.parseBoolean(c.replace("#set killaura hitbox ", ""));
				ChatUtil.sendClientMessage("Succesfully set hitbox mode to " + c.replace("#set killaura hitbox ", ""));
			} else {
				ChatUtil.sendClientMessage("Hitbox mode only works with client rotations");
			}
		}
		
		if(c.startsWith("#set playeresp mode ")) {
			PlayerESP.mode = c.replace("#set playeresp mode ", "");
			ChatUtil.sendClientMessage("Succesfully set playeresp mode to " + c.replace("#set playeresp mode ", ""));
		}
		
		if(c.startsWith("#info spammer")) {
			ChatUtil.sendClientMessage("Time: " + Float.toString(Spammer.time));
			ChatUtil.sendClientMessage("Text: " + Spammer.text);
		}
		
		if(c.startsWith("#info fly")) {
			ChatUtil.sendClientMessage("Speed: " + Float.toString(Fly.sped * 10));
		}
		
		if(c.startsWith("#info killaura")) {
			ChatUtil.sendClientMessage("Range: " + Float.toString(KillAura.range));
			ChatUtil.sendClientMessage("Client rotations: " + Boolean.toString(KillAura.clientrot));
			ChatUtil.sendClientMessage("Hitbox mode: " + Boolean.toString(KillAura.hitbox));
		}
		if(c.startsWith("#info playeresp")) {
			ChatUtil.sendClientMessage("Mode: " + PlayerESP.mode);
		}
		
		if(c.startsWith("#move")) {
			try {
				String[] coords = c.replace("#move ", "").split(" ");
				mc.player.setPosition(mc.player.posX + Float.parseFloat(coords[0]), mc.player.posY + Float.parseFloat(coords[1]), mc.player.posZ + Float.parseFloat(coords[2]));
			} catch (Exception e) {
				ChatUtil.sendClientMessage("OTVAL");
			}
		}
	}
}
