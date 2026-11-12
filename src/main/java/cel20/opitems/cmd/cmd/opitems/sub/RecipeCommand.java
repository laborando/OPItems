package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.gui.recipiesUI.RecipesUI;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RecipeCommand extends CCommand {

    public RecipeCommand() {
        command = "recipes";
        isAdmin = false;
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        RecipesUI.ShowRecipes((Player) cs);

        return 0;
    }
}
