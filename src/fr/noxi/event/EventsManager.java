package fr.noxi.event;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.noxi.Hub;
import fr.noxi.gui.GHika;
import fr.noxi.gui.GSky;
import fr.noxi.gui.GUIInteraction;
import fr.noxi.gui.GUIListener;

public class EventsManager {

	public Hub pl;
	

	public EventsManager(Hub hub) {
		this.pl = hub;
	}


	public void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new XonisJoin(), pl);
		pm.registerEvents(new PlayerListener(), pl);
		pm.registerEvents(new GUIListener(), pl);
		pm.registerEvents(new GUIInteraction(), pl);
		pm.registerEvents(new GHika(), pl);
		pm.registerEvents(new GSky(), pl);
	
	}

}
