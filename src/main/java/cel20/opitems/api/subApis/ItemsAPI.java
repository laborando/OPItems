package cel20.opitems.api.subApis;

import org.bukkit.inventory.ItemStack;

public interface ItemsAPI {

    /**
     * Gets OPItems with default enchantments
     */
    ItemStack getOPItem(int id);

    /**
     * Gets OPItems with custom enchantments
     */
    ItemStack getOPItem(int id, int... lvl);

}
