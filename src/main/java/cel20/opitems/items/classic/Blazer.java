package cel20.opitems.items.classic;

import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Blazer {

    public static void event(final PlayerInteractEvent e) {

        Player p = e.getPlayer();

        Fireball f = e.getPlayer().launchProjectile(Fireball.class);
        f.setIsIncendiary(true);
        f.setYield(2.5F);
        p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.0F, 1.0F);

    }

}
