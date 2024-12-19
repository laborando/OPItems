package cel20.op.config;

import cel20.op.GlobalVars;
import cel20.op.Main;
import items.managers.RecipeAdder;
import items.normal.*;
import utis.CLogger;
import events.hookofvelectory;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigLoader {

    public static void loadConfigs(FileConfiguration config, Main plugin, Main m){

        //CLogger
        if (config.getInt("CLoggerMode")==0) {
            Bukkit.getLogger().info("[OPItems] CLogger Disabled!");
        }else if (config.getInt("CLoggerMode")==1) {
            CLogger.startAsync(m.getDataFolder().toString(), config.getInt("CLoggerFlushIntervallSec"));
            Bukkit.getLogger().info("[OPItems] CLogger Enabled in Asynk Mode!");
        }else if (config.getInt("CLoggerMode")==2) {
            CLogger.startSynced(m.getDataFolder().toString(), config.getInt("CLoggerFlushIntervallSec"));
            Bukkit.getLogger().info("[OPItems] CLogger Enabled in Synked Mode!");
        }

        //ITEMS CONFIG
        if (config.getBoolean("EnableAutomaticPeriodicItemsRemove")) {
            manage.AutoItems.innitAutoRemove(config.getInt("AutomaticPeriodicItemsRemovePeriodeInMinutes"), config.getInt("AutomaticPeriodicItemsRemoveWarningDurationSecs"));
            Bukkit.getLogger().info("[OPItems] AutoItemRemove Started!");
        }

        //ActivateWandofBlocks
        if (config.getBoolean("ActivateWandofBlocks")) {
            m.getServer().getPluginManager().registerEvents(new WandOfBlocks(), m);
        }

        //EnableRiptider
        if (config.getBoolean("EnableRiptider")) {
            m.getServer().getPluginManager().registerEvents(new Riptider(), m);
            RecipeAdder.addRecipe40(plugin);
        }


        if (config.getBoolean("CursedSwordEnabled")) {
            m.getServer().getPluginManager().registerEvents(new cursed_sword(), m);
        }
        if (config.getBoolean("AllowCraftOtherItems")) {
            RecipeAdder.addRecipe1(plugin, config.getInt("CraftedKnockyTheStickKnockbackEnchantmentLevel"));
        }
        if (config.getBoolean("AllowCraftOtherItems")) {
            RecipeAdder.addRecipe2(plugin, config.getInt("CraftedBlockySwordDamageAllEnchantmentLevel"));
        }
        if (config.getBoolean("AllowCraftOtherItems")) {
            RecipeAdder.addRecipe3(plugin);
        }
        if (config.getBoolean("AllowBower")) {
            RecipeAdder.addRecipe4(plugin);
        }
        if (config.getBoolean("AllowBlazer")) {
            RecipeAdder.addRecipe5(plugin);
        }
        if (config.getBoolean("AllowBommer")) {
            RecipeAdder.addRecipe6(plugin);
        }
        if (config.getBoolean("AllowCraftOtherItems")) {
            final int speed = config.getInt("CraftedPickyPickDigSpeedEnchantmentLevel");
            final int loot = config.getInt("CraftedPickyPickLootBonusBlocksEnchantmentLevel");
            RecipeAdder.addRecipe7(plugin, speed, loot);
        }
        if (config.getBoolean("AllowPigCannon")) {
            RecipeAdder.addRecipe8(plugin);
        }
        if (config.getBoolean("AllowPigCannon")) {
            RecipeAdder.addRecipe9(plugin);
        }
        if (config.getBoolean("AllowEndsword")) {
            RecipeAdder.addRecipe10(plugin);
        }
        if (config.getBoolean("AllowBlitzer")) {
            RecipeAdder.addRecipe11(plugin);
        }
        if (config.getBoolean("AllowCrafter")) {
            RecipeAdder.addRecipe12(plugin);
        }
        if (config.getBoolean("AllowFlyFeather")) {
            RecipeAdder.addRecipe13(plugin);
        }
        if (config.getBoolean("AllowAntiFall")) {
            RecipeAdder.addRecipe14(plugin);
        }
        if (config.getBoolean("AllowHookofVelectory")) {
            RecipeAdder.addRecipe15(plugin);
            m.getServer().getPluginManager().registerEvents(new hookofvelectory(), m);
        }
        if (config.getBoolean("AllowCraftNightVisor")) {
            RecipeAdder.addRecipe16(plugin);
        }
        if (config.getBoolean("AllowCraftWaterHelmet")) {
            RecipeAdder.addRecipe17(plugin);
        }
        if (config.getBoolean("AllowCraftFireShoes")) {
            RecipeAdder.addRecipe18(plugin);
        }
        if (config.getBoolean("AllowCraftLaucher")) {
            RecipeAdder.addRecipe19(plugin);
        }
        if (config.getBoolean("AllowCraftLauncher")) {
            RecipeAdder.addRecipe19(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfBoom")) {
            RecipeAdder.addRecipe20(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfMassiveBoom")) {
            RecipeAdder.addRecipe21(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfInvisiblity")) {
            RecipeAdder.addRecipe22(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfInvisibility")) {
            RecipeAdder.addRecipe22(plugin);
        }
        if (config.getBoolean("AllowCraftSpeedLeggings")) {
            RecipeAdder.addRecipe23(plugin);
        }
        if (config.getBoolean("AllowCraftSuperSponge")) {
            RecipeAdder.addRecipe24(plugin);
        }
        if (config.getBoolean("AllowCrafLavaSponge")) {
            RecipeAdder.addRecipe25(plugin);
        }
        if (config.getBoolean("AllowCraftLavaSponge")) {
            RecipeAdder.addRecipe25(plugin);
        }
        if (config.getBoolean("AllowCraftEnderpealer")) {
            RecipeAdder.addRecipe26(plugin);
        }
        if (config.getBoolean("AllowCraftTNTDetonator")) {
            RecipeAdder.addRecipe27(plugin);
        }
        if (config.getBoolean("AllowCraftCursedSword")) {
            RecipeAdder.addRecipe28(plugin);
        }
        if (config.getBoolean("AllowCraftPrivatePocketDimension")) {
            RecipeAdder.addRecipe29(plugin);
        }
        if (config.getBoolean("AllowCraftAntiExplosionHelmet")) {
            RecipeAdder.addRecipe30(plugin);
        }
//AllowCraftandActivatedWandofHome
        if (config.getBoolean("AllowCraftandActivatedWandofHome")) {
            RecipeAdder.addRecipe31(plugin);
            m.getServer().getPluginManager().registerEvents(new WandOfHome(), m);
        }
//AllowCraftTNTBow        
        if (config.getBoolean("AllowCraftTNTBow")) {
            RecipeAdder.addRecipe32(plugin);
        }
        //AllowCraftWandofBlocks
        if (config.getBoolean("AllowCraftWandofBlocks")) {
            RecipeAdder.addRecipe33(plugin);
        }
        //EnablePortal2Go
        if (config.getBoolean("EnablePortal2Go")) {
            RecipeAdder.addRecipe34(plugin);
            m.getServer().getPluginManager().registerEvents(new portal2go(), m);
        }

        //config.addDefault("EnableCraftSkullImitator", (Object)true);
        if (config.getBoolean("EnableSkullImitator")) {
            RecipeAdder.addRecipe35(plugin);
            m.getServer().getPluginManager().registerEvents(new SkullImitator(), m);
        }
        //PrivatePocketDimensionPerformanceModeActivated
        if (config.getBoolean("PrivatePocketDimensionPerformanceModeActivated")) {
            Main.priDimPerformMode =true;
        }
        //EnableLandmine
        if (config.getBoolean("EnableSkullImitator")) {
            RecipeAdder.addRecipe36(plugin);
            RecipeAdder.addRecipe37(plugin);
            m.getServer().getPluginManager().registerEvents(new landmine(), m);
        }
        //AllowCraftInfWaterBucket
        if (config.getBoolean("AllowCraftInfWaterBucket")) {
            RecipeAdder.addRecipe38(plugin);
        }
        //EnableLandminePerformanceMode
        if (config.getBoolean("EnableLandminePerformanceMode")) {
            Main.landminePerfModeEnabeled =true;
        }

        //AllowCraftProtectiveElytra
        if (config.getBoolean("AllowCraftInfWaterBucket")) {
            RecipeAdder.addRecipe39(plugin);
        }


        if (config.getBoolean("EnableItemsForNewerVersions") && GlobalVars.newerFeaturesEnabled) {
            if (config.getBoolean("EnableWandOfWarden")) {
                RecipeAdder.addRecipe41(plugin);
            }


        }



        Main.ore_gen_chance_private_dim = config.getInt("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock");
        Main.isprivatedimenableled = config.getBoolean("PrivatePocketDimensionEnabled");
        Main.config_anti_explo_helmet_lvl = config.getInt("AntiExplosionHelmetAntiExploEnchLevel");
        Main.tntbowamount = config.getInt("TNTBowTNTAmount");
        
    }

}
