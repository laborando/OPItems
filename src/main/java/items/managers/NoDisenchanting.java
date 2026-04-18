package items.managers;

import cel20.op.GlobalVars;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class NoDisenchanting implements Listener {



    @EventHandler(priority = EventPriority.HIGH)
    public void event(final InventoryClickEvent e) {

        if(e.getWhoClicked().getOpenInventory().getType() == InventoryType.GRINDSTONE && e.isShiftClick()){
            final ItemStack item = e.getCurrentItem();
            if (item == null || item.getItemMeta() == null) {
                return;
            }

            String abl = item.getItemMeta().getPersistentDataContainer().get(GlobalVars.opitemsMarker, PersistentDataType.STRING);
            if (abl != null && abl.contains("true")) {

                e.setCancelled(true);

            }
        }

        if(e.getClickedInventory() == null || !(e.getClickedInventory().getType() == InventoryType.GRINDSTONE))
            return;

        final ItemStack item = e.getCursor();
        if (item == null || item.getItemMeta() == null) {
            return;
        }

        String abl = item.getItemMeta().getPersistentDataContainer().get(GlobalVars.opitemsMarker, PersistentDataType.STRING);
        if (abl != null && abl.contains("true")) {

            e.setCancelled(true);

        }
    }

}
