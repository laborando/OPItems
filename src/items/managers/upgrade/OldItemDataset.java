package items.managers.upgrade;

import items.managers.RawItemsGenerator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldItemDataset {

    public static List<OldItem> itemList;

    static boolean isCreated = false;

    public static void ensureCreatedDataset() {

        if(isCreated)
            return;

        itemList = new ArrayList<>();


        //Autocreators
        for (int i = 0; i < 100; i++) {

            ItemStack item = RawItemsGenerator.getItem(i, 1, 1);

            if (!item.getItemMeta().getDisplayName().contains("error")) {
                itemList.add(new OldItem(i, item.getType(), new ArrayList<>(item.getEnchantments().keySet())));
            }
        }

        itemList.add(new OldItem(14, Material.FEATHER, Arrays.asList(Enchantment.ARROW_FIRE)));
        itemList.add(new OldItem(16, Material.IRON_HELMET, Arrays.asList(Enchantment.ARROW_DAMAGE)));
        itemList.add(new OldItem(17, Material.IRON_HELMET, Arrays.asList(Enchantment.ARROW_FIRE)));
        itemList.add(new OldItem(37, Material.BLAZE_ROD, Arrays.asList(Enchantment.SWEEPING_EDGE)));

        isCreated = true;
    }

}
