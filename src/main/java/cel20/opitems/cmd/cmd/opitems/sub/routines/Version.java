package cel20.opitems.cmd.cmd.opitems.sub.routines;

import cel20.opitems.op.Main;
import cel20.opitems.utis.update.CUpdater;
import cel20.opitems.utis.update.CVersion;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Version {

    public static void displayVersion(CommandSender sender) {

        sender.sendMessage(ChatColor.GOLD + "Current Version: " + Main.opitemsVersion);
        sender.sendMessage(ChatColor.BLUE + "Changelog: https://modrinth.com/plugin/opitems/changelog");

        CUpdater updater = Main.cUpdater;

        if (updater.shouldUpdate) {
            sender.sendMessage(ChatColor.GOLD + "There is an update available:");
            CVersion cversion = updater.highestVersion;
            sender.sendMessage(ChatColor.BLUE + "v" + cversion.version + " as " + cversion.type + " by " + cversion.author);
        }
    }
}
