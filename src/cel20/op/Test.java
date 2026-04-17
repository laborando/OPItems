package cel20.op;

import cmd.filters.SummonFilter;
import org.apache.logging.log4j.LogManager;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Test {

    static BukkitTask t = null;

    public static void runCurrentTest(Player p) {
        p.sendMessage("Current Filters: " + ((org.apache.logging.log4j.core.Logger) LogManager.getRootLogger()).filterCount());
    }
}
