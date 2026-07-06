package cel20.opitems.op.config;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigInniter {

    public static void innitConfig(FileConfiguration config) {

        //config.options().header("This is the main configuration file for OPItems \n The server must be restarted");


        config.addDefault("CustomDimensionsPerformanceMode", Boolean.FALSE);

        config.addDefault("OPItemsSpecificBStatsDisable", Boolean.FALSE);
        config.addDefault("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock", Integer.valueOf(50));

        config.addDefault("SuperSpongeClearRadius", 20);
        config.addDefault("TNTBowTNTAmount", 50);

        //AUTOITEMSREMOVE
        config.addDefault("EnableAutomaticPeriodicItemsRemove", Boolean.FALSE);
        config.addDefault("AutomaticPeriodicItemsRemoveWarningDurationSecs", Integer.valueOf(60));
        config.addDefault("AutomaticPeriodicItemsRemovePeriodeInMinutes", Integer.valueOf(30));
        config.addDefault("EnableLandminePerformanceMode", Boolean.FALSE);
        config.addDefault("PrivatePocketDimensionEnabled", Boolean.TRUE);


        //LOGGER
        config.addDefault("CLoggerMode", Integer.valueOf(0));
        config.addDefault("CLoggerFlushIntervallSec", Integer.valueOf(300));

        //ITEMS

        config.addDefault("BowerCDms", 176);
        config.addDefault("BlitzerCDms", 666L);
        config.addDefault("PigCannonCDms", 333L);
        config.addDefault("TeleportSwordCDms", 100L);
        config.addDefault("enderPearlSwordCDms", 1000L);
        config.addDefault("HookOfVelectoryCDms", 999L);
        config.addDefault("wandOfBoomsCDms", 1000);


        config.addDefault("WandOfMassiveBoomExplosionStrength", 20);
        config.addDefault("WandOfBoomExplosionStrength", 10);


        config.addDefault("DisableOPItemsCrafting", Boolean.FALSE);
        config.addDefault("CanUpgradeItems", Boolean.TRUE);


        //Messages
        config.addDefault("CooldownMessage", "Cooldown...");


    }

}
