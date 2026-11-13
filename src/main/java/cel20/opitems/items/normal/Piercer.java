package cel20.opitems.items.normal;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.ArrayList;

public class Piercer {

    private static final ArrayList<Arrow> firedArrows = new ArrayList<>();

    public static void onProjectileLaunch(ProjectileLaunchEvent event) {

        if (event.getEntity() instanceof Arrow arrow) {
            if (arrow.getShooter() instanceof Player shooter) {


                firedArrows.add(arrow);


            }
        }
    }

    public static void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow arrow) {
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
