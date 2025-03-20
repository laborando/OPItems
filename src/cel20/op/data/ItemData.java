package cel20.op.data;

import cel20.op.Main;
import items.normal.DimensionWand;
import items.normal.WandOfHome;
import items.normal.cursedSword;
import items.normal.landmine;
import org.bukkit.plugin.Plugin;

public class ItemData {


    public static void loadItems(Main m){

        landmine.load();
        cursedSword.loadData(Main.data_save_cursed_sword = m.getDataFolder() + "/op_cursed_sword_data");
        WandOfHome.loadData(Main.data_save_homes = m.getDataFolder() + "/wand_of_home_data");
        DimensionWand.loadData(Main.data_save_play_dim = m.getDataFolder() + "/farm_dim_play_data");

    }

    public static void saveItemData(Plugin p) {

        cursedSword.saveData(Main.data_save_cursed_sword);

        WandOfHome.saveData(Main.data_save_homes);

        DimensionWand.saveData(Main.data_save_play_dim);

        landmine.save();

    }
}
