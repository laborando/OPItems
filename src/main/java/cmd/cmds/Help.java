package cmd.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Help {

    public static void execute(CommandSender sender){

        sender.sendMessage(ChatColor.BLUE + "OPItems by Cel20");

        sender.sendMessage(ChatColor.GOLD + "Important Commands: ");

        sender.sendMessage(ChatColor.GOLD + "/opitems upgradeItem | Upgrades items to their newest version");
        sender.sendMessage(ChatColor.GOLD + "/opitems recipes | Provides a link to the recipes");

        if (sender.isOp()) {

            sender.sendMessage(ChatColor.GOLD + "/opitems give | Generates OPItems");
            sender.sendMessage(ChatColor.GOLD + "/opitems skull | Generates the head of a given player");
            sender.sendMessage(ChatColor.GOLD + "/opitems update | Updates OPItems");
            sender.sendMessage(ChatColor.GOLD + "/opitems version | Displays the current version and changelog");
            sender.sendMessage(ChatColor.GOLD + "/items | Settings for item heap-displaying and removal");


            sender.sendMessage(ChatColor.GOLD + "This Plugins config can be edited in the /plugins/opitems/plugin.yml file");
        }

    }

}
