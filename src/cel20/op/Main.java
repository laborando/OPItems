
package cel20.op;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.io.File;

import cel20.op.config.ConfigInniter;
import cel20.op.config.ConfigLoader;
import cel20.op.data.ItemData;
import cel20.op.load.*;
import com.mysql.jdbc.log.Log;
import items.managers.RecipeAdder;
import org.apache.logging.log4j.LogManager;
import utis.CLogger;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import utis.Updater;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;

    public File getFileNonProt() {
        return super.getFile();
    }


    public static boolean landminePerfModeEnabeled = false;
    public HashMap<String, Long> cooldown_wand_boom;
    public HashMap<String, Long> Launcher_Cooldown;
    public static int ore_gen_chance_private_dim;
    public static int config_anti_explo_helmet_lvl;
    public static boolean isprivatedimenableled;
    public static int update;
    public FileConfiguration config;
    static Plugin p;
    public static Updater.ReleaseType update_type;
    public static String data_save_cursed_sword;
    public static String data_save_homes;
    public static String data_save_play_dim;
    public static int tntbowamount;
    public static String opitems_version = "Not Innited";

    public static boolean priDimPerformMode = false;

    static {
        Main.ore_gen_chance_private_dim = 100;
        Main.config_anti_explo_helmet_lvl = 75;
        Main.isprivatedimenableled = true;
        Main.update = 0;
        Main.update_type = null;
        Main.tntbowamount = 50;
    }

    public Main() {
        this.cooldown_wand_boom = new HashMap<>();
        this.Launcher_Cooldown = new HashMap<>();
        this.config = this.getConfig();
        data_save_cursed_sword = null;
        data_save_homes = null;
        data_save_play_dim = null;
    }

    public void onEnable() {

        Main.p = this;
        instance = this;
        Bukkit.getLogger().info("[OPItems] OPItems is loading...");
        final Main plugin = this;

        String mcVer = Bukkit.getVersion();

        boolean sheduleNewerFeatures = false;

        try {
            String majVer = mcVer.split("\\.")[1];
            Bukkit.getLogger().info("Server is running major version " + majVer);
            if (Integer.parseInt(majVer) > 19) {
                sheduleNewerFeatures = true;
            }
        } catch (Exception ignored) {
        }

        //EVENTS
        Events.registerAllEvents(this, plugin);

        //CONFIG
        final FileConfiguration config = this.getConfig();
        ConfigInniter.innitConfig(config);
        config.options().copyDefaults(true);
        this.saveConfig();
        ConfigLoader.loadConfigs(config, plugin, this);

        //Updater
        UpdateHandler.handleStartupUpdater(this);

        //Commands
        Commands.setAllexecutors(this);

        //CONTENT
        //items
        ItemData.loadItems(plugin);
        //Newer Content
        if (config.getBoolean("EnableItemsForNewerVersions")) {
            if (sheduleNewerFeatures) {
                VersionDependent.loadNewerItems(this);
                GlobalVars.newerFeaturesEnabled = true;
                Bukkit.getLogger().info("Features for newer Versions enabled.");
            } else {
                Bukkit.getLogger().info("Features for newer Versions not enabled. Please use Mc1.20+");
            }
        }

        Bukkit.getLogger().info("[OPItems]Successfully Enabled");


        Bukkit.getLogger().info("");


        Bukkit.getLogger().info("|-----------------------------|");
        Bukkit.getLogger().info("|        OPItems 1.9.8 BETA   |");
        Bukkit.getLogger().info("|             by              |");
        Bukkit.getLogger().info("|            cel20            |");
        Bukkit.getLogger().info("|-----------------------------|");
        Bukkit.getLogger().info("This is a BETA Version of OPItems!");
        Bukkit.getLogger().info("");
        opitems_version = "1.9.8";

    }

    public void onDisable() {
        Bukkit.getLogger().warning("[OPItems] Disabling. Saving Data...");

        ItemData.saveItemData(this);

        RecipeAdder.removeRecipe();

        try {
            CLogger.flushNow();
        } catch (NoClassDefFoundError ignored) {
        }

        Bukkit.getLogger().warning("OPItems is now disabled");
    }

    public static Plugin getPluginInstance() {
        return Main.p;
    }

    public Logger getLoggerClass() {
        return super.getLogger();
    }

    private static int randomrange(final int min, final int max) {
        return (int) utis.celutis.randomRangeDouble(min, max);
    }

    public static void executeUpdate(CommandSender sender) {
        UpdateHandler.executeUpdate(sender, Main.getInstance());
    }

    public static Main getInstance() {
        return instance;
    }

    public boolean isOnPrivatePocketPerformMode() {
        return priDimPerformMode;
    }

}
