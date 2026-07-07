package cel20.opitems.op;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/**
 * Class for running tests while developing, triggered via command
 */
public class Test {

    static BukkitTask t = null;

    /**
     * runs tests for developing, triggered via command
     */
    public static void runCurrentTest(Player p) {

        p.sendMessage(p.calculateTotalExperiencePoints() + "; " + p.getExperiencePointsNeededForNextLevel());

    }
}
