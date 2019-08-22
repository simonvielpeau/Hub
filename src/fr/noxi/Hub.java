package fr.noxi;



import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.noxi.event.EventsManager;

public class Hub extends JavaPlugin implements Listener, PluginMessageListener{
	public static Hub instance;

	public int playerCount;
	public String server;
	public String prefixH = "§7[§cXonis§c§lLand§7]";
	public static Hub getInstance(){
		return instance;
	}

	
	@Override
	public void onEnable() {
		super.onEnable();
		
		 this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
		getCommand("setspawn").setExecutor(new Command(this));
		getCommand("go").setExecutor(new Command(this));
		getCommand("getUUID").setExecutor(new Command(this));
		getCommand("gm").setExecutor(new Command(this));
		getCommand("fly").setExecutor(new Command(this));
		getConfig().options().copyDefaults(true);
		saveConfig();
		instance = this;
		
		new EventsManager(this).registerEvents();
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Bukkit.getWorld("world").setTime(0);
		
		
	}
	
	@Override
	public void onDisable() {
			
		super.onDisable();
	}
	  @Override
	    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	        if (!channel.equals("BungeeCord")) {
	            return;
	        }
	       
	        ByteArrayDataInput in = ByteStreams.newDataInput(message);
	        String subchannel = in.readUTF();
	       
	        if (subchannel.equals("PlayerCount")) {
	        	
	        	server = in.readUTF();
	            playerCount = in.readInt();
	            
	           
	           
	           
	        }
	       
	    }
	 
	    public void getCount(String server, Player player) {
	 
	        ByteArrayDataOutput out = ByteStreams.newDataOutput();
	        out.writeUTF("PlayerCount");
	        out.writeUTF(server);
	        player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
	       
	 
	}
	 
	public void TeleportBungee(Player player, String serv){
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		
		try{
			out.writeUTF("Connect");
			out.writeUTF(serv);
			player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
		}catch(IOException e){
			System.out.println("Tentage de tp foiré");
			player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
		}
	}
	
}
