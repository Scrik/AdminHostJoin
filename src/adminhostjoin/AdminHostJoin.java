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
