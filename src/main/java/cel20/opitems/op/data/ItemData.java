package cel20.opitems.op.data;

import cel20.opitems.items.normal.*;
import cel20.opitems.op.GlobalVars;
import cel20.opitems.op.Main;
import org.bukkit.plugin.Plugin;

public class ItemData {


    public static void loadItems(Main m) {

        Landmine.load();
        CursedSword.loadData(Main.data_save_cursed_sword = m.getDataFolder() + "/op_cursed_sword_data");
        WandOfHome.loadData(Main.data_save_homes = m.getDataFolder() + "/wand_of_home_data");
        PrivateDimensionWand.loadData(Main.data_save_play_dim = m.getDataFolder() + "/farm_dim_play_data");
        SubspaceDimensionWand.loadData(GlobalVars.SubSpaceDataFile = m.getDataFolder() + "/subspace_player_data");

    }

    public static void saveItemData(Plugin p) {

        CursedSword.saveData(Main.data_save_cursed_sword);

        WandOfHome.saveData(Main.data_save_homes);

        PrivateDimensionWand.saveData(Main.data_save_play_dim);
        SubspaceDimensionWand.saveData(GlobalVars.SubSpaceDataFile);

        Landmine.save();

    }
}
