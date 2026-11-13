package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.items.managers.abracator.TotalItems;
import cel20.opitems.items.normal.CursedSword;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class RemoveRecipesCommand extends CCommand {

    public RemoveRecipesCommand() {
        context = "Removes all loaded recipes for OPItems.";
        command = "remove_recipes";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {
        if (cs.isOp()) {

            TotalItems.removeAllRecipes();
            cs.sendMessage("All OPItems crafting recipes have been removed until the server is restarted.");


        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
