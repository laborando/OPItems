package cel20.opitems.cmd;

import cel20.opitems.items.managers.abracator.StringIDAssociator;
import cel20.opitems.items.managers.abracator.TotalItems;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * Tab-completer for all opitems commands
 */
public class TabComp {

    public static List<String> onTabComplete(final CommandSender cs, final String command, final String[] args) {
        if (command.equalsIgnoreCase("opitems")) {
            if (args.length <= 1) {
                List<String> completions = new ArrayList<>();

                CCommand opCmd = Commands.commands.get("opitems");

                opCmd.subCommands.forEach((key, cmd) -> {

                    if(!cmd.isAdmin || cs.isOp())
                        completions.add(key);

                });

                completions.sort(null);

                return completions;
            }
            if (args.length == 2) {
                if (args[0].trim().equalsIgnoreCase("report")) {

                    final List<String> completions = new ArrayList<>();

                    completions.add("Your error report regarding OPItems here");
                    completions.add(" ");

                    return completions;

                }

            }


            //Give Command extra tab completion for better usage
            if (args.length == 2) {
                if (args[0].trim().equalsIgnoreCase("give")) {

                    final List<String> completions = new ArrayList<>();

                    for (StringIDAssociator itemId : TotalItems.itemIds) {
                        completions.add(itemId.name().replace(" ", ""));
                    }

                    completions.removeIf(completion -> !(completion.toLowerCase().startsWith(args[1].trim().toLowerCase())));

                    return completions;
                }
            }

            if (args.length == 3) {
                if (args[0].trim().equalsIgnoreCase("give")) {
                    final List<String> completions = new ArrayList<>();

                    Bukkit.getOnlinePlayers().forEach(e -> completions.add(e.getName()));

                    return completions;
                }
            }

            return Collections.emptyList();
        }

        if (command.equalsIgnoreCase("items") && args.length <= 1) {
            final List<String> completions = new ArrayList<>();

            //Not enought commands to consider dynamic completion generation
            completions.add("remove");
            completions.add("player_heap");
            completions.add("remove_now");
            return completions;
        }

        return Collections.emptyList();
    }

}
