package fr.noxi.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void breakevent(BlockBreakEvent e){
		Player p = e.getPlayer();
		
		if(!p.hasPermission("admin.autre")) {
			e.setCancelled(true);

		}
	}
	@EventHandler
	public void placeevent(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(!p.hasPermission("admin.autre")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void damage(EntityDamageEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void craft(CraftItemEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void enterBed(PlayerBedEnterEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void drop(PlayerDropItemEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void weather(WeatherChangeEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void click(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(!p.hasPermission("admin.autre")) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void bedEnter(PlayerBedEnterEvent e){
		e.setCancelled(true);
	}
	
	
	
}
