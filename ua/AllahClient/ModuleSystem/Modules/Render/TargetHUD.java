package ua.AllahClient.ModuleSystem.Modules.Render;

import java.awt.Color;
import java.util.Objects;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.util.RenderUtil;
import ua.AllahClient.util.RoundUtil;

public class TargetHUD extends Module {

	public TargetHUD() {
		super("TargetHUD", 0x00, Category.Render);
	}
	
	public void onRender2D() {
		RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
		
		try {
			if (objectMouseOver != null) {
	            if (objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
	            	Entity target = objectMouseOver.entityHit;
	            	EntityPlayer player = (EntityPlayer) target;
	            	final float health = Math.round(player.getHealth());
	            	if (target instanceof EntityPlayer) {
	            		RoundUtil.drawSelectRoundedRect(mc.displayWidth / 2f - 200, mc.displayHeight / 2f - 60, mc.displayWidth / 2f, mc.displayHeight / 2f, 20, 0, 0, 0, 0xCF0F0F0F);
	            		
	            		RenderUtil.drawString(mc.fontRendererObj, target.getName(), mc.displayWidth / 2f - 140, mc.displayHeight / 2f - 54, -1);
	            		RenderUtil.drawString(mc.fontRendererObj, "HP: " + health, mc.displayWidth / 2f - 140, mc.displayHeight / 2f - 40, -1);
	            		
	            		RenderUtil.drawRect(mc.displayWidth / 2f - 140, mc.displayHeight / 2f - 20, 120, 5, new Color(255,0,0,255).getRGB());
	            		RenderUtil.drawRect(mc.displayWidth / 2f - 140, mc.displayHeight / 2f - 20, 120 / 20 * health, 5, new Color(127,106,0,255).getRGB());
	            		try {
	                		drawHead(Objects.requireNonNull(mc.getConnection()).getPlayerInfo(target.getUniqueID()).getLocationSkin(), 10, 10);
	            		}  catch (Exception ignored) {}
	            	}
	            }
	        }
		} catch (Exception ignored) {}
	}
	public void drawHead(ResourceLocation skin, int width, int height) {
		GL11.glColor4f(1, 1, 1, 1);
	    mc.getTextureManager().bindTexture(skin);
	    Gui.drawScaledCustomSizeModalRect(mc.displayWidth / 2f - 194, mc.displayHeight / 2f - 54, 8, 8, 8, 8, 48, 48, 64, 64);
	}
}
