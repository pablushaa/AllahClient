package ua.AllahClient.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ua.AllahClient.Client;
import ua.AllahClient.ModuleSystem.Module;

public class FileManager {

	public static File DIR = new File("alah");
	public static File modules = new File(DIR, "modules.json");
	
	public void init() {
		if(!DIR.exists()) {DIR.mkdirs();}
		if(!modules.exists()) {
			saveMods();
		} else {
			loadMods();
		}
	}

	public void saveMods() {
		try {
			JsonObject json = new JsonObject();
			for(Module m : Client.loader.getModules()) {
				JsonObject jsonMod = new JsonObject();
				jsonMod.addProperty("enabled", m.isEnabled());
				json.add(m.getName(), jsonMod);
			}
			
			PrintWriter save = new PrintWriter(new FileWriter(modules));
			save.println(JsonUtil.prettyJson.toJson(json));
			save.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }

        folder.delete();
    }
	
	private void loadMods() {
		try {
			BufferedReader load = new BufferedReader(new FileReader(modules));
			JsonObject json = (JsonObject)JsonUtil.parser.parse(load);
			load.close();
			Iterator<Entry<String, JsonElement>> itr = json.entrySet().iterator();
			while(itr.hasNext()) {
				Entry<String, JsonElement> entry = itr.next();
				Module m = Client.loader.getModByName(entry.getKey());
				if(m != null) {
					JsonObject jsonMod = (JsonObject)entry.getValue();
					boolean enabled = jsonMod.get("enabled").getAsBoolean();
					if(enabled) {
						m.setToggled(true);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


