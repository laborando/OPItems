package cel20.opitems.utis;

import cel20.opitems.items.NameSpaces;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class OPItemAdjectiv {

    /**
     * Gets OPItems ID or null if ItemStack is not an OPItem
     */
    public static String getIDNSorNullIfNotOPItems(ItemStack item) {
        if (item == null) return null;
        if (item.isEmpty()) return null;

        PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();

        if (!(pdc.has(NameSpaces.opitemsMarker) || pdc.has(NameSpaces.itemTypeIDNS))) return null;

        if (!pdc.get(NameSpaces.opitemsMarker, PersistentDataType.STRING).equals("true")) return null;

        return pdc.get(NameSpaces.itemTypeIDNS, PersistentDataType.STRING);
    }

}
