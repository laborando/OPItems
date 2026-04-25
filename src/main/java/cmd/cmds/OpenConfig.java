package cmd.cmds;

import gui.itemEnableUI.EnableGuiCreator;
import gui.recipiesUI.RecipesUI;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenConfig {

    public static void execute(CommandSender sender){

        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Only players can execute this command");
            return;
        }

        if(!(sender.isOp())){
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
            return;
        }

        EnableGuiCreator.generateInventory((Player) sender, 0);

    }

}
