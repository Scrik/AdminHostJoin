package adminhostjoin;

import org.bukkit.plugin.java.JavaPlugin;

public class AdminHostJoin extends JavaPlugin {
	
	private Config config;
	private Commands commands;
	private LoginListener loginListener;
	
	@Override
	public void onEnable() {
		config = new Config(this);
		config.loadConfig();
		commands = new Commands(config);
		getCommand("ahj").setExecutor(commands);
		loginListener = new LoginListener(config);
		getServer().getPluginManager().registerEvents(loginListener, this);
	}
	
	@Override
	public void onDisable() {
		config = null;
		commands = null;
		loginListener = null;
	}

}
