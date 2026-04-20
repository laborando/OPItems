package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class TeleportSword {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void event(PlayerInteractEvent e){

        Player p = e.getPlayer();

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.teleportSwordCD)) {
            return;
        }
        cooldown.put(p.getName(), System.currentTimeMillis());

        Block tb = p.getTargetBlockExact(15);

        if(tb != null)
        {
            p.sendMessage(ChatColor.RED + "The way is blocked");
            return;
        }

        Location location = p.getLocation().clone();

        location.add(p.getEyeLocation().getDirection().multiply(13));

        p.teleportAsync(location);
    }
}
