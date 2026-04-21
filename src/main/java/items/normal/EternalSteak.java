package items.normal;

import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class EternalSteak {


    public static void event(final PlayerItemConsumeEvent e) {

        e.getPlayer().setSaturation(20f);
        e.getPlayer().setFoodLevel(20);

        e.setCancelled(true);

    }

}
