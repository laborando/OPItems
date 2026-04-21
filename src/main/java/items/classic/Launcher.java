package items.classic;

import cel20.op.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class Launcher {


    public static HashMap<String, Long> Cooldown = new HashMap<>();

    public static void event(final PlayerInteractEvent e) {

        Player p = e.getPlayer();

        double cooldownTime = Main.getInstance().config.getDouble("launcherCDms");

        if (Cooldown.containsKey(p.getName())) {
            double secondsLeft = ((double) Cooldown.get(p.getName()) / 1000L) + cooldownTime / 1000.0D - ((double) System.currentTimeMillis() / 1000L);
            if (secondsLeft > 0.0D) {
                //p.sendMessage(ChatColor.RED + "You cant use this Item for another " + secondsLeft + " seconds!");
                return;
            }
        }
        Player player = e.getPlayer();
        Location pLoc = player.getLocation();
        org.bukkit.util.Vector vec = new org.bukkit.util.Vector(0.0D, pLoc.getY() + 50, 0.0D);

        player.setVelocity(vec);
        Cooldown.put(p.getName(), System.currentTimeMillis());

    }

}
