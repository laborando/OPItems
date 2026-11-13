package cel20.opitems.items.classic;

import cel20.opitems.op.GlobalVars;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class Blitzer {

    static final Map<String, Long> cooldown = new HashMap<>();

    public static void handle(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if (!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.blitzerCD)) {
            return;
        }


        cooldown.put(p.getName(), System.currentTimeMillis());

        Block target = p.getTargetBlockExact(150);
        if (target != null) {
            Location l = target.getLocation();
            p.getWorld().strikeLightning(l);
            p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0F, 1.0F);
        }
    }

}
