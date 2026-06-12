package items.managers.upgrade;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldItem {

    public OldItem(int id, Material material, List<Enchantment> enchantmentList) {
        this.id = id;
        this.material = material;
        this.enchantmentList = enchantmentList;
    }

    public int id;

    public Material material;

    public List<Enchantment> enchantmentList = new ArrayList<>();

    public boolean doesMatch(ItemStack item) {

        if (item.getType() == material)
            return enchantmentsMatch(item);

        return false;

    }

    public boolean enchantmentsMatch(ItemStack item) {

        AtomicBoolean matches = new AtomicBoolean(true);

        enchantmentList.forEach(en -> {

            if (!item.containsEnchantment(en)) {
                matches.set(false);
            }

        });

        return matches.get();
    }

}
