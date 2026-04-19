package items.normal.ws;

import cel20.op.GlobalVars;
import items.NameSpaces;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class WsGUIHandler implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(final InventoryClickEvent event) {
        final HumanEntity player = event.getWhoClicked();
        final ItemStack item = event.getCurrentItem();
        final Inventory inv = event.getClickedInventory();

        if (item == null || item.getItemMeta() == null) {
            return;
        }

        String abl = item.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsGui, PersistentDataType.STRING);
        if (abl != null && abl.contains("ws_locked")) {

            event.setCancelled(true);

            Inventory i;

            switch (item.getType()){
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
                case STONECUTTER:
                    i = Bukkit.createInventory(player, InventoryType.GRINDSTONE);
                    player.openInventory(i);
                    break;
                case LOOM:
                    i = Bukkit.createInventory(player, InventoryType.LOOM);
                    player.openInventory(i);
                    break;
                case ANVIL:
                    i = Bukkit.createInventory(player, InventoryType.ANVIL);
                    player.openInventory(i);
                    break;
                case CARTOGRAPHY_TABLE:
                    i = Bukkit.createInventory(player, InventoryType.CARTOGRAPHY);
                    player.openInventory(i);
                    break;
                case SMITHING_TABLE:
                    i = Bukkit.createInventory(player, InventoryType.SMITHING);
                    player.openInventory(i);
                    break;
            }

        }

    }
}
