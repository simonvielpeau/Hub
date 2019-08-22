package fr.noxi;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.noxi.api.Title;

public class Command implements CommandExecutor{
	private Hub pl;
	private FileConfiguration config;

	public Command(Hub hub) {
		this.pl = hub;
		this.config = pl.getConfig();
	}
	
	public static Command instance;
	public static Command getInstance(){
		return instance;
	}


	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String msg, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			this.config = pl.getConfig(); 
			instance = this;
			if(cmd.getName().equalsIgnoreCase("setspawn")){
				 config.set("locations.spawn.lobby.x", p.getLocation().getX());
				 config.set("locations.spawn.lobby.y", p.getLocation().getY());
				 config.set("locations.spawn.lobby.z", p.getLocation().getZ());
				 p.sendMessage("§cSpawn bien set");
				 pl.saveConfig();
			}

			if(cmd.getName().equalsIgnoreCase("getUUID")){
				if(args.length == 0){
					p.sendMessage("§cTu dois taper le joueurs !");
				}else if(args.length == 1){
					 Player cible = Bukkit.getPlayer(args[0]);
					 String UUID = cible.getUniqueId().toString();
					 if(cible != null){
						 p.sendMessage("§7[§c§lXonisLand§7] §7L'uuid du joueurs est : " + UUID + " §7!");
					 }
					
				}
				
			}
			if(cmd.getName().equalsIgnoreCase("go")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("Vide")){
							Hub.getInstance().TeleportBungee(p, "Vide");
						
					}
					else if(args[0].equalsIgnoreCase("list")){
						p.sendMessage("§7-------------");
						p.sendMessage("§7Vide");
						p.sendMessage("§7-------------");
						
				
					}
						
					
					else{
					p.sendMessage("§7[§c§lXonisLand§7] §cTape /go list car ta location n'est pas valide §7!");
				}
				
		
				}
	
	}if(cmd.getName().equalsIgnoreCase("gm")){
		if(p.getGameMode().equals(GameMode.SURVIVAL)){
			p.setGameMode(GameMode.CREATIVE);
			Title.sendTitle(p, "§6C'est bon", "§cTu as changé de gamemode", 20);
		}else{
			p.setGameMode(GameMode.SURVIVAL);
			Title.sendTitle(p, "§6C'est bon", "§cTu as changé de gamemode", 20);
		}
	}else if(cmd.getName().equalsIgnoreCase("fly")){
		if(p.getAllowFlight() == true){
			p.setAllowFlight(false);
			Title.sendTitle(p, "§6Désactivé", "§cTu as désactivé ton fly", 30);
		}else{
			p.setAllowFlight(true);
			Title.sendTitle(p, "§6C'est bon", "§cTu peux fly", 30);
		}
		
		
	}



	}
		return false;
	}
}


