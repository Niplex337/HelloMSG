package tk.niplex.hellomsg;

import org.bukkit.plugin.java.JavaPlugin;

import tk.niplex.hellomsg.join.JoinListener;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new JoinListener(this);
	}
	
}
