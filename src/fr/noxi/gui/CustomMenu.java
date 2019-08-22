package fr.noxi.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CustomMenu {
	
	//Variable
	private Inventory inv;
	
	//Fonction
	public CustomMenu(int size, String name){
		if(size == 0) size = 9;
		if(size > 55) size = 54;
			
		inv = Bukkit.createInventory(null, size, name);
		
	}
	
	public void createMenu(){
		for(GUI item : GUI.values()){
			inv.setItem(item.getSlot(), item.getItem());
		}
	}
	public void openMenu(Player player){
		player.openInventory(inv);
	}
}
