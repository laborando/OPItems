package items.normal;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

public class Other implements Listener {


    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerBucketEmptyEvent e) {
        final Player p = (Player) e.getPlayer();
        final ItemStack item = p.getInventory().getItemInMainHand();
        if(item.getItemMeta() == null){
            return;
        }
        if (item.getType() == Material.WATER_BUCKET && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Infinitive Water Bucket")) {

                e.setCancelled(true);
                e.getBlock().setType(Material.WATER);

        }
    }


}
