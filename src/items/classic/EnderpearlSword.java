package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class EnderpearlSword {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void handle(Player p){

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.enderPearlSwordCD)) {
            return;
        }
        cooldown.put(p.getName(), System.currentTimeMillis());

        EnderPearl ep = p.launchProjectile(EnderPearl.class);
        ep.setBounce(true);
        ep.eject();

    }
}
