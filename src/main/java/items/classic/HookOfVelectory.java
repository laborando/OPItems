

package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;


public class HookOfVelectory {

    static Map<String, Long> cooldown = new HashMap<>();

    public static void onFish(final PlayerFishEvent e) {

        Player p = e.getPlayer();


        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if (!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.hookOfVelectoryCD)) {
            return;
        }

        if (e.getState() == PlayerFishEvent.State.FISHING)
            return;

        cooldown.put(p.getName(), System.currentTimeMillis());


        if (e.getState() == PlayerFishEvent.State.REEL_IN) {


            final Location pl = p.getLocation();
            final Location hl = e.getHook().getLocation();
            final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
            p.setVelocity(vec);

        }

        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

            final Location pl = p.getLocation();
            final Location hl = e.getHook().getLocation();
            final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
            p.setVelocity(vec);

        }
        if (e.getState() == PlayerFishEvent.State.IN_GROUND) {

            final Location pl = p.getLocation();
            final Location hl = e.getHook().getLocation();
            final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
            p.setVelocity(vec);

        }
        if (e.getState() == PlayerFishEvent.State.BITE) {

            final Location pl = p.getLocation();
            final Location hl = e.getHook().getLocation();
            final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
            p.setVelocity(vec);

        }
        if (e.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {

            final Location pl = p.getLocation();
            final Location hl = e.getHook().getLocation();
            final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
            p.setVelocity(vec);

        }
        if (e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT) {


            final Location pl = p.getLocation();
            final Location hl = e.getHook().getLocation();
            final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
            p.setVelocity(vec);

        }
    }
}
