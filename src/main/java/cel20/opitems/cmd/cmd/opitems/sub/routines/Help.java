package cel20.opitems.cmd.cmd.opitems.sub.routines;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Help {

    public static void displayHelp(CommandSender sender) {

        sender.sendMessage(ChatColor.BLUE + "OPItems by Cel20");

        sender.sendMessage(ChatColor.GOLD + "Important Commands: ");

        sender.sendMessage(ChatColor.GOLD + "/opitems ? | Displays the full list of OPItems commands");
        sender.sendMessage(ChatColor.GOLD + "/opitems upgradeItem | Upgrades cel20.items to their newest version");
        sender.sendMessage(ChatColor.GOLD + "/opitems recipes | Displays the recipes");

        if (sender.isOp()) {

            sender.sendMessage(ChatColor.GOLD + "/opitems give | Generates OPItems");
            sender.sendMessage(ChatColor.GOLD + "/opitems skull | Generates the head of a given player");
            sender.sendMessage(ChatColor.GOLD + "/opitems update | Updates OPItems");
            sender.sendMessage(ChatColor.GOLD + "/opitems version | Displays the current version and changelog");
            sender.sendMessage(ChatColor.GOLD + "/items | Item-managing commands. See config for more info");

            sender.sendMessage(ChatColor.GOLD + "This Plugins config can be edited in the /plugins/opitems/plugin.yml file");
        }
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GOLD + "Run </command ?> or </command ? subcommand> for more information on individual commands");



    }

}
