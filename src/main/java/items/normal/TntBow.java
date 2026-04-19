package items.normal;

import cel20.op.Main;
import org.bukkit.Bukkit;
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
import utis.Celutis;

import java.util.ArrayList;

public class TntBow implements Listener {

    private static ArrayList<Arrow> firedArrows = new ArrayList<Arrow>();


    public static void onProjectileLaunch(ProjectileLaunchEvent event) {

        if (event.getEntity() instanceof Arrow) {

            Arrow arrow = (Arrow) event.getEntity();
            firedArrows.add(arrow);

        }
    }

    public static void onProjectileHit(ProjectileHitEvent event) {

        if (event.getEntity() instanceof Arrow arrow) {
            if (firedArrows.contains(arrow)) {

                Location l = arrow.getLocation();

                spawnExplosiveTNT(l);

                firedArrows.remove(arrow);
            }
        }
    }

    public static void spawnExplosiveTNT(Location location) {
        for (int i = 0; i < Main.tntbowamount; i++) {
            Location spawnLocation = location.clone().add(0.5, 0, 0.5);
            TNTPrimed tnt = (TNTPrimed) location.getWorld().spawnEntity(spawnLocation, EntityType.TNT);

            Vector velocity = new Vector(Celutis.randomRangeDouble(-0.1, 0.1), Celutis.randomRangeDouble(0.005, 0.2), Celutis.randomRangeDouble(-0.1, 0.1));
            velocity.normalize().multiply(1);


            tnt.setFuseTicks(40);
            tnt.setVelocity(velocity);

        }
    }

}
