package cel20.op.load;

import cel20.op.Main;
import items.managers.OldRecipeAdder;
import items.newer.WandOfWarden;
import org.bukkit.plugin.Plugin;

public class VersionDependent {

    public static void loadNewerItems(Plugin p){

        OldRecipeAdder.addRecipe41((Main) p);

        p.getServer().getPluginManager().registerEvents(new WandOfWarden(), p);

    }

}
