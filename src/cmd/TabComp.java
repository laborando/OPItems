package cmd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class TabComp implements TabCompleter {

	public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        if (command.getName().equalsIgnoreCase("opitems") && args.length == 1) {
            final List<String> completions = new ArrayList<String>();
            completions.add("help");
            completions.add("gui");
            completions.add("give");
            completions.add("update");
            completions.add("recipes");
            completions.add("skull");
            completions.add("version");
            return completions;
        }
        if (command.getName().equalsIgnoreCase("items") && args.length == 1) {
            final List<String> completions = new ArrayList<String>();
            completions.add("remove");
            completions.add("player_heap");
            return completions;
        }
        return null;
    }
	
}
