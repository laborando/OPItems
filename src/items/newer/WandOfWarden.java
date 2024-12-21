package items.newer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cel20.op.Test;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import cel20.op.Main;
import utis.ParticleUtis;
import utis.celutis;

public class WandOfWarden implements Listener {

    static Map<String, Long> Cooldown = new HashMap<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {

        final Player p = e.getPlayer();
        final ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getType() == Material.BLAZE_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE) && item.containsEnchantment(Enchantment.QUICK_CHARGE)) {

            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                final Block b = e.getClickedBlock();



                Cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

                if(!((System.currentTimeMillis() - Cooldown.get(p.getName())) >= 90000)) {
                    p.sendMessage(String.valueOf(ChatColor.GRAY) + ChatColor.ITALIC + "Still on cooldown...");
                    return;
                }


                Cooldown.put(p.getName(), System.currentTimeMillis());

                p.damage(10);


                ParticleUtis.particleCircleWithWarden(b.getLocation().add(0, 1, 0), 3, 30, Particle.REDSTONE, Color.AQUA, 0.5f, 2, 5, p);

            }
        }
    }


}
