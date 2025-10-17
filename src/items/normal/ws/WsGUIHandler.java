package items.normal.ws;

import cel20.op.GlobalVars;
import items.managers.giveItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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

        String abl = item.getItemMeta().getPersistentDataContainer().get(GlobalVars.opitemsGui, PersistentDataType.STRING);
        if (abl != null && abl.contains("ws_locked")) {

            event.setCancelled(true);

        }

    }
}
