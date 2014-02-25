package adminhostjoin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	private AdminHostJoin plugin;
	public Config(AdminHostJoin plugin) {
		this.plugin = plugin;
	}
	
	private HashMap<String, String> playerHosts = new HashMap<String, String>();
	public boolean isPlayerShouldUseHost(String playername) {
		return playerHosts.containsKey(playername);
	}
	public String getPlayerHost(String playername) {
		return playerHosts.get(playername);
	}
	
	public void loadConfig() {
		playerHosts.clear();
		File configfile = new File(plugin.getDataFolder(), "config.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(configfile);
		for (String player : config.getKeys(false)) {
			String host = config.getString(player);
			playerHosts.put(player, host);
		}
		config = new YamlConfiguration();
		for (String player : playerHosts.keySet()) {
			String host = playerHosts.get(player);
			config.set(player, host);
		}
		try {config.save(configfile);} catch (IOException e) {}
	}

}
