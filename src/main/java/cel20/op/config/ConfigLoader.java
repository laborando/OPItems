package cel20.op.config;

import cel20.op.GlobalVars;
import cel20.op.Main;
import items.managers.OldRecipeAdder;
import items.normal.ws.WsGUIHandler;
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

        if (config.getBoolean("AllowCraftTheAntiDamage")) {
            OldRecipeAdder.addRecipe3(plugin, config.getInt("CraftedTheAntiDamageProtectionEnchantmentLevel"));
        }
        if (config.getBoolean("AllowBower")) {
            OldRecipeAdder.addRecipe4(plugin);
        }
        if (config.getBoolean("AllowBlazer")) {
            OldRecipeAdder.addRecipe5(plugin);
        }
        if (config.getBoolean("AllowBoomer")) {
            OldRecipeAdder.addRecipe6(plugin);
        }
        if (config.getBoolean("AllowCraftPickyPick")) {
            final int speed = config.getInt("CraftedPickyPickDigSpeedEnchantmentLevel");
            final int loot = config.getInt("CraftedPickyPickLootBonusBlocksEnchantmentLevel");
            OldRecipeAdder.addRecipe7(plugin, speed, loot);
        }
        if (config.getBoolean("AllowPigCannon")) {
            OldRecipeAdder.addRecipe8(plugin);
        }
        if (config.getBoolean("AllowPigCannon")) {
            OldRecipeAdder.addRecipe9(plugin);
        }
        if (config.getBoolean("AllowEndsword")) {
            OldRecipeAdder.addRecipe10(plugin);
        }
        if (config.getBoolean("AllowBlitzer")) {
            OldRecipeAdder.addRecipe11(plugin);
        }
        if (config.getBoolean("AllowCrafter")) {
            OldRecipeAdder.addRecipe12(plugin);
        }
        if (config.getBoolean("AllowFlyFeather")) {
            OldRecipeAdder.addRecipe13(plugin);
        }
        if (config.getBoolean("AllowAntiFall")) {
            OldRecipeAdder.addRecipe14(plugin);
        }
        if (config.getBoolean("AllowHookOfVelectory")) {
            OldRecipeAdder.addRecipe15(plugin);
        }
        if (config.getBoolean("AllowCraftNightVisor")) {
            OldRecipeAdder.addRecipe16(plugin);
        }
        if (config.getBoolean("AllowCraftWaterHelmet")) {
            OldRecipeAdder.addRecipe17(plugin);
        }
        if (config.getBoolean("AllowCraftFireShoes")) {
            OldRecipeAdder.addRecipe18(plugin);
        }
        if (config.getBoolean("AllowCraftLauncher")) {
            OldRecipeAdder.addRecipe19(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfBoom")) {
            OldRecipeAdder.addRecipe20(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfMassiveBoom")) {
            OldRecipeAdder.addRecipe21(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfInvisibility")) {
            OldRecipeAdder.addRecipe22(plugin);
        }
        if (config.getBoolean("AllowCraftSpeedLeggings")) {
            OldRecipeAdder.addRecipe23(plugin);
        }
        if (config.getBoolean("AllowCraftSuperSponge")) {
            OldRecipeAdder.addRecipe24(plugin);
        }
        if (config.getBoolean("AllowCraftLavaSponge")) {
            OldRecipeAdder.addRecipe25(plugin);
        }
        if (config.getBoolean("AllowCraftEnderpealer")) {
            OldRecipeAdder.addRecipe26(plugin);
        }
        if (config.getBoolean("AllowCraftTNTDetonator")) {
            OldRecipeAdder.addRecipe27(plugin);
        }
        if (config.getBoolean("AllowCraftCursedSword")) {
            OldRecipeAdder.addRecipe28(plugin);
        }
        if (config.getBoolean("AllowCraftPrivatePocketDimension")) {
            OldRecipeAdder.addRecipe29(plugin);
        }
        if (config.getBoolean("AllowCraftAntiExplosionHelmet")) {
            OldRecipeAdder.addRecipe30(plugin);
        }
//AllowCraftandActivatedWandofHome
        if (config.getBoolean("AllowCraftWandOfHome")) {
            OldRecipeAdder.addRecipe31(plugin);
        }
//AllowCraftTNTBow        
        if (config.getBoolean("AllowCraftTNTBow")) {
            OldRecipeAdder.addRecipe32(plugin);
        }
        //AllowCraftWandofBlocks
        if (config.getBoolean("AllowCraftWandofBlocks")) {
            OldRecipeAdder.addRecipe33(plugin);
        }
        //EnablePortal2Go
        if (config.getBoolean("EnablePortal2Go")) {
            OldRecipeAdder.addRecipe34(plugin);
        }

        //config.addDefault("EnableCraftSkullImitator", (Object)true);
        if (config.getBoolean("EnableSkullImitator")) {
            OldRecipeAdder.addRecipe35(plugin);
        }
        //PrivatePocketDimensionPerformanceModeActivated
        if (config.getBoolean("PrivatePocketDimensionPerformanceModeActivated")) {
            Main.priDimPerformMode = true;
        }
        //EnableLandmine
        if (config.getBoolean("EnableLandmine")) {
            OldRecipeAdder.addRecipe36(plugin);
            OldRecipeAdder.addRecipe37(plugin);
        }
        //AllowCraftInfWaterBucket
        if (config.getBoolean("AllowCraftInfWaterBucket")) {
            OldRecipeAdder.addRecipe38(plugin);
        }
        //EnableLandminePerformanceMode
        if (config.getBoolean("EnableLandminePerformanceMode")) {
            Main.landminePerfModeEnabeled = true;
        }

        //AllowCraftProtectiveElytra
        if (config.getBoolean("AllowCraftInfWaterBucket")) {
            OldRecipeAdder.addRecipe39(plugin);
        }

        OldRecipeAdder.addRecipe40(plugin);

        if (config.getBoolean("EnableCraftWandOfWarden")) {
            OldRecipeAdder.addRecipe41(plugin);
        }
        //Piercer

        if (config.getBoolean("AllowCraftPiercer")) {
            GlobalVars.piercerDamageLevel = config.getInt("PiercerDamageLevel", 3);
            GlobalVars.piercerKnockbackLevel = config.getInt("PiercerKnockbackLevel", 3);
            OldRecipeAdder.addRecipe43(plugin);
        }

        //ActivateWorkstation
        if (config.getBoolean("ActivateWorkstation")) {
            m.getServer().getPluginManager().registerEvents(new WsGUIHandler(), m);
            OldRecipeAdder.addRecipe44(plugin);
        }

        Main.ore_gen_chance_private_dim = config.getInt("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock");
        Main.isprivatedimenableled = config.getBoolean("PrivatePocketDimensionEnabled");
        Main.config_anti_explo_helmet_lvl = config.getInt("AntiExplosionHelmetAntiExploEnchLevel");
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
        GlobalVars.WandOfMassiveBoomExploStrenght = config.getInt("WandOfMassive_BoomExplosionStrength");
        GlobalVars.WandOfBoomExploStrenght = config.getInt("WandOfBoomExplosionStrength");
    }

}
