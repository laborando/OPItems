package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.Sound;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class PigCannon {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void handle(PlayerInteractEvent e){

        Player p = e.getPlayer();

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.pigCanonCD)) {
            return;
        }

        cooldown.put(p.getName(), System.currentTimeMillis());

        Pig f = p.getWorld().spawn(p.getLocation().add(0, 1.5, 0), Pig.class);

        f.setVelocity(p.getLocation().getDirection().multiply(2));

        p.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 1.0F);

    }

}
