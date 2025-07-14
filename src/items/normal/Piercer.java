package items.normal;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import utis.celutis;

import java.util.ArrayList;

public class Piercer  implements Listener {

    private ArrayList<Arrow> firedArrows = new ArrayList<Arrow>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {

        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getShooter() instanceof Player) {
                Player shooter = (Player) arrow.getShooter();

                ItemStack bow = shooter.getInventory().getItemInMainHand();
                if (bow.containsEnchantment(Enchantment.ARROW_KNOCKBACK) && bow.containsEnchantment(Enchantment.LUCK)) {

                    firedArrows.add(arrow);

                }
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (firedArrows.contains(arrow)) {

                Entity e = event.getHitEntity();

                if (e == null)
                    return;

                if (e instanceof LivingEntity) {
                    ((LivingEntity)e).damage(10.0);
                }

                event.setCancelled(true);

            }
        }
    }

}
