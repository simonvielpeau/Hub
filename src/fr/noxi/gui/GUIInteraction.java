package fr.noxi.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.noxi.Hub;
import fr.noxi.Main;


public class GUIInteraction implements Listener {

		@EventHandler
		public void clickInventory(InventoryClickEvent e){
			Player p = (Player) e.getWhoClicked();
			Inventory inv = e.getInventory();
			ItemStack current = e.getCurrentItem();
			
			
			//Le menu
			if(inv.getName().equalsIgnoreCase("§8Menu")){
				
				//Null pointer exception
				if(current == null) return;
				
				
				
				if(current.getType() == GUI.QUITTER.getIt().getType()){
					e.setCancelled(true);
					p.closeInventory();
				}
				
				
				//SKYWARS
			}else if(inv.getName().equalsIgnoreCase("§aBoutique")){

				//Null pointer exception
				if(current == null) return;
				
				
				//Quelle icône il clique
				if(current.getType() == GUIBoutique.Info.getIt().getType()){
					p.closeInventory();
					int money = Main.getInstance().sql.getBalance(p);
					p.sendMessage(Hub.getInstance().prefixH + " §7Tu as §2"+money+" §cXonis§c§lCoins");
					e.setCancelled(true);
					
				}
			}
			
		}
	
}
