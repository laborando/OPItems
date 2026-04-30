package cmd;

import items.abracator.StringIDAssociator;
import items.abracator.TotalItems;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class TabComp {

    public static List<String> onTabComplete(final CommandSender sender, final String command, final String[] args) {
        if (command.equalsIgnoreCase("opitems")) {
            if (args.length <= 1) {
                final List<String> completions = new ArrayList<>();
                completions.add("help");
                completions.add("recipes");
                completions.add("version");
                completions.add("upgradeItems");

                if (sender.isOp()) {
                    completions.add("give");
                    completions.add("update");
                    completions.add("skull");
                    completions.add("um");
                    completions.add("changelog");
                    completions.add("config");
                }

                return completions;
            }
            if (args.length == 2) {
                if (args[0].trim().equalsIgnoreCase("give")) {

                    final List<String> completions = new ArrayList<>();

                    for (StringIDAssociator itemId : TotalItems.itemIds) {
                        completions.add(itemId.getName().replace(" ", ""));
                    }


                    completions.removeIf(completion -> !(completion.toLowerCase().startsWith(args[1].trim().toLowerCase())));


                    return completions;


                }
            }
            if (args.length == 3) {
                if (args[0].trim().equalsIgnoreCase("give")) {
                    final List<String> completions = new ArrayList<String>();

                    Bukkit.getOnlinePlayers().forEach(e -> {
                        completions.add(e.getName());
                    });

                    return completions;
                }
            }
        }

        if (command.equalsIgnoreCase("items") && args.length <= 1) {
            final List<String> completions = new ArrayList<String>();
            completions.add("remove");
            completions.add("player_heap");
            return completions;
        }
        return null;
    }

}
