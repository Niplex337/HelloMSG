package me.reversee;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.reversee.Utils;
import me.reversee.HelloMSG;

class reloadcommand implements CommandExecutor{

    @SuppressWarnings("unused")
    private HelloMSG plugin;

    public reloadcommand(HelloMSG plugin) {
        this.plugin = plugin;
        plugin.getCommand("hellomsg").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;


        if (args.length == 0) {
            player.sendMessage(Utils.chat("&bHelloMSG &dv2.1 &bhelp:"));
            player.sendMessage(Utils.chat("&e/hellomsg &bPlugin help"));
            player.sendMessage(Utils.chat("&e/hellomsg reload &bReload configuration file"));
            player.sendMessage(Utils.chat(""));
            player.sendMessage(Utils.chat("&d V2.1 Changes: "));
            player.sendMessage(Utils.chat("&a * Fixed Bugs"));
            player.sendMessage(Utils.chat("&c + Added Online Players Variable to Messages"));
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (player instanceof Player) {
                if(player.hasPermission("hellomsg.admin")) {
                    plugin.reloadConfig();
                    plugin.saveConfig();
                    player.sendMessage(Utils.chat("&eReloaded &bHelloMSG &econfiguration file (v2.1) "));
                }
            } else {
                plugin.reloadConfig();
                plugin.saveConfig();
                Bukkit.getLogger().info("Reloaded configuration file of HelloMSG v2.1");

            }
        }

        return false;
    }

}
