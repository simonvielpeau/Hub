package fr.noxi.gui;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.noxi.Hub;
import fr.noxi.api.Title;



public class GUIListener implements Listener {

	@EventHandler
	public void interact(PlayerInteractEvent e){
		Player p = e.getPlayer();
		ItemStack i = e.getItem();
		if(i == null)return;
		
		if(i != null && i.getType() != null && i.getType() == Material.NETHER_STAR){
			CustomMenu menu = new CustomMenu(36, "§8Menu");
			menu.createMenu();
			menu.openMenu(p);
		}else if(i != null && i.getType() != null && i.getType() == Material.EYE_OF_ENDER){
			double x = Hub.getInstance().getConfig().getDouble("locations.spawn.lobby.x");
			double y = Hub.getInstance().getConfig().getDouble("locations.spawn.lobby.y");
			double z = Hub.getInstance().getConfig().getDouble("locations.spawn.lobby.z");
			p.teleport(new Location(p.getWorld(),x,y,z));
			Title.sendTitle(p, "", "§7Téléportation..." , 10);
		}else if(i != null && i.getType() != null && i.getType() == Material.EMERALD){
			Inventory inv;
			inv = Bukkit.createInventory(null, 27, "§aBoutique");
			for(GUIBoutique item : GUIBoutique.values()){
				inv.setItem(item.getSlot(), item.getItem());
			}
			p.openInventory(inv);
			e.setCancelled(true);
			
			
		}
			
	}
		
}
