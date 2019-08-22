package fr.noxi.gui;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum GUIBoutique {

	
	Info(18, new ItemStack(Material.ARMOR_STAND, 1), "§aInfo sur §atoi", "§6Clique pour effectuer l'action", "§6et fermer l'inventaire");
	
	
	private String l2;
	private int slot;
	private ItemStack it;
	private String name;
	private String lore;


	String mot1 = "§e---------------------";

	String mot3 = "§e---------------------";
	
	GUIBoutique(int slot, ItemStack it, String name, String lore, String l2){
		this.setSlot(slot);
		this.setIt(it);
		this.setName(name);
		this.setLore(lore);
		this.setLore2(l2);
	
	}

	


	public ItemStack getItem(){
		
		ItemStack i = it;
		ItemMeta iM = i.getItemMeta();

		

				iM.setLore(Arrays.asList(mot1, lore,l2, mot3));
			
		
			
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		return i;
	}
	

	

	
	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public ItemStack getIt() {
		return it;
	}

	public void setIt(ItemStack it) {
		this.it = it;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLore() {
		return lore;
	}

	public void setLore(String lore) {
		this.lore = lore;
	}
	public String getLore2() {
		return l2;
	}

	public void setLore2(String l2) {
		this.l2 = l2;
	}
	
}
