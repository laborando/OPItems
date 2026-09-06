package cel20.opitems.op;

import cel20.opitems.api.OPItemsAPI;
import cel20.opitems.apiImplementation.OpApiImplementation;
import cel20.opitems.filebased.overrides.RecOverrideLoaders;
import cel20.opitems.metrics.MetricsHandler;
import cel20.opitems.op.config.ConfigInniter;
import cel20.opitems.op.config.ConfigLoader;
import cel20.opitems.op.data.ItemData;
import cel20.opitems.op.load.Commands;
import cel20.opitems.items.EventManager;
import cel20.opitems.items.NameSpaces;
import cel20.opitems.items.abracator.TotalItems;
import cel20.opitems.items.allRecipes.RecipeAdder;
import cel20.opitems.items.sheduled.SchedulerStarter;
import cel20.opitems.metrics.WorkerLogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import cel20.opitems.utis.CLogger;
import cel20.opitems.utis.update.CUpdater;
import cel20.opitems.utis.update.UpdateNotify;

import java.io.File;

/**
 * Main plugin class
 */
public class Main extends JavaPlugin {

    private static Main instance;

    public File getFileNonProt() {
        return super.getFile();
    }

    public static boolean priDimPerformMode = false;
    public static boolean landminePerfModeEnabled = false;
    public static int ore_gen_chance_private_dim;
    public static boolean isprivatedimenableled;
    public FileConfiguration config;
    public static String data_save_cursed_sword;
    public static String data_save_homes;
    public static String data_save_play_dim;
    public static int tntBowAmount;
    public static String opitemsVersion = "Not set yet...";
    public static CUpdater cUpdater;

    /*
     * On class-generation setters
     */
    static {
        Main.ore_gen_chance_private_dim = 100;
        Main.isprivatedimenableled = true;
        Main.tntBowAmount = 50;
    }

    /**
     * On class-generation setters
     */
    public Main() {
        this.config = this.getConfig();
    }

    public void onEnable() {
        Bukkit.getLogger().info("[OPItems] OPItems is loading...");

        opitemsVersion = "1.12.2";
        instance = this;
        final Main plugin = this;

        NameSpaces.innitNameSpaces(this);


        //EVENTS
        EventManager.innitEventManager(this);
        getServer().getPluginManager().registerEvents(new EventManager(), this);

        //CONFIG
        final FileConfiguration config = this.getConfig();
        ConfigInniter.innitConfig(config);
        config.options().copyDefaults(true);
        this.saveConfig();
        ConfigLoader.earlyLoadConfig(config, plugin, this);
        ConfigLoader.loadConfigs(config, plugin, this);

        //Commands
        Commands.setAllexecutors(this);


        //CONTENT
        ItemData.loadItems(plugin);

        RecipeAdder.addOPItemsRecipes();
        RecOverrideLoaders.load(this);
        TotalItems.addAllRecipes(); //After RecipeAdder.addOPItemsRecipes() and RecOverrideLoaders.load() !
        TotalItems.innit(this); //After TotalItems.addAllRecipes() !

        if (GlobalVars.craftingDisabled){
            TotalItems.disableCrafting();
        }

        //Cloudflare worker - Error reporting
        WorkerLogger logger = new WorkerLogger("https://plugins.opitems.workers.dev/");
        WorkerLogger.activeLogger = logger;

        //bStats
        if (!config.getBoolean("OPItemsSpecificBStatsDisable")) {
            MetricsHandler.start();
        }

        //Update Notifier
        UpdateNotify.innit(this);

        //Schedules
        SchedulerStarter.startSchedulers();

        //Make API public
        OPItemsAPI api = new OpApiImplementation();
        Bukkit.getServicesManager().register(OPItemsAPI.class, api, plugin, ServicePriority.Normal);

        //Updater
        Bukkit.getLogger().info("[OPItems] Retrieving version information...");
        cUpdater = new CUpdater(opitemsVersion, "opitems");

        Bukkit.getLogger().info("");
        Bukkit.getLogger().info("|-----------------------------|");
        Bukkit.getLogger().info("|        OPItems " + opitemsVersion + "       |");
        Bukkit.getLogger().info("|-----------------------------|");
        Bukkit.getLogger().info("");

        if (GlobalVars.craftingDisabled) {
            Bukkit.getLogger().info("[OPItems] Crafting disabled!");
        }

    }

    public void onDisable() {
        Bukkit.getLogger().warning("[OPItems] Disabling...");

        UpdateNotify.save(); //Save who will receive update notifications

        ItemData.saveItemData(this);

        TotalItems.save(); //Save which items are enabled
        TotalItems.removeAllRecipes(); //Remove all recipes for error-free restart


        try {
            CLogger.flushNow();
        } catch (NoClassDefFoundError ignored) {
        }

        MetricsHandler.stop();

        Bukkit.getLogger().warning("[OPItems] Disabled!");
    }



    /**
     * Central method for starting update processes <br>
     * Must be kept in the main method for now!
     * @param sender
     */
    public static void executeUpdate(CommandSender sender) {

        if (!cUpdater.shouldUpdate) {
            sender.sendMessage(ChatColor.GREEN + "Version " + opitemsVersion + " is already up-to-date. The most recent online version is: " + cUpdater.highestVersion.version);
            return;
        }

        sender.sendMessage(ChatColor.GREEN + "Starting update from v" + opitemsVersion + " to v" + cUpdater.highestVersion.version);

        boolean success = cUpdater.executeUpdate(Main.getInstance(), sender);

        if (success) {
            sender.sendMessage(ChatColor.GREEN + "Successfully updated! Please restart the server! There could be errors in changed classes if not restarted!");
        } else {
            sender.sendMessage(ChatColor.RED + "Failed updating!");

            if (!(sender instanceof ConsoleCommandSender)) {
                sender.sendMessage(ChatColor.RED + "Please refer to the error log in the console");
            }
        }
    }

    /**
     * @return Main instance as Main
     */
    public static Main getInstance() {
        return instance;
    }
    /**
     * @return Main instance as Plugin
     */
    public static Plugin getPluginInstance() {
        return instance;
    }


}
