package cmd.cmds;

import cel20.op.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Version {

    public static void execute(CommandSender sender){

        sender.sendMessage(ChatColor.GOLD + "Current Version: " + Main.opitems_version);
        sender.sendMessage(ChatColor.BLUE + "Changelog: https://modrinth.com/plugin/opitems/changelog");

    }
}
