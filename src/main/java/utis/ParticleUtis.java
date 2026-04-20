package utis;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.entity.Warden;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class ParticleUtis {

    public static void particleCircle(Location location, int radius, int amount, Particle particleType, Color color, float particleSize, int delay, int timesX){

        Queue<Location> ll = Celutis.getCircleLocationsQue(location, radius, amount);

        Queue<Location> copyLl = new ArrayDeque<>(ll);

        for (int i = 0; i < timesX; i++) {

            ll.addAll(copyLl);

        }


        new BukkitRunnable() {
            @Override
            public void run() {

                for (int i = 0; i < 2; i++) {
                    Location loc = ll.poll();
                    if(loc!=null) {
                        Particle.DustOptions dustOptions = new Particle.DustOptions(color, particleSize);
                        Objects.requireNonNull(loc.getWorld()).spawnParticle(particleType, loc, 20, 0.3, 0.2, 0.3, dustOptions);
                    }else{
                        this.cancel();
                    }
                }
            }
        }.runTaskTimer(Main.getPluginInstance(), delay, 1);
    }


    public static void particleCircleWithWarden(Location location, int radius, int amount, Particle particleType, Color color, float particleSize, int delay, int timesX, Player player){

        Queue<Location> ll = Celutis.getCircleLocationsQue(location, radius, amount);
        Queue<Location> copyLl = new ArrayDeque<>();

        copyLl.addAll(ll);

        for (int i = 0; i < timesX; i++) {

            ll.addAll(copyLl);

        }


        new BukkitRunnable() {
            @Override
            public void run() {
                boolean hasDone = false;
                for (int i = 0; i < 2; i++) {
                    Location loc = ll.poll();
                    if(loc!=null) {
                        Particle.DustOptions dustOptions = new Particle.DustOptions(color, particleSize);
                        Objects.requireNonNull(loc.getWorld()).spawnParticle(particleType, loc, 20, 0.3, 0.2, 0.3, dustOptions);
                    }else{




                        if(!hasDone){

                            Warden w = location.getWorld().spawn(location, Warden.class);

                            w.setPose(Pose.EMERGING);

                            hasDone = true;
                        }



                        this.cancel();
                    }
                }
            }
        }.runTaskTimer(Main.getPluginInstance(), delay, 1);
    }
}
