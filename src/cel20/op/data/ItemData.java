package cel20.op.data;

import cel20.op.Main;
import items.normal.DimensionWand;
import items.normal.WandOfHome;
import items.normal.cursed_sword;
import items.normal.landmine;
import org.bukkit.plugin.Plugin;

public class ItemData {


    public static void loadItems(Main m){

        landmine.load();
        cursed_sword.loadData(Main.data_save_cursed_sword = m.getDataFolder() + "/op_cursed_sword_data");
        WandOfHome.loadData(Main.data_save_homes = m.getDataFolder() + "/wand_of_home_data");
        DimensionWand.loadData(Main.data_save_play_dim = m.getDataFolder() + "/farm_dim_play_data");

    }

    public static void saveItemData(Plugin p) {

        cursed_sword.saveData(Main.data_save_cursed_sword);

        //Bukkit.getLogger().info("Saved List<Entity> for Cursed Sword | File: /plugins/OPItems/op_cursed_sword_data");
        WandOfHome.saveData(Main.data_save_homes);

        //Bukkit.getLogger().info("Saved HashMap<String, Location> for Wand of Home | File: /plugins/OPItems/wand_of_home_data");
        DimensionWand.saveData(Main.data_save_play_dim);

        landmine.save();

    }
}
