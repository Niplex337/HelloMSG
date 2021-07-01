package me.reversee;

import org.bukkit.plugin.java.JavaPlugin;

import me.reversee.JoinListener;
import me.reversee.reloadcommand;

public final class HelloMSG extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        new JoinListener(this);
        new reloadcommand(this);
    }
}
