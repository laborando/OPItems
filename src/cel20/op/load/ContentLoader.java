package cel20.op.load;

import cel20.op.Main;
import items.normal.DimensionWand;
import items.normal.WandOfHome;
import items.normal.cursed_sword;
import items.normal.landmine;

public class ContentLoader {

    @Deprecated
    public static void loadContent(Main m){

        landmine.load();
        cursed_sword.loadData(m.data_save_cursed_sword = m.getDataFolder() + "/op_cursed_sword_data");
        WandOfHome.loadData(m.data_save_homes = m.getDataFolder() + "/wand_of_home_data");
        DimensionWand.loadData(m.data_save_play_dim = m.getDataFolder() + "/farm_dim_play_data");

    }

}
