package cmd.cmds;

import cel20.op.Main;
import gui.recipiesUI.RecipesUI;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utis.update.CUpdater;
import utis.update.CVersion;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class GetChangelog {

    public static void execute(CommandSender sender){

        CUpdater updater = Main.cUpdater;

        Deque<CVersion> stack = new ArrayDeque<>();

        for (CVersion v : updater.versions) {
            stack.push(v);
        }

        for (CVersion cVersion : stack) {

            sender.sendMessage("");
            sender.sendMessage(ChatColor.RED + "v" + cVersion.version);

            cVersion.changelog.lines().forEach(l -> sender.sendMessage(l.replace("###", ChatColor.BOLD + "" + ChatColor.BLUE).replace("##", ChatColor.BOLD + ""+ ChatColor.BLUE).replace("#", ChatColor.GOLD + "")));


        }

        sender.sendMessage("");
        sender.sendMessage(ChatColor.GOLD + "Complete Changelog: https://modrinth.com/plugin/opitems/changelog");

    }

}
