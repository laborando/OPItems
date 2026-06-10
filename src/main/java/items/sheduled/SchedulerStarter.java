package items.sheduled;

import cel20.op.Main;
import items.sheduled.cosmetic.FireShoe;
import items.sheduled.cosmetic.NightHelmet;
import items.sheduled.effects.SpeedLeggings;
import items.sheduled.effects.WaterHelmet;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class SchedulerStarter {

    static List<BasicSchedule> scheduleList = new ArrayList<>();

    public static void startSchedulers(){

        scheduleList.add(new FireShoe());
        scheduleList.add(new WaterHelmet());
        scheduleList.add(new NightHelmet());
        scheduleList.add(new SpeedLeggings());

        //Should be replaced with one scheduler

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPluginInstance(),
                () -> scheduleList.forEach(BasicSchedule::execute)
                , 5L, 5L
        );

    }

}
