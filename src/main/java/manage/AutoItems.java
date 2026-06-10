package manage;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/**
 * Class for automated scheduled item remover
 */
public class AutoItems {
    static BukkitTask removalTask = null;

    /**
     * Inits automated scheduled removal of dropped items
     * @param delay
     * @param warning_sek
     */
    public static void innitAutoRemove(int delay, int warning_sek){

        removalTask = new BukkitRunnable() {
            @Override
            public void run() {

                Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "WARNING: All loaded an dropper items will be deleted in " + warning_sek + " seconds!");

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

        if(removalTask != null){
            removalTask.cancel();
        }

    }

}
