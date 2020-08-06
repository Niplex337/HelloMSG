package tk.niplex.hellomsg.commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

import tk.niplex.hellomsg.Main;
import tk.niplex.hellomsg.utils.Utils;

public class inviscommand implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	
	public inviscommand(Main plugin) {
		this.plugin = plugin; 
		plugin.getCommand("helloinvis").setExecutor(this);
	}
	

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			Player player = (Player) sender;
			PermissionAttachment attachment = player.addAttachment(plugin);
			HashMap<UUID,PermissionAttachment> map = new HashMap<>();
				
					if (args.length == 0) {
						player.sendMessage(Utils.chat("&bHelloMSG (Incognito Mode) v1.3 help:"));
						player.sendMessage(Utils.chat("&eTo enable Incognito Mode, give player permission 'hellomsg.incognito' "));
						player.sendMessage(Utils.chat("&eTo disable it, take permission 'hellomsg.incognito' from player "));
						player.sendMessage(Utils.chat("&b----------------------------------------------------------------------"));
						player.sendMessage(Utils.chat("&7&lIncognito Mode &r&7Is a mode for Admins, who doesn't want to thier name be shown when joining/leaving "));
						return true;
					}
					
		return false;
	}
	
}
