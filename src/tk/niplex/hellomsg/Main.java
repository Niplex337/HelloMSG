package tk.niplex.hellomsg;

import org.bukkit.plugin.java.JavaPlugin;

import tk.niplex.hellomsg.commands.inviscommand;
import tk.niplex.hellomsg.commands.reloadcommand;
import tk.niplex.hellomsg.join.JoinListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new JoinListener(this);
		new reloadcommand(this);
		new inviscommand(this);
		
		getLogger().info("HelloMSG is now enabled!");

	}

	
}
