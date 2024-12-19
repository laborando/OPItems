package cel20.op;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Queue;

public class Test {

    static BukkitTask t = null;

    public static void runCurrentTest(Player p){

        if (t != null && !t.isCancelled()) {
            return;
        }

        Location lp = p.getLocation().add(0, 1, 0);

        Queue<Location> ll = utis.celutis.getCircleLocationsQue(lp, 4, 20);

        t = new BukkitRunnable() {
            @Override
            public void run() {

                Bukkit.broadcastMessage("EXE: " + this.getTaskId());

                for (int i = 0; i < 2; i++) {
                    Location loc = ll.poll();
                    if(loc!=null){
                        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 100, 0), 0.5F);
                        loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 20, 0.3, 0.2, 0.3, dustOptions);
                    }else{

                        runCurrentTest(p);
                        this.cancel();

                    }
                }




            }
        }.runTaskTimer(Main.getPluginInstance(), 1, 1);





    }

}
