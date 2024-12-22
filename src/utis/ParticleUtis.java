package utis;

import cel20.op.Main;
import cmd.filters.SummonFilter;
import com.sun.jmx.remote.internal.ArrayQueue;
import net.minecraft.server.v1_16_R3.DedicatedServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;
import org.bukkit.*;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Filter.Result;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.Console;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ParticleUtis {

    public static void particleCircle(Location location, int radius, int amount, Particle particleType, Color color, float particleSize, int delay, int timesX){

        Queue<Location> ll = utis.celutis.getCircleLocationsQue(location, radius, amount);

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


    //summon minecraft:warden ~ ~ ~ {Brain: {memories: {"minecraft:dig_cooldown":{value: {}, ttl: 1200L}, "minecraft:is_emerging": {value: {}, ttl: 85L}}}}
    public static void particleCircleWithWarden(Location location, int radius, int amount, Particle particleType, Color color, float particleSize, int delay, int timesX, Player player){

        Queue<Location> ll = utis.celutis.getCircleLocationsQue(location, radius, amount);
        Queue<Location> copyLl = new ArrayDeque<>();

        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "execute in minecraft:" + location.getWorld().getName() + " run summon minecraft:warden " + location.getX() + " " + location.getY() + " " + location.getZ() + " {Brain: {memories: {\"minecraft:dig_cooldown\":{value: {}, ttl: 1200L}, \"minecraft:is_emerging\": {value: {}, ttl: 85L}}}}");


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



                        //Summons warden, but with no message! :O
                        ((Logger) LogManager.getRootLogger()).addFilter(new SummonFilter());

                        List<Player> ops = new ArrayList<>();

                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            if (onlinePlayer.isOp()){
                                onlinePlayer.setOp(false);
                                ops.add(onlinePlayer);
                            }
                        }


                        if(!hasDone){

                            if(location.getWorld().getName().equalsIgnoreCase("world")){
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "execute in minecraft:overworld run summon minecraft:warden " + location.getX() + " " + location.getY() + " " + location.getZ() + " {Brain: {memories: {\"minecraft:dig_cooldown\":{value: {}, ttl: 1200L}, \"minecraft:is_emerging\": {value: {}, ttl: 85L}}}}");
                            }else if(location.getWorld().getName().equalsIgnoreCase("world_nether")) {
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "execute in minecraft:the_nether run summon minecraft:warden " + location.getX() + " " + location.getY() + " " + location.getZ() + " {Brain: {memories: {\"minecraft:dig_cooldown\":{value: {}, ttl: 1200L}, \"minecraft:is_emerging\": {value: {}, ttl: 85L}}}}");
                            }else if(location.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "execute in minecraft:the_end run summon minecraft:warden " + location.getX() + " " + location.getY() + " " + location.getZ() + " {Brain: {memories: {\"minecraft:dig_cooldown\":{value: {}, ttl: 1200L}, \"minecraft:is_emerging\": {value: {}, ttl: 85L}}}}");
                            }else{
                                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "execute in minecraft:" + location.getWorld().getName() + " run summon minecraft:warden " + location.getX() + " " + location.getY() + " " + location.getZ() + " {Brain: {memories: {\"minecraft:dig_cooldown\":{value: {}, ttl: 1200L}, \"minecraft:is_emerging\": {value: {}, ttl: 85L}}}}");
                            }

                            //player.performCommand( "execute in minecraft:" + location.getWorld().getName() + " run summon minecraft:warden " + location.getX() + " " + location.getY() + " " + location.getZ() + " {Brain: {memories: {\"minecraft:dig_cooldown\":{value: {}, ttl: 1200L}, \"minecraft:is_emerging\": {value: {}, ttl: 85L}}}}");


                            hasDone = true;
                        }

                        ops.forEach(e -> e.setOp(true));



                        ((Logger) LogManager.getRootLogger()).getFilters().forEachRemaining(e ->{

                            if(e instanceof SummonFilter){
                                ((SummonFilter) e).isEnabled = false;
                            }

                        });


                        this.cancel();
                    }
                }
            }
        }.runTaskTimer(Main.getPluginInstance(), delay, 1);
    }
}
