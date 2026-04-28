package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class WandOfBoom {

    static HashMap<String, Long> cooldown = new HashMap<>();

    public static void event(final PlayerInteractEvent e) {

        Player p = e.getPlayer();

        double cooldownTime = GlobalVars.WandOfMassiveBoomsCD;
        if (cooldown.containsKey(p.getName())) {
            double secondsLeft = ((double) cooldown.get(p.getName()) / 1000L) + cooldownTime / 1000.0D - ((double) System.currentTimeMillis() / 1000L);
            if (secondsLeft > 0.0D) {
                p.sendMessage(ChatColor.RED + "You cant use this Item for another " + ((int) secondsLeft + 1 ) + " seconds!");
                return;
            }
        }
        Block target = p.getTargetBlockExact(150);
        if (target != null) {
            Location location = target.getLocation();
            p.getWorld().createExplosion(location, GlobalVars.WandOfBoomExploStrenght);
            cooldown.put(p.getName(), System.currentTimeMillis());
        }

    }
}
