package ua.AllahClient.ModuleSystem;

import net.minecraft.client.Minecraft;
import ua.AllahClient.Client;

public class Module {

	public String name;
	public int bind;
	public boolean enabled;
	public Category category;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, int bind, Category category) {
		this.name = name;
		this.bind = bind;
		this.category = category;
	}
	
	public void toggle() {
		this.enabled = !this.enabled;
		if(this.enabled) {
			this.onEnable();
		} else {
			this.onDisable();
		}
	}
	
	public void onEnable() {}
	public void onDisable() {}
	
	public String getName() {return this.name;}
	public int getBind() {return this.bind;}
	public Category getCategory() {return this.category;}
	public boolean isEnabled() {return this.enabled;}
	
	public void onUpdate() {}
	public void onRender2D() {}
	public void onRender() {}
	public void setKey(int key) {this.bind = key;}

	public void setToggled(boolean b) {this.enabled = b;}
}
