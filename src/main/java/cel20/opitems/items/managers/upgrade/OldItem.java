package cel20.opitems.items.managers.upgrade;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class for matching old cel20.items with specific materials and enchantments with their respective id <br>
 * Old versions of OPItems used enchantments instead of ids to differentiate cel20.items
 */
public record OldItem(int id, Material material, List<Enchantment> enchantmentList) {

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
