package items.managers;

import items.NameSpaces;
import org.bukkit.Material;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class NoCrafting {
    public static void event(CraftItemEvent craftItemEvent) {

        boolean shouldCancel = false;

        for (ItemStack matrix : craftItemEvent.getInventory().getMatrix()) {

            if (isOPItem(matrix))
                shouldCancel = true;

        }

        if (shouldCancel) {
            craftItemEvent.getViewers().getFirst().sendMessage("OPItems cannot be used as crafting ingredients!");
            craftItemEvent.setCancelled(true);
        }

    }

    private static boolean isOPItem(ItemStack matrix) {

        if (matrix == null)
            return false;

        if (matrix.getType() == Material.AIR)
            return false;

        if (matrix.getItemMeta() == null)
            return false;


        String abl = matrix.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsMarker, PersistentDataType.STRING);
        if (abl != null && abl.contains("true"))
            return true;

        return false;
    }
}
