package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PigCannon {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void handle(Player p){

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.pigCanonCD)) {
            return;
        }


        cooldown.put(p.getName(), System.currentTimeMillis());

        Arrow f = p.launchProjectile(Arrow.class);
        f.setFireTicks(0);
        f.setVelocity(f.getVelocity().multiply(0.5D));
        f.setDamage(0.0D);
        f.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
        f.setPierceLevel(0);
        f.addPassenger(p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.PIG));
        p.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 1.0F);


    }

}
