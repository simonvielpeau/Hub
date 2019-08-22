package fr.noxi.gui;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum HubDebut {

	MenuPrincipal(4, new ItemStack(Material.NETHER_STAR, 1), "§6Menu §e§lprincipal", "", 1),
	Spawn(0, new ItemStack(Material.EYE_OF_ENDER, 1), "§q§lSpawn", "", 1),
	Boutique(8, new ItemStack(Material.EMERALD, 1), "§a§lBoutique", "", 1);

	
	private int lorelong;
	private int slot;
	private ItemStack it;
	private String name;
	private String lore;

	String mot1 = "§6§k---------------";
	String espace1 = "§8";
	String mot2 = "§7[§c§lXonisLand§7]";
	String mot3 = "§6§k---------------";
	String espace2 = "§9";
	
	HubDebut(int slot, ItemStack it, String name, String lore, int lorelong){
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

				iM.setLore(Arrays.asList(mot1, espace1, mot2, espace2, mot3));
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
