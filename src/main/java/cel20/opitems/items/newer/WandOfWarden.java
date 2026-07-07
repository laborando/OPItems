package cel20.opitems.items.newer;

import cel20.opitems.utis.uiutis.SubtitleUtis;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import cel20.opitems.utis.ParticleUtis;

import java.util.HashMap;
import java.util.Map;

public class WandOfWarden {

    static Map<String, Long> Cooldown = new HashMap<>();

    public static void event(final PlayerInteractEvent e) {

        final Player p = e.getPlayer();

        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK))
            return;

        final Block b = e.getClickedBlock();


        Cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if (!((System.currentTimeMillis() - Cooldown.get(p.getName())) >= 90000)) {

            SubtitleUtis.showCooldown(p);

            return;
        }


        Cooldown.put(p.getName(), System.currentTimeMillis());

        p.damage(10);


        ParticleUtis.particleCircleWithWarden(b.getLocation().add(0, 1, 0), 3, 30, Particle.DUST, Color.AQUA, 0.5f, 2, 5, p);

    }
}

