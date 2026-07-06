package cel20.opitems.items.classic;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Crafter {

    public static void event(final PlayerInteractEvent e) {

        Player p = e.getPlayer();

        p.openWorkbench(null, true);

        e.setCancelled(true);

    }

}
