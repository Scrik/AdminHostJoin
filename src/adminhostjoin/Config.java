/**
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

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
			playerHosts.put(player.toLowerCase(), host);
		}
		config = new YamlConfiguration();
		for (String player : playerHosts.keySet()) {
			String host = playerHosts.get(player);
			config.set(player, host);
		}
		try {config.save(configfile);} catch (IOException e) {}
	}

}
