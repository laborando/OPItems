package items.managers.upgrade;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class for matching old items with specific materials and enchantments with their respective id <br>
 * Old versions of OPItems used enchantments instead of ids to differentiate items
 */
public class OldItem {

    public OldItem(int id, Material material, List<Enchantment> enchantmentList) {
        this.id = id;
        this.material = material;
        this.enchantmentList = enchantmentList;
    }

    public int id;

    public Material material;

    public List<Enchantment> enchantmentList;

    public boolean doesMatch(ItemStack item) {

        if (item.getType() == material)
            return doEnchantmentsMatch(item);

        return false;

    }

    public boolean doEnchantmentsMatch(ItemStack item) {

        AtomicBoolean matches = new AtomicBoolean(true);

        enchantmentList.forEach(en -> {

            if (!item.containsEnchantment(en)) {
                matches.set(false);
            }

        });

        return matches.get();
    }

}
