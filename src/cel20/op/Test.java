package cel20.op;

import cmd.filters.SummonFilter;
import org.apache.logging.log4j.LogManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Queue;

public class Test {

    static BukkitTask t = null;

    public static void runCurrentTest(Player p) {

        final NamespacedKey key = new NamespacedKey(Main.getPluginInstance(), "opitems_desc_42");

        p.getInventory().addItem(Bukkit.getRecipe(key).getResult());

        p.sendMessage("Executing current Test: Temporary chat filter for warden summoning text / ram usage");

        if (t != null && !t.isCancelled()) {
            return;
        }

        for (int i = 0; i < 5000; i++) {
            ((org.apache.logging.log4j.core.Logger) LogManager.getRootLogger()).addFilter(new SummonFilter());

            ((org.apache.logging.log4j.core.Logger) LogManager.getRootLogger()).getFilters().forEachRemaining(e -> {

                if (e instanceof SummonFilter) {
                    ((SummonFilter) e).isEnabled = false;
                }

            });
        }

        p.sendMessage("Current Filters: " + ((org.apache.logging.log4j.core.Logger) LogManager.getRootLogger()).filterCount());

    }
}
