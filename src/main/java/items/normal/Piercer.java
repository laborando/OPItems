package items.normal;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.ArrayList;

public class Piercer {

    private static ArrayList<Arrow> firedArrows = new ArrayList<Arrow>();

    @EventHandler
    public static void onProjectileLaunch(ProjectileLaunchEvent event) {

        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getShooter() instanceof Player) {
                Player shooter = (Player) arrow.getShooter();


                firedArrows.add(arrow);


            }
        }
    }

    @EventHandler
    public static void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getEntity();
            if (firedArrows.contains(arrow)) {

                Entity e = event.getHitEntity();

                if (e == null) {

                    firedArrows.remove(arrow);
                    return;

                }

                if (e instanceof LivingEntity) {
                    ((LivingEntity) e).damage(10.0);
                }

                event.setCancelled(true);

            }
        }
    }

}
