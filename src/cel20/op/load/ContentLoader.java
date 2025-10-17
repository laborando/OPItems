package cel20.op.load;

import cel20.op.Main;
import items.normal.CursedSword;
import items.normal.DimensionWand;
import items.normal.Landmine;
import items.normal.WandOfHome;

public class ContentLoader {

    @Deprecated
    public static void loadContent(Main m){

        Landmine.load();
        CursedSword.loadData(m.data_save_cursed_sword = m.getDataFolder() + "/op_cursed_sword_data");
        WandOfHome.loadData(m.data_save_homes = m.getDataFolder() + "/wand_of_home_data");
        DimensionWand.loadData(m.data_save_play_dim = m.getDataFolder() + "/farm_dim_play_data");

    }

}
