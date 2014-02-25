package adminhostjoin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {

	private Config config;
	public LoginListener(Config config) {
		this.config = config;
	}

	@EventHandler(priority=EventPriority.LOWEST,ignoreCancelled=true)
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		if (config.isPlayerShouldUseHost(player.getName())) {
			String host = event.getHostname();
			if (host.contains(":")) {
				host = host.substring(0, host.indexOf(":"));
			}
			if (!host.equals(config.getPlayerHost(player.getName()))) {
				event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Join using appropriative host");
			}
		}
	}
	
}
