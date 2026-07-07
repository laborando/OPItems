package cel20.opitems.items.managers.upgrade;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Old versions of OPItems used enchantments instead of ids to differentiate cel20.items <br>
 * This class is a manual database of old cel20.items with their respective enchantments <br>
 * Used to upgrade cel20.items <br>
 * List|OldItem|  itemList is static and can be modified by the API if accessed directly
 */
public class OldItemDataset {

    public static List<OldItem> itemList;

    static boolean isCreated = false;

    //Not always created due to minimal usage
    public static void ensureCreatedDataset() {

        if (isCreated)
            return;

        itemList = new ArrayList<>();

        itemList.add(new OldItem(14, Material.FEATHER, Arrays.asList(Enchantment.FLAME)));
        itemList.add(new OldItem(16, Material.IRON_HELMET, Arrays.asList(Enchantment.POWER)));
        itemList.add(new OldItem(17, Material.IRON_HELMET, Arrays.asList(Enchantment.FLAME)));
        itemList.add(new OldItem(37, Material.BLAZE_ROD, Arrays.asList(Enchantment.SWEEPING_EDGE)));

        isCreated = true;
    }

}
