package items.normal;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

public class InfWaterBucket {


    public static void event(final PlayerBucketEmptyEvent e) {


            e.setCancelled(true);
            e.getBlock().setType(Material.WATER);




    }
}
