package cel20.op.load;

import cel20.op.Main;
import events.*;
import items.classic.OldItems;
import items.normal.DimensionWand;
import items.normal.InfWaterBucket;
import items.normal.TntBow;
import items.normal.tntlayer;
import o_guis.Gui_handler;
import org.bukkit.Bukkit;

public class Events {
    
    public static void registerAllEvents(Main m, Main plugin)
    {

        Bukkit.getPluginManager().registerEvents(m, m);
        m.getServer().getPluginManager().registerEvents(new flystick(), m);
        m.getServer().getPluginManager().registerEvents(new nofall(), m);
        m.getServer().getPluginManager().registerEvents(new armorevent(), m);
        m.getServer().getPluginManager().registerEvents(new bootevent(), m);
        m.getServer().getPluginManager().registerEvents(new leggingevent(), m);
        m.getServer().getPluginManager().registerEvents(new SuperSpongeStarter(), m);
        m.getServer().getPluginManager().registerEvents(new tntlayer(), m);
        m.getServer().getPluginManager().registerEvents(new DimensionWand(), m);
        m.getServer().getPluginManager().registerEvents(new Gui_handler(), m);
        m.getServer().getPluginManager().registerEvents(new TntBow(), m);
        m.getServer().getPluginManager().registerEvents(new InfWaterBucket(), m);
        m.getServer().getPluginManager().registerEvents(new OldItems(), m);

    }
    
}
