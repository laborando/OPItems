package cel20.opitems.cmd.cmds;

import cel20.opitems.gui.recipiesUI.RecipesUI;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetRecipe {

    public static void execute(CommandSender sender) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command");
            return;
        }

        RecipesUI.ShowRecipes((Player) sender);

    }

}
