package items.classic.sheduled;

import cel20.op.Main;
import items.classic.sheduled.cosmetic.FireShoe;
import items.classic.sheduled.cosmetic.NightHelmet;
import items.classic.sheduled.cosmetic.WaterHelmet;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class SchedulerStarter {

    static List<BasicSchedule> scheduleList = new ArrayList<>();

    public static void startSchedulers(){

        scheduleList.add(new FireShoe());
        scheduleList.add(new WaterHelmet());
        scheduleList.add(new NightHelmet());

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPluginInstance(),
                () -> scheduleList.forEach(BasicSchedule::execute)
                , 5L, 5L
        );

    }

}
