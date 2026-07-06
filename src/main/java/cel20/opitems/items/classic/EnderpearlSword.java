package cel20.opitems.items.classic;

import cel20.opitems.op.GlobalVars;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class EnderpearlSword {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void handle(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if (!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.enderPearlSwordCD)) {
            return;
        }
        cooldown.put(p.getName(), System.currentTimeMillis());

        EnderPearl ep = p.launchProjectile(EnderPearl.class);
        ep.eject();

    }
}
