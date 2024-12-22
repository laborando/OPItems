package cel20.op.config;

import org.bukkit.configuration.file.FileConfiguration;

import static utis.celutis.randomrange;

public class ConfigInniter {

    public static void innitConfig(FileConfiguration config){

        int test = randomrange(0, 1500241);
        int test2 = randomrange(0, 1500240);
        int test3 = randomrange(0, 1500240);
        int test4 = randomrange(0, 1500240);
        int test5 = randomrange(0, 1500240);
        int test6 = randomrange(0, 1500240);
        int test7 = randomrange(0, 1500240);
        int test8 = randomrange(0, 1500240);
        int test9 = randomrange(0, 1500240);
        int test10 = randomrange(0, 1500240);
        int test11 = randomrange(0, 1500240);
        final String rndnum = new StringBuilder().append(test).append(test2).append(test3).append(test4).append(test5).append(test6).append(test7).append(test8).append(test9).append(test10).append(test11).toString();
        test = randomrange(0, 1500240);
        test2 = randomrange(0, 1500240);
        test3 = randomrange(0, 1500240);
        test4 = randomrange(0, 1500240);
        test5 = randomrange(0, 1500240);
        test6 = randomrange(0, 1500240);
        test7 = randomrange(0, 1500240);
        test8 = randomrange(0, 1500240);
        test9 = randomrange(0, 1500240);
        test10 = randomrange(0, 1500240);
        test11 = randomrange(0, 1500240);
        final String rndnum2 = String.valueOf(test) + test2 + test3 + test4 + test5 + test6 + test7 + test8 + test9 + test10 + test11;
        test = randomrange(0, 1500240);
        test2 = randomrange(0, 1500240);
        test3 = randomrange(0, 1500240);
        test4 = randomrange(0, 1500240);
        test5 = randomrange(0, 1500240);
        test6 = randomrange(0, 1500240);
        test7 = randomrange(0, 1500240);
        test8 = randomrange(0, 1500240);
        test9 = randomrange(0, 1500240);
        test10 = randomrange(0, 1500240);
        test11 = randomrange(0, 1500240);
        final String rndnum3 = String.valueOf(test) + test2 + test3 + test4 + test5 + test6 + test7 + test8 + test9 + test10 + test11;
        final String rndnumfinal = rndnum3 + rndnum2 + rndnum;

        config.options().header("This is the main configuration file for OPItems\nSome options may impact gameplay and could lead to lag and server crashes, so use\nwith caution and make sure you know what each option does before configuring.\n\n\n You can reset the config by deleting the config.yml file and restarting your server.\n\n");
        config.addDefault("wand_of_(massive)_boom_cooldown_MilliSeconds", 1000);
        config.addDefault("launcher_cooldown_MilliSeconds", 4000);
        config.addDefault("Wand_of_Boom_Explosion_Strength", 10);
        config.addDefault("Wand_of_Massive_Boom_Explosion_Strength", 20);
        config.addDefault("CraftedKnockyTheStickKnockbackEnchantmentLevel", 10);
        config.addDefault("CraftedBlockySwordDamageAllEnchantmentLevel", 17);
        config.addDefault("CraftedTheAntiDamageProtectionEnchantmentLevel", 75);
        config.addDefault("CraftedPickyPickDigSpeedEnchantmentLevel", 1200);
        config.addDefault("CraftedPickyPickLootBonusBlocksEnchantmentLevel", 5);
        config.addDefault("AllowBoomer", Boolean.TRUE);
        config.addDefault("AllowEndsword", Boolean.TRUE);
        config.addDefault("AllowBlitzer", Boolean.TRUE);
        config.addDefault("AllowCrafter", Boolean.TRUE);
        config.addDefault("AllowBlazer", Boolean.TRUE);
        config.addDefault("AllowBower", Boolean.TRUE);
        config.addDefault("AllowPigCannon", Boolean.TRUE);
        config.addDefault("AllowFlyFeather", Boolean.TRUE);
        config.addDefault("AllowAntiFall", Boolean.TRUE);
        config.addDefault("AllowCraftOtherItems", Boolean.TRUE);
        config.addDefault("AllowHookOfVelectory", Boolean.TRUE);
        config.addDefault("AllowCraftNightVisor", Boolean.TRUE);
        config.addDefault("AllowCraftWaterHelmet", Boolean.TRUE);
        config.addDefault("AllowCraftLauncher", Boolean.TRUE);
        config.addDefault("AllowCraftFireShoes", Boolean.TRUE);
        config.addDefault("AllowCraftWandOfBoom", Boolean.TRUE);
        config.addDefault("AllowCraftWandOfMassiveBoom", Boolean.TRUE);
        config.addDefault("AllowCraftWandOfInvisibility", Boolean.TRUE);
        config.addDefault("AllowCraftSpeedLeggings", Boolean.TRUE);
        config.addDefault("AllowCraftSuperSponge", Boolean.TRUE);
        config.addDefault("AllowCraftLavaSponge", Boolean.TRUE);
        config.addDefault("AllowCraftEnderpealer", Boolean.TRUE);
        config.addDefault("UUIDinternal", rndnumfinal);
        config.addDefault("AllowCraftTNTDetonator", Boolean.TRUE);
        config.addDefault("AllowCraftCursedSword", Boolean.TRUE);
        config.addDefault("CursedSwordEnabled", Boolean.TRUE);
        config.addDefault("PrivatePocketDimensionEnabled", Boolean.TRUE);
        config.addDefault("AllowCraftPrivatePocketDimension", Boolean.TRUE);
        config.addDefault("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock", Integer.valueOf(50));
        config.addDefault("AllowCraftAntiExplosionHelmet", Boolean.TRUE);
        config.addDefault("AntiExplosionHelmetAntiExploEnchLevel", Integer.valueOf(75));
        config.addDefault("AllowCraftAndActivatedWandOfHome", Boolean.TRUE);
        config.addDefault("AllowCraftTNTBow", Boolean.TRUE);
        config.addDefault("TNTBowTNTAmount", 50);
        config.addDefault("ActivateWandofBlocks", Boolean.TRUE);
        config.addDefault("AllowCraftWandofBlocks", Boolean.TRUE);
        config.addDefault("EnablePortal2Go", Boolean.TRUE);
        config.addDefault("EnableSkullImitator", Boolean.TRUE);
        config.addDefault("EnableLandmine", Boolean.TRUE);
        config.addDefault("EnableLandminePerformanceMode", Boolean.FALSE);
        config.addDefault("AllowCraftInfWaterBucket", Boolean.TRUE);
        config.addDefault("AllowCraftProtectiveElytra", Boolean.TRUE);
        config.addDefault("EnableRiptider", Boolean.TRUE);
        config.addDefault("EnableItemsForNewerVersions", Boolean.TRUE);
        config.addDefault("EnableCraftWandOfWarden", Boolean.TRUE);
        config.addDefault("EnableJumpyBoots", Boolean.TRUE);



        //PRIVATE POCKET DIMESION
        //PrivatePocketDimensionPerformanceModeActivated
        config.addDefault("PrivatePocketDimensionPerformanceModeActivated", Boolean.FALSE);

        //AUTOITEMSREMOVE
        config.addDefault("EnableAutomaticPeriodicItemsRemove", Boolean.FALSE);
        config.addDefault("AutomaticPeriodicItemsRemoveWarningDurationSecs", Integer.valueOf(60));
        config.addDefault("AutomaticPeriodicItemsRemovePeriodeInMinutes", Integer.valueOf(30));

        //LOGGER
        config.addDefault("CLoggerMode", Integer.valueOf(0));
        config.addDefault("CLoggerFlushIntervallSec", Integer.valueOf(300));

    }

}
