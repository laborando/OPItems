package cel20.op;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Test {

    static BukkitTask t = null;

    public static void runCurrentTest(Player p) {

        p.sendMessage(p.calculateTotalExperiencePoints() + "; " + p.getExperiencePointsNeededForNextLevel());

    }
}
