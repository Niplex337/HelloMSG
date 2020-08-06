package tk.niplex.hellomsg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import tk.niplex.hellomsg.Main;
import tk.niplex.hellomsg.utils.Utils;

public class reloadcommand implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	
	public reloadcommand(Main plugin) {
		this.plugin = plugin; 
		plugin.getCommand("hellomsg").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			Player player = (Player) sender;
			
				
					if (args.length == 0) {
						player.sendMessage(Utils.chat("&bHelloMSG v1.2 help:"));
						player.sendMessage(Utils.chat("&e/hellomsg &bPlugin help"));
						player.sendMessage(Utils.chat("&e/hellomsg reload &bReload configuration file"));
						player.sendMessage(Utils.chat("&e/hellomsg createconfig &bCreate configuration file"));
						return true;
					}
					if (args[0].equalsIgnoreCase("reload")) {
						if (player instanceof Player) {
							if(player.hasPermission("hellomsg.usecommands")) {
								plugin.reloadConfig();
								plugin.saveConfig();
								player.sendMessage(Utils.chat("&eReloaded configuration file of &bHelloMSG"));
							}
						
						} else {
								plugin.reloadConfig();
								plugin.saveConfig();
								Bukkit.getLogger().info("Reloaded configuration file of HelloMSG");
						
						}
					}
					
					if (args[0].equalsIgnoreCase("createconfig")) {
						plugin.saveDefaultConfig();
						player.sendMessage(Utils.chat("&eCreated configuration file of &bHelloMSG"));
					}
					
		return false;
	}
	
}
