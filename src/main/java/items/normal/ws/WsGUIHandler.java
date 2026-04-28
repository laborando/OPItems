package items.normal.ws;

import items.NameSpaces;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class WsGUIHandler
{
    public static void onInventoryClick(final InventoryClickEvent event) {
        final HumanEntity player = event.getWhoClicked();
        final ItemStack item = event.getCurrentItem();

        if (item == null || item.getItemMeta() == null) {
            return;
        }

        String abl = item.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsGui, PersistentDataType.STRING);
        if (abl != null && abl.contains("ws_locked")) {

            event.setCancelled(true);


            switch (item.getType()){
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
                case STONECUTTER:
                    player.openStonecutter(null, true);
                    break;
                case LOOM:
                    player.openLoom(null, true);
                    break;
                case ANVIL:
                    player.openAnvil(null, true);
                    break;
                case CARTOGRAPHY_TABLE:
                    player.openCartographyTable(null, true);
                    break;
                case SMITHING_TABLE:
                    player.openSmithingTable(null, true);
                    break;
            }

        }

    }
}
