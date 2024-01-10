package ua.AllahClient.clickgui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import ua.AllahClient.Client;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;
import ua.AllahClient.ModuleSystem.ModuleLoader;
import ua.AllahClient.ModuleSystem.Modules.Render.HUD;
import ua.AllahClient.util.MouseUtil;
import ua.AllahClient.util.RenderUtil;
import ua.AllahClient.util.RoundUtil;

public class ClickGUI extends GuiScreen {
	
	private float x, y, lastX, lastY, width, height;
	private boolean dragging, binding;
	
	private Category selCat;
	private Module bindMod;
	
	public ClickGUI() {
		this.width = 450;
		this.height = 200;
		this.x = 20;
		this.y = 20;
		this.selCat = Category.Combat;
	}
	
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.smoothDrag(mouseX, mouseY);
		
		//RenderUtil.drawRect(x, y, width, height, 0xFF0F0F0F);
		RoundUtil.drawRoundedRect(x, y, width + x, height + y, 20, 0xCF0F0F0F);
		RoundUtil.drawSelectRoundedRect(x, y, width + x, 20 + y, 20, 0, 0, 20, 0x9F1F1F1F);
		RoundUtil.drawSelectRoundedRect(x, y + 20, 100 + x, height + y, 0, 20, 0, 0, 0x9F1F1F1F);
		
		RenderUtil.drawString(mc.fontRendererObj, Client.name, x + width / 2 - 35, y + 6, 0xf1ffffff);
		
		int i = 0;
		for (Category category : Category.values()) {
			RenderUtil.drawRect(x, y + i + 20, 100, 24, isSelectedCat(category) ? HUD.rainbow(300) : 0);
			RenderUtil.drawCenteredString(mc.fontRendererObj, category.name(), x + 50, y + 24 + i + (float) mc.fontRendererObj.FONT_HEIGHT / 2, -1);
			i += 24;
		}
		
		i = 0;
		int count = 0;
		for (Module m : Client.loader.getModulesInCategory(selCat)) {
			if(count % 2 == 0) {
				//RenderUtil.drawRect(x + 106, y + i + 26, (width - 112) / 2 - 3, 20, 0xFF1F1F1F);
				RoundUtil.drawRoundedRect(x + 106, y + i + 26, (width - 112) / 2 + x + 103, y + i + 46, 12, 0xBF1F1F1F);
				RenderUtil.drawString(mc.fontRendererObj, m.name, x + 112, y + i + 32, m.isEnabled() ? HUD.rainbow(300) : 0xf1ffffff);
				RenderUtil.drawString(mc.fontRendererObj, Keyboard.getKeyName(m.getBind()), x + 112 + 120, y + i + 32, m == bindMod ? 0xf3b48b : 0xf1ffffff);
			} else {
				//RenderUtil.drawRect(x + 106 + (width - 112) / 2, y + i + 26, (width - 112) / 2 - 3, 20, 0xFF1F1F1F);
				RoundUtil.drawRoundedRect(x + 106 + (width - 112) / 2, y + i + 26, width - 9 + x, 20 + y + i + 26, 12, 0xBF1F1F1F);
				RenderUtil.drawString(mc.fontRendererObj, m.name, x + 112 + (width - 112) / 2, y + i + 32, m.isEnabled() ? HUD.rainbow(300) : -1);
				RenderUtil.drawString(mc.fontRendererObj, Keyboard.getKeyName(m.getBind()), x + 112 + (width - 112) / 2 + 120, y + i + 32, m == bindMod ? 0xf3b48b : -1);
				i += 25;
			}
			count++;
		}
		

		RoundUtil.drawRoundedOutline(x, y, width + x, height + y, 20, 2, HUD.rainbow(300));
	}
	
	@Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
		if(isOverTop(mouseX, mouseY)) {
			this.dragging = true;
			this.lastX = mouseX - x;
			this.lastY = mouseY - y;
		}
		
		int i = 0;
		
		for(Category category : Category.values()) {
			if(MouseUtil.isMouseOver(mouseX, mouseY, x, y + 20 + i, 100, 24)) {
				this.selCat = category;
			}
			i += 24;
		}
		
		if(mouseButton == 0) {
			i = 0;
			int count = 0;
			for (Module m : Client.loader.getModulesInCategory(selCat)) {
				if(MouseUtil.isMouseOver(mouseX, mouseY, x + 106, y + i + 26, (width - 112) / 2 - 3, 20) && count % 2 == 0) {
					m.toggle();
				} else {
					if(MouseUtil.isMouseOver(mouseX, mouseY, x + 106 + (width - 112) / 2, y + i + 26, (width - 112) / 2 - 3, 20) && count % 2 == 1) {
						m.toggle();
					}
				}
				if(count % 2 == 1) {
					i += 25;
				}
				count++;
			}
		} else {
			i = 0;
			int count = 0;
			for (Module m : Client.loader.getModulesInCategory(selCat)) {
				if(MouseUtil.isMouseOver(mouseX, mouseY, x + 106, y + i + 26, (width - 112) / 2 - 3, 20) && count % 2 == 0) {
					this.binding = !this.binding;
					bindMod = m;
				} else {
					if(MouseUtil.isMouseOver(mouseX, mouseY, x + 106 + (width - 112) / 2, y + i + 26, (width - 112) / 2 - 3, 20) && count % 2 == 1) {
						this.binding = !this.binding;
						bindMod = m;
					}
				}
				if(count % 2 == 1) {
					i += 25;
				}
				count++;
			}
		}
	}
	
	
	@Override
    public void mouseReleased(int mouseX, int mouseY, int state)  {
		super.mouseReleased(mouseX, mouseY, state);
		
		this.dragging = false;
	}
	
	@Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		if(this.binding) {
			if (keyCode != Keyboard.KEY_DELETE) {
				bindMod.setKey(keyCode);
				this.binding = false;
				bindMod = null;
			} else {
				bindMod.setKey(0);
				this.binding = false;
				bindMod = null;
			}
		}
	}
	
	private void smoothDrag(int mouseX, int mouseY) {
		if(dragging) {
			this.x = mouseX - lastX;
			this.y = mouseY - lastY;
		}
	}
	
	private boolean isOverTop(int mouseX, int mouseY) {
		return MouseUtil.isMouseOver(mouseX, mouseY, x, y, width, 20);
	}
	
	private boolean isSelectedCat(Category category) {
		return selCat.equals(category);
	}
	
	public void initGui() {
		mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
	}
	
	public void onGuiClosed()
    {
		mc.entityRenderer.loadEntityShader(null);
    }
}
