package adminhostjoin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;

public class Commands implements CommandExecutor {

	private Config config;
	public Commands(Config config) {
		this.config = config;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender) {
			if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
				config.loadConfig();
				sender.sendMessage("Configuration reloaded");
				return true;
			}
		} else {
			sender.sendMessage("Can be used only from console");
			return true;
		}
		return false;
	}

}
