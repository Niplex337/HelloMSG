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
            player.sendMessage(Utils.chat("&bHelloMSG &dv2 &bhelp:"));
            player.sendMessage(Utils.chat("&e/hellomsg &bPlugin help"));
            player.sendMessage(Utils.chat("&e/hellomsg reload &bReload configuration file"));
            player.sendMessage(Utils.chat(""));
            player.sendMessage(Utils.chat("&d V2 Rewrite Changes: "));
            player.sendMessage(Utils.chat("&a * Plugin rewrite, to make code readable, and other stuff!"));
            player.sendMessage(Utils.chat("&a * "));
            player.sendMessage(Utils.chat("&c - Goodbye, HelloInvis. Long live Excluding! (wait what?) "));
            player.sendMessage(Utils.chat("&c - Remove create config command... "));
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            if (player instanceof Player) {
                if(player.hasPermission("hellomsg.admin")) {
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

        return false;
    }

}
