package fr.noxi.gui;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum GUI {

	
	HIKA(13, new ItemStack(Material.BED, 1), "§7Hika§6§lBrain", "§7Pour allez PVP", 1),
	SKY(22, new ItemStack(Material.GOLDEN_APPLE, 1), "§7Sky§b§lWars", "§7Pour allez PVP", 1),
	QUITTER(35, new ItemStack(Material.ARROW), "§oQuitter l'inventaire", "§7Tente ta chance", 1);
	
	private int lorelong;
	private int slot;
	private ItemStack it;
	private String name;
	private String lore;

	String mot1 = "§e---------------------";
	String mot2 = "§6➤ §eClique pour effectuer §e§ll'action";
	String mot3 = "§e---------------------";
	
	GUI(int slot, ItemStack it, String name, String lore, int lorelong){
		this.setSlot(slot);
		this.setIt(it);
		this.setName(name);
		this.setLore(lore);
		this.setLongLore(lorelong);
	}

	


	public ItemStack getItem(){
		
		ItemStack i = it;
		ItemMeta iM = i.getItemMeta();

		if(lorelong > 0){
			if(lorelong == 1){

				iM.setLore(Arrays.asList(mot1, mot2, mot3));
			}
			
		}else{
		
			iM.setLore(Arrays.asList(lore));
		}
		iM.setDisplayName(name);
		i.setItemMeta(iM);
		return i;
	}
	

	public int getLongLore() {
		return slot;
	}

	public void setLongLore(int lorelong) {
		this.lorelong = lorelong;
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
	
}
