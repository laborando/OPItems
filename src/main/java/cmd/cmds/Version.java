package cmd.cmds;

import cel20.op.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import utis.update.CUpdater;
import utis.update.CVersion;

public class Version {

    public static void execute(CommandSender sender) {

        sender.sendMessage(ChatColor.GOLD + "Current Version: " + Main.opitemsVersion);
        sender.sendMessage(ChatColor.BLUE + "Changelog: https://modrinth.com/plugin/opitems/changelog");

        CUpdater updater = Main.cUpdater;

        if (updater.shouldUpdate) {
            sender.sendMessage(ChatColor.GOLD + "There is an update available:");
            CVersion cversion = updater.highestVersion;
            sender.sendMessage(ChatColor.BLUE + "v" + cversion.version + " from " + cversion.version + " by" + cversion.author);
        }
    }
}
