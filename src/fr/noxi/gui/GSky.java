package fr.noxi.gui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.noxi.Hub;
import fr.noxi.Main;
import fr.noxi.api.Title;


public class GSky implements Listener {
	private String menuname = "§6Sky§6§lWars";
	public Map<String, String> nomS = new HashMap<>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickInventaireSky(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		Material b = e.getCurrentItem().getType();
		if(b != null){
			if(b == GUI.SKY.getIt().getType()){
				Inventory inv = Bukkit.createInventory(null, 27, menuname);
				e.setCancelled(true);
				ConfigurationSection section = Hub.getInstance().getConfig().getConfigurationSection("SkyWars");
				for(String sky : section.getKeys(false)){
					String name1 = section.getString(sky+ ".name");
					String particularite = section.getString(sky+ ".pt");
					int guip = section.getInt(sky + ".inv");
					if(Main.getInstance().sql.getState(name1) == 1){
						byte data = 5;
						ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, data);
					
						ItemMeta iM = i.getItemMeta();
						
						
						iM.setDisplayName("§6"+name1);
						nomS.put(iM.getDisplayName(), name1);
						String mot1 = "§eTu peux rejoindre §8:";
						String mot2 = "§eLe jeu est en attente §ede joueurs";
						String motI = "§2"+particularite;
						String mot3= "§7-------------------------------";
						iM.setLore(Arrays.asList(mot3,motI,mot3,mot1,mot2,mot3));
						i.setItemMeta(iM);
						inv.setItem(guip, i);
					}else if(Main.getInstance().sql.getState(name1) == 2){
						byte data = 4;
						ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, data);
					
						ItemMeta iM = i.getItemMeta();
						
						
						iM.setDisplayName("§6"+name1);
						nomS.put(iM.getDisplayName(), name1);
						String mot1 = "§eTu peux rejoindre §8:";
						String mot2 = "§eLe jeu est en lancement §edonc dêpeche toi §8!";
						String motI = "§2"+particularite;
						String mot3= "§7-------------------------------";
						iM.setLore(Arrays.asList(mot3,motI,mot3,mot1,mot2,mot3));
						i.setItemMeta(iM);
						inv.setItem(guip, i);
					}else if(Main.getInstance().sql.getState(name1) == 3){
						byte data = 14;
						ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, data);
						ItemMeta iM = i.getItemMeta();
						iM.setDisplayName("§cEn jeu");
						String mot1 = "§eDésolé §8:";
						String mot2 = "§eLe jeu est en partie";
						String mot3= "§7-------------------------------";
						iM.setLore(Arrays.asList(mot3,mot1,mot2,mot3));
						i.setItemMeta(iM);
						inv.setItem(guip, i);
					}else if(Main.getInstance().sql.getState(name1) == 4){
						byte data = 7;
						ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, data);
						ItemMeta iM = i.getItemMeta();
						iM.setDisplayName("§6Bientôt");
						String mot1 = "§eLe serveur redémarre §8:";
						String mot2 = "§ePlus que quelque seconde à attendre";
						String mot3= "§7-------------------------------";
						iM.setLore(Arrays.asList(mot3,mot1,mot2,mot3));
						i.setItemMeta(iM);
						inv.setItem(guip, i);
					}
						
				
				}
				ItemStack f = new ItemStack(Material.ARROW, 1);
				ItemMeta fM = f.getItemMeta();
				fM.setDisplayName("§7Retour en arrière");
				f.setItemMeta(fM);
				inv.setItem(26, f);
				
				p.openInventory(inv);
			}if(e.getInventory().getName().equalsIgnoreCase(menuname)){

				byte data2 = 5;
				byte data3 = 4;
				ItemStack b1 = e.getCurrentItem();
				if(b == Material.STAINED_CLAY){

					if(b1.getData().getData() == data2 || b1.getData().getData() == data3){
						String key = b1.getItemMeta().getDisplayName();
				
						
						Hub.getInstance().TeleportBungee(p, nomS.get(key));
						
						e.setCancelled(true);
						
					}else if(b1.getData().getData() == 7){
					
						p.closeInventory();
						Title.sendTitle(p, "§cDésolé", "§6Ce serveur redemarre", 20);
						e.setCancelled(true);
					}else{
					
						p.closeInventory();
						Title.sendTitle(p, "§cDésolé", "§6Cette partie est déjà lancé", 20);
						e.setCancelled(true);
					}
				}else if(b == Material.ARROW){
					CustomMenu menu = new CustomMenu(36, "§8Menu");
					menu.createMenu();
					menu.openMenu(p);
					e.setCancelled(true);
					
				}
				
			}
		}
		
	}
	
}
