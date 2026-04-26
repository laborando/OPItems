package cel20.op.config;

import cel20.op.GlobalVars;
import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import utis.CLogger;

public class ConfigLoader {

    public static void earlyLoadConfig(FileConfiguration config, Main plugin, Main m) {
        GlobalVars.craftingDisabled = config.getBoolean("DisableOPItemsCrafting");
    }

    public static void loadConfigs(FileConfiguration config, Main plugin, Main m) {

        //CLogger
        if (config.getInt("CLoggerMode") == 0) {
            Bukkit.getLogger().info("[OPItems] CLogger Disabled!");
        } else if (config.getInt("CLoggerMode") == 1) {
            CLogger.startAsync(m.getDataFolder().toString(), config.getInt("CLoggerFlushIntervallSec"));
            Bukkit.getLogger().info("[OPItems] CLogger Enabled in Async Mode!");
        } else if (config.getInt("CLoggerMode") == 2) {
            CLogger.startSynced(m.getDataFolder().toString(), config.getInt("CLoggerFlushIntervallSec"));
            Bukkit.getLogger().info("[OPItems] CLogger Enabled in Synced Mode!");
        }

        //ITEMS CONFIG
        if (config.getBoolean("EnableAutomaticPeriodicItemsRemove")) {
            manage.AutoItems.innitAutoRemove(config.getInt("AutomaticPeriodicItemsRemovePeriodeInMinutes"), config.getInt("AutomaticPeriodicItemsRemoveWarningDurationSecs"));
            Bukkit.getLogger().info("[OPItems] AutoItemRemove Started!");
        }

        //PrivatePocketDimensionPerformanceModeActivated
        if (config.getBoolean("PrivatePocketDimensionPerformanceModeActivated")) {
            Main.priDimPerformMode = true;
        }
        //EnableLandminePerformanceMode
        if (config.getBoolean("EnableLandminePerformanceMode")) {
            Main.landminePerfModeEnabeled = true;
        }


        Main.ore_gen_chance_private_dim = config.getInt("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock");
        Main.isprivatedimenableled = config.getBoolean("PrivatePocketDimensionEnabled");
        Main.tntBowAmount = config.getInt("TNTBowTNTAmount");
        GlobalVars.spongeClearRange = config.getInt("SuperSpongeClearRadius");

        //CDs
        GlobalVars.blitzerCD = config.getLong("BlitzerCDms");
        GlobalVars.bowerCD = config.getLong("BowerCDms");
        GlobalVars.hookOfVelectoryCD = config.getLong("HookOfVelectoryCDms");
        GlobalVars.pigCanonCD = config.getLong("PigCannonCDms");
        GlobalVars.teleportSwordCD = config.getLong("TeleportSwordCDms");
        GlobalVars.enderPearlSwordCD = config.getLong("enderPearlSwordCDms");

        //Global Settings
        GlobalVars.craftingDisabled = config.getBoolean("DisableOPItemsCrafting");

        GlobalVars.WandOfMassiveBoomsCD = config.getDouble("wandOfBoomsCDms");
        GlobalVars.WandOfMassiveBoomExploStrenght = config.getInt("WandOfMassiveBoomExplosionStrength");
        GlobalVars.WandOfBoomExploStrenght = config.getInt("WandOfBoomExplosionStrength");
    }

}
