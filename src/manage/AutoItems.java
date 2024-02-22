package manage;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class AutoItems {
    static BukkitTask otherTask = null;
    public static void innitAutoRemove(int delay, int warning_sek){

        //System.out.println(Main.getPluginInstance());

        otherTask = new BukkitRunnable() {
            @Override
            public void run() {

                Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "WARNING: ALL LOADED DROPPED ITEMS WILL BE DELETED IN " + warning_sek + " SECS!");

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Items i = new Items();
                        i.removeItems();
                        Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.DARK_RED + "All dropped Items deleted!");

                    }
                }.runTaskLater(Main.getPluginInstance(), 20L * warning_sek /*<-- the delay */);



            }
        }.runTaskTimer(Main.getInstance(), (10+delay)*20L, 60*delay*20L);


    }

    public static void cancelAutomatedItemRemoval(){

        if(otherTask != null){
            otherTask.cancel();
        }

    }

}
