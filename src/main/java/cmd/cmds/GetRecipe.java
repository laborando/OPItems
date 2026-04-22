package cmd.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class GetRecipe {

    public static void execute(CommandSender sender){
        sender.sendMessage(ChatColor.GOLD + "Recipes for the items:");

        sender.sendMessage(ChatColor.BLUE + "https://legacy.curseforge.com/minecraft/bukkit-plugins/opitems/screenshots");
    }

}
