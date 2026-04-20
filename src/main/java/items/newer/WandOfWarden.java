package items.newer;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import utis.ParticleUtis;

import java.util.HashMap;
import java.util.Map;

public class WandOfWarden implements Listener {

    static Map<String, Long> Cooldown = new HashMap<>();

    public static void event(final PlayerInteractEvent e) {

        final Player p = e.getPlayer();

        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK))
            return;

        final Block b = e.getClickedBlock();


        Cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if (!((System.currentTimeMillis() - Cooldown.get(p.getName())) >= 90000)) {
            p.sendMessage(String.valueOf(ChatColor.GRAY) + ChatColor.ITALIC + "Still on cooldown...");
            return;
        }


        Cooldown.put(p.getName(), System.currentTimeMillis());

        p.damage(10);


        ParticleUtis.particleCircleWithWarden(b.getLocation().add(0, 1, 0), 3, 30, Particle.DUST, Color.AQUA, 0.5f, 2, 5, p);

    }
}

