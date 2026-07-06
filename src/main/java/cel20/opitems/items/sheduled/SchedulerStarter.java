package cel20.opitems.items.sheduled;

import cel20.opitems.op.Main;
import cel20.opitems.items.sheduled.cosmetic.FireShoe;
import cel20.opitems.items.sheduled.cosmetic.NightHelmet;
import cel20.opitems.items.sheduled.effects.SpeedLeggings;
import cel20.opitems.items.sheduled.effects.WaterHelmet;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class SchedulerStarter {

    static List<BasicSchedule> scheduleList = new ArrayList<>();

    public static void startSchedulers() {

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
