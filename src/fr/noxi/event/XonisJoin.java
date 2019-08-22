package fr.noxi.event;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.noxi.Hub;
import fr.noxi.api.Title;
import fr.noxi.gui.HubDebut;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class XonisJoin implements Listener {


	@EventHandler
	public void join(PlayerJoinEvent e){
		final Player p = e.getPlayer();

		

		p.sendMessage("§aBienvenue sur §2§k|||   §cXonis§c§lLand §2§k|||");
		p.sendMessage("§bActualité du serveur §c§l:");
		p.sendMessage("§6-§7Support version §e1.9 §7jusqu'à §e1.11");
		p.sendMessage("§6-§2Ajout d'un §bTeam§b§lSpeak");
		String prefix = PermissionsEx.getUser(e.getPlayer()).getPrefix();
		p.setDisplayName(prefix + " "+p.getName());
		p.setAllowFlight(false);
		Title.sendTitle(p, "§c§lXonisLand", "§7Le minijeu §cpure §7et §cdur", 30);
		Title.sendActionBar(p, "§7On commence par quoi §5" + p.getDisplayName() + " §8?");
		p.setGameMode(GameMode.SURVIVAL);
		p.getInventory().clear();
		double x = Hub.getInstance().getConfig().getDouble("locations.spawn.lobby.x");
		double y = Hub.getInstance().getConfig().getDouble("locations.spawn.lobby.y");
		double z = Hub.getInstance().getConfig().getDouble("locations.spawn.lobby.z");
		p.teleport(new Location(p.getWorld(),x,y,z));
		e.setJoinMessage("");
	
		

		p.setPlayerListName(prefix + " " + p.getName());
		for(Player pl : Bukkit.getOnlinePlayers()){
			Title.sendActionBar(pl, prefix + " §5> §6" + p.getName() + " §7à rejoint le §a§l§ohub");
		}	
		final Random r = new Random();
		final List<String> messages = new ArrayList<>();
		String ip = Hub.getInstance().getConfig().getString("ip");
		String ts = Hub.getInstance().getConfig().getString("ts");
		messages.add("§6Bienvenue sur §7[§c§lXonisLand§7]");
		messages.add("§eIP §5> §6"+ip);
		messages.add("§c➤ §eRejoingnez notre §bTeam§b§lSpeak §c➤ §a"+ts+" §8!");
		messages.add("§cLe serveur est en bêta §8!");
		
		
		
		final BossBar newBar = Bukkit.createBossBar("§6Bienvenue sur §7[§c§lXonisLand§7]", BarColor.YELLOW, BarStyle.SOLID, new BarFlag[0]);
		
		  Bukkit.getScheduler().runTaskTimer(Hub.getInstance(), new Runnable(){
			  
	            double d = 0.0;
	            int i = 0;
	           
	            @Override
	            public void run() {
	               
	            	
	            	
	                d += 0.01;
	                if(d >= 1){
	                    d = 0.0;
	                    i++;
	                   
	                    if(i == messages.size()){
	                        i = 0;
	                    }
	                  
	                    newBar.setTitle(messages.get(i));
	                    newBar.setColor(BarColor.values()[r.nextInt(BarColor.values().length)]);
	                   
	                }
	           
	                newBar.setProgress(d);
	                newBar.addPlayer(p);
	               
	            }
	           
	        },1,1);
		  Bukkit.getScheduler().runTaskTimer(Hub.getInstance(), new Runnable(){

			@Override
			public void run() {
				String prefix = PermissionsEx.getUser(p).getPrefix();
				p.setDisplayName(prefix + " "+p.getName());
				p.setPlayerListName(prefix + " "+p.getName());
				
			}
			  
		  },4800,4800);
		p.setMaxHealth(20.0);
		for(HubDebut item : HubDebut.values()){
			p.getInventory().setItem(item.getSlot(), item.getItem());
			p.updateInventory();
		}
		p.updateInventory();
		
		
	}
	@EventHandler
	public void quit(PlayerQuitEvent e){
		Player p = e.getPlayer();

		e.setQuitMessage("");
		String prefix = PermissionsEx.getUser(e.getPlayer()).getPrefix();
		for(Player pl : Bukkit.getOnlinePlayers()){
			Title.sendActionBar(pl, prefix + " §5> §6" + p.getName() + " §7à quitter le §a§l§ohub");
		}	
	}
}
