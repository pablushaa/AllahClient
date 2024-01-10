package ua.AllahClient.ModuleSystem.Modules.Combat;

import org.lwjgl.input.Keyboard;

import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

public class Velocity extends Module {
	public static Velocity mod;

	public Velocity() {
		super("Velocity", Keyboard.KEY_NONE, Category.Combat);
		mod = this;
	}
}
