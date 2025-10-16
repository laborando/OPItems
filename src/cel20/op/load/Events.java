package cel20.op.load;

import cel20.op.Main;
import events.*;
import items.classic.AntiFall;
import items.classic.OldItems;
import items.classic.SpeedLeggings;
import items.classic.Sponges.SuperSpongeStarter;
import items.managers.NoDisenchanting;
import items.normal.DimensionWand;
import items.normal.InfWaterBucket;
import items.normal.TntBow;
import items.normal.Tntlayer;
import o_guis.GuiHandler;
import org.bukkit.Bukkit;

public class Events {
    
    public static void registerAllEvents(Main m, Main plugin)
    {

        Bukkit.getPluginManager().registerEvents(m, m);
        m.getServer().getPluginManager().registerEvents(new flystick(), m);
        m.getServer().getPluginManager().registerEvents(new AntiFall(), m);
        m.getServer().getPluginManager().registerEvents(new armorevent(), m);
        m.getServer().getPluginManager().registerEvents(new bootevent(), m);
        m.getServer().getPluginManager().registerEvents(new SpeedLeggings(), m);
        m.getServer().getPluginManager().registerEvents(new SuperSpongeStarter(), m);
        m.getServer().getPluginManager().registerEvents(new Tntlayer(), m);
        m.getServer().getPluginManager().registerEvents(new DimensionWand(), m);
        m.getServer().getPluginManager().registerEvents(new GuiHandler(), m);
        m.getServer().getPluginManager().registerEvents(new TntBow(), m);
        m.getServer().getPluginManager().registerEvents(new InfWaterBucket(), m);
        m.getServer().getPluginManager().registerEvents(new OldItems(), m);
        m.getServer().getPluginManager().registerEvents(new NoDisenchanting(), m);

    }
    
}
