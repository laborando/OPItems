package cel20.opitems.items.classic;

import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.player.PlayerInteractEvent;

public class Boomer {

    public static void event(final PlayerInteractEvent e) {

        Player p = e.getPlayer();

        TNTPrimed f = p.getWorld().spawn(p.getLocation(), TNTPrimed.class);

        f.setVelocity(p.getLocation().getDirection().multiply(0.67));
        f.setYield(5.0F);

        f.setVelocity(f.getVelocity().multiply(3));

    }

}
