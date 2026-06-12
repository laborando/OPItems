package items.normal;

import org.bukkit.Material;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class InfWaterBucket {


    public static void event(final PlayerBucketEmptyEvent e) {


        e.setCancelled(true);
        e.getBlock().setType(Material.WATER);


    }
}
