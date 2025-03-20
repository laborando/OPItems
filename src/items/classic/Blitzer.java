package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Blitzer {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void handle(Player p){

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.blitzerCD)) {
            return;
        }


        cooldown.put(p.getName(), System.currentTimeMillis());

        Block prel = p.getTargetBlockExact(150);
        if (prel != null) {
            Location l = prel.getLocation();
            p.getWorld().strikeLightning(l);
            p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0F, 1.0F);
        }
    }

}
