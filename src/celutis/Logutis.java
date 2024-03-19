package celutis;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Logutis {


    public static void createReportAndLog(){

        List<String> rep = new ArrayList<>();

        rep.add("Version: " + Bukkit.getVersion());
        rep.add("BukkitVersion: " + Bukkit.getBukkitVersion());
        rep.add("Scheduler: " + Bukkit.getScheduler());
        rep.add("WorldType: " + Bukkit.getWorldType());
        rep.add("ItemFactory: " + Bukkit.getItemFactory());
        rep.add("WarningState: " + Bukkit.getWarningState());
        rep.add("WorldContainer: " + Bukkit.getWorldContainer());
        rep.add("Plugins:");
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            rep.add("   - " + plugin.getName());
            rep.add("      -> Enabled: " + plugin.isEnabled());
            rep.add("      -> Naggable: " + plugin.isNaggable());
            rep.add("      -> Desc: " + plugin.getDescription());
        }


        for (String s : rep) {
            CLogger.log(s);
        }
        CLogger.flushNow();

    }

}
