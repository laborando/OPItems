package cel20.op.load;

import cel20.op.Main;
import items.classic.OldItems;
import items.managers.RecipeAdder;
import items.newer.WandOfWarden;
import org.bukkit.plugin.Plugin;

public class VersionDependent {

    public static void loadNewerItems(Plugin p){

        RecipeAdder.addRecipe41((Main) p);




        p.getServer().getPluginManager().registerEvents(new WandOfWarden(), p);

    }

}
