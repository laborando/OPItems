package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Bower {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void handle(Player p){

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.bowerCD)) {

            return;
        }

        Arrow f = p.launchProjectile(Arrow.class);
        f.setFireTicks(1000000);
        f.setVelocity(f.getVelocity().multiply(5));
        f.setShotFromCrossbow(true);
        f.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
        f.setPierceLevel(100);
    }

}
