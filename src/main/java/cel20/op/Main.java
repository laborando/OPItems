package cel20.op;

import api.OPItemsAPI;
import apiImplementation.OpApiImplementation;
import cel20.op.config.ConfigInniter;
import cel20.op.config.ConfigLoader;
import cel20.op.data.ItemData;
import cel20.op.load.Commands;
import items.EventManager;
import items.NameSpaces;
import items.abracator.TotalItems;
import items.allRecipes.RecipeAdder;
import items.sheduled.SchedulerStarter;
import metrics.Metrics;
import metrics.WorkerLogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import utis.CLogger;
import utis.update.CUpdater;
import utis.update.UpdateNotify;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main instance;

    public File getFileNonProt() {
        return super.getFile();
    }

    public static boolean priDimPerformMode = false;
    public static boolean landminePerfModeEnabeled = false;
    public static int ore_gen_chance_private_dim;
    public static boolean isprivatedimenableled;
    public FileConfiguration config;
    static Plugin p;
    public static String data_save_cursed_sword;
    public static String data_save_homes;
    public static String data_save_play_dim;
    public static int tntBowAmount;
    public static String opitemsVersion = "Not innited";
    public static Metrics metrics;
    public static CUpdater cUpdater;


    static {
        Main.ore_gen_chance_private_dim = 100;
        Main.isprivatedimenableled = true;
        Main.tntBowAmount = 50;
    }

    public Main() {
        this.config = this.getConfig();
    }

    public void onEnable() {

        opitemsVersion = "1.11.3";
        Main.p = this;
        instance = this;
        Bukkit.getLogger().info("[OPItems] OPItems is loading...");
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
        //items
        ItemData.loadItems(plugin);

        RecipeAdder.addOPItemsRecipes();
        TotalItems.addAllRecipes();
        TotalItems.innit(this);

        if (GlobalVars.craftingDisabled)
            TotalItems.disableCrafting();

        //Newer Content
        GlobalVars.newerFeaturesEnabled = true;


        //Cloudflare worker
        WorkerLogger logger = new WorkerLogger("https://plugins.opitems.workers.dev/");
        WorkerLogger.activeLogger = logger;

        //bStats
        if (!config.getBoolean("OPItemsSpecificBStatsDisable")) {
            metrics = new Metrics(this, 27611);

            metrics.addCustomChart(new Metrics.SimplePie("newer_version_enabled", () -> "true"));


            if (GlobalVars.craftingDisabled) {
                metrics.addCustomChart(new Metrics.SimplePie("crafting_disabled", () -> "true"));
            } else {
                metrics.addCustomChart(new Metrics.SimplePie("crafting_disabled", () -> "false"));
            }
        }

        //Update Notifier
        UpdateNotify.innit(this);

        //Schedules
        SchedulerStarter.startSchedulers();

        //Make API public
        OPItemsAPI api = new OpApiImplementation();
        Bukkit.getServicesManager().register(OPItemsAPI.class, api, plugin, ServicePriority.Normal);

        //Updater
        Bukkit.getLogger().info("Retrieving version information...");
        cUpdater = new CUpdater(opitemsVersion, "opitems");

        Bukkit.getLogger().info("");


        Bukkit.getLogger().info("|-----------------------------|");
        Bukkit.getLogger().info("|        OPItems " + opitemsVersion + "       |");
        Bukkit.getLogger().info("|             by              |");
        Bukkit.getLogger().info("|            cel20            |");
        Bukkit.getLogger().info("|-----------------------------|");
        //Bukkit.getLogger().info("This is a BETA Version of OPItems!");
        Bukkit.getLogger().info("");

        if (GlobalVars.craftingDisabled) {
            Bukkit.getLogger().info("OPItems crafting is disabled!");
        }

    }

    public void onDisable() {
        Bukkit.getLogger().warning("[OPItems] Disabling. Saving Data...");

        UpdateNotify.save();

        ItemData.saveItemData(this);

        TotalItems.save();
        TotalItems.removeAllRecipes();


        try {
            CLogger.flushNow();
        } catch (NoClassDefFoundError ignored) {
        }

        metrics.shutdown();

        Bukkit.getLogger().warning("OPItems is now disabled");
    }

    public static Plugin getPluginInstance() {
        return Main.p;
    }

    public static void executeUpdate(CommandSender sender) {

        if (!cUpdater.shouldUpdate) {
            sender.sendMessage(ChatColor.GREEN + "Version " + opitemsVersion + " is already up-to-date. The most recent online version is: " + cUpdater.highestVersion.version);
            return;
        }

        sender.sendMessage(ChatColor.GREEN + "Starting update from v" + opitemsVersion + " to v" + cUpdater.highestVersion.version);

        boolean success = cUpdater.executeUpdate(Main.getInstance());

        if (success) {
            sender.sendMessage(ChatColor.GREEN + "Successfully updated! Please restart the server! There could be errors in changed classes if not restarted!");
        } else {
            sender.sendMessage(ChatColor.RED + "Failed updating!");

            if (!(sender instanceof ConsoleCommandSender)) {
                sender.sendMessage(ChatColor.RED + "Please refer to the error log in the console");
            }
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public boolean isOnPrivatePocketPerformMode() {
        return priDimPerformMode;
    }


}
