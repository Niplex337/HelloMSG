package me.reversee;

    import org.bukkit.Bukkit;
    import org.bukkit.Material;
    import org.bukkit.entity.Player;
    import org.bukkit.event.EventHandler;
    import org.bukkit.event.Listener;
    import org.bukkit.event.player.PlayerJoinEvent;
    import org.bukkit.event.player.PlayerQuitEvent;
    import org.bukkit.inventory.ItemStack;
    import org.bukkit.plugin.Plugin;
    import org.bukkit.plugin.java.JavaPlugin;

    import java.util.ArrayList;
    import java.util.List;

public class JoinListener implements Listener {
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
            if (!((Plugin) plugin).getConfig().getStringList("exclude").contains(player.getName())) {
                if (((Plugin) plugin).getConfig().getBoolean("firstJoin_e") == true) {

                    String fjoinFormatted = Utils.chat(((Plugin) plugin).getConfig().getString("firstJoin").replace("<player>", player.getName()));
                    String fjoinFormattedTwice = Utils.chat(fjoinFormatted.replace("<online>", String.valueOf(Bukkit.getOnlinePlayers().size()) ));
                    Bukkit.broadcastMessage(fjoinFormattedTwice);

                }
            }
        } else {
            if (((Plugin) plugin).getConfig().getBoolean("join_e") == true) {
                if (!((Plugin) plugin).getConfig().getStringList("exclude").contains(player.getName())) {
                    String fjoinFormatted = Utils.chat(((Plugin) plugin).getConfig().getString("join").replace("<player>", player.getName()));
                    String fjoinFormattedTwice = Utils.chat(fjoinFormatted.replace("<online>", String.valueOf(Bukkit.getOnlinePlayers().size()) ));
                    Bukkit.broadcastMessage(fjoinFormattedTwice);
                }
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(null);
        if (((Plugin) plugin).getConfig().getBoolean("leave_e")) {
            if (!((Plugin) plugin).getConfig().getStringList("exclude").contains(player.getName())) {
                String leaveFormatted = Utils.chat(((Plugin) plugin).getConfig().getString("leave").replace("<player>", player.getName()));
                String leaveFormattedTwice = Utils.chat(leaveFormatted.replace("<online>", String.valueOf(Bukkit.getOnlinePlayers().size()) ));
                Bukkit.broadcastMessage(leaveFormattedTwice);
            }
        }
    }
}
