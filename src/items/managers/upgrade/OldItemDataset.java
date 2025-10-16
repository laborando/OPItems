package items.managers.upgrade;

import items.managers.rawItemsGenerator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.stream.Collectors;

public class OldItemDataset {

    public static List<OldItem> itemList;

    static boolean isCreated = false;

    public static void ensureCreatedDataset() {

        if(isCreated)
            return;

        itemList = new ArrayList<>();


        //Autocreators
        for (int i = 0; i < 100; i++) {

            ItemStack item = rawItemsGenerator.getItem(i, 1, 1);

            if (!item.getItemMeta().getDisplayName().contains("error")) {
                itemList.add(new OldItem(i, item.getType(), new ArrayList<>(item.getEnchantments().keySet())));
            }
        }

        itemList.add(new OldItem(37, Material.BLAZE_ROD, Arrays.asList(Enchantment.SWEEPING_EDGE)));
        itemList.add(new OldItem(14, Material.FEATHER, Arrays.asList(Enchantment.ARROW_FIRE)));

        isCreated = true;
    }

}
