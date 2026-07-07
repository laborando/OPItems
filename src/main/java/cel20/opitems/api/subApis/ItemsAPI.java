package cel20.opitems.api.subApis;

import org.bukkit.inventory.ItemStack;

public interface ItemsAPI {

    /**
     * Gets OPItems with default enchantments
     * @param id
     * @return
     */
    public ItemStack getOPItem(int id);

    /**
     * Gets OPItems with custom enchantments
     * @param id
     * @return
     */
    public ItemStack getOPItem(int id, int... lvl);

}
