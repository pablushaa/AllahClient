package ua.AllahClient.ModuleSystem;

import java.util.ArrayList;

import ua.AllahClient.Client;
import ua.AllahClient.ModuleSystem.Modules.*;
import ua.AllahClient.ModuleSystem.Modules.Combat.*;
import ua.AllahClient.ModuleSystem.Modules.Misc.*;
import ua.AllahClient.ModuleSystem.Modules.Player.*;
import ua.AllahClient.ModuleSystem.Modules.Render.*;
import ua.AllahClient.ModuleSystem.Modules.movement.*;

public class ModuleLoader {
	public static ArrayList<Module> modules = new ArrayList<>();
	
	public void loadModules() {

		this.addModule(new NoPotionRender());
		this.addModule(new InventoryMove());
		this.addModule(new NoScoreBoard());
		this.addModule(new CrystalAura());
		this.addModule(new StorageESP());
		this.addModule(new AntiOverlay());
		this.addModule(new NoSlowdown());
		this.addModule(new AutoArmor());
		this.addModule(new TriggerBot());
		this.addModule(new StashFinder());
		this.addModule(new AutoTotem());
		this.addModule(new NoWeather());
		this.addModule(new TargetHUD());
		this.addModule(new PlayerESP());
		this.addModule(new FastPlace());
		this.addModule(new ViewModel());
		this.addModule(new AirJump());
		this.addModule(new Spammer());
		this.addModule(new Criticals());
		this.addModule(new Velocity());
		this.addModule(new KillAura());
		this.addModule(new Portals());
		this.addModule(new NoFall());
		this.addModule(new Speed());
		this.addModule(new Bhop());
		this.addModule(new Light());
		this.addModule(new RPC());
		this.addModule(new HUD());
		this.addModule(new Fly());
		//
		this.addModule(new ClickGui());
		this.addModule(new SWAT());
	}
	
	public void addModule(Module m) {
		this.modules.add(m);
	}
	
	public ArrayList<Module> getModules() {
		return this.modules;
	}
	
	public static ArrayList<Module> getModulesInCategory(Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : modules) {
            if (m.getCategory().name().equalsIgnoreCase(c.name())) {
                mods.add(m);
            }
        }
        return mods;
    }
	

	public static Module getModByName(String name) {
		for(Module m : Client.loader.getModules()) {
			if(!m.getName().trim().equalsIgnoreCase(name) && !m.toString().equalsIgnoreCase(name.trim())) continue;
			return m;
		}
		return null;
	}
}
