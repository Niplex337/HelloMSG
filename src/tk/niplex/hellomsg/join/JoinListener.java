package tk.niplex.hellomsg.join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import tk.niplex.hellomsg.utils.Utils;

public class JoinListener implements Listener{

	private static JavaPlugin plugin;
	public JoinListener(JavaPlugin main) {
		this.plugin = main;
		
		Bukkit.getPluginManager().registerEvents(this, (Plugin) main);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		e.setJoinMessage(null);
		
		if (!player.hasPlayedBefore()) {
			if (((Plugin) plugin).getConfig().getBoolean("firstJoin_enabled") == true) {
				Bukkit.broadcastMessage(Utils.chat(((Plugin) plugin).getConfig().getString("firstJoin_Msg").replace("<player>", player.getName())));
			}
		} else {
			if (!player.hasPermission("hellomsg.incognito")) {
				if (((Plugin) plugin).getConfig().getBoolean("join_enabled") == true) {
						Bukkit.broadcastMessage(Utils.chat(((Plugin) plugin).getConfig().getString("join_Msg").replace("<player>", player.getName())));
			}	} else { player.sendMessage(Utils.chat("&bYou joined as &7&lShadow")); }
			
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
		e.setQuitMessage(null);
		if (!player.hasPermission("hellomsg.incognito")) {
			if (((Plugin) plugin).getConfig().getBoolean("leave_enabled") == true) {
					Bukkit.broadcastMessage(Utils.chat(((Plugin) plugin).getConfig().getString("leave_Msg").replace("<player>", player.getName())));
			} } else { Bukkit.getLogger().info(Utils.chat(player.getName() + " &cLeft &bas &7&lShadow")); }
		
	}
}
