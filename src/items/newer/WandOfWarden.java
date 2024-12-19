package items.newer;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import cel20.op.Main;
import utis.celutis;

public class WandOfWarden implements Listener {

    private ArrayList<Arrow> firedArrows = new ArrayList<Arrow>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {

        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getShooter() instanceof Player) {
                Player shooter = (Player) arrow.getShooter();

                ItemStack bow = shooter.getInventory().getItemInMainHand();
                if (bow.containsEnchantment(Enchantment.SILK_TOUCH) && bow.containsEnchantment(Enchantment.LUCK)) {

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

                Location l = arrow.getLocation();

                spawnExplosiveTNT(l);

                firedArrows.remove(arrow);
            }
        }
    }

    public void spawnExplosiveTNT(Location location) {
        for (int i = 0; i < Main.tntbowamount; i++) {
            Location spawnLocation = location.clone().add(0.5, 0, 0.5);
            TNTPrimed tnt = (TNTPrimed) location.getWorld().spawnEntity(spawnLocation, EntityType.PRIMED_TNT);

            Vector velocity = new Vector(celutis.randomRangeDouble(-0.1, 0.1), celutis.randomRangeDouble(0.005, 0.2), celutis.randomRangeDouble(-0.1, 0.1));
            velocity.normalize().multiply(1);


            tnt.setFuseTicks(40);
            tnt.setVelocity(velocity);

        }
    }

}
