package cel20.op.config;

import org.bukkit.configuration.file.FileConfiguration;

import java.security.SecureRandom;
import java.util.Base64;

import static utis.celutis.randomrange;

public class ConfigInniter {

    public static void innitConfig(FileConfiguration config){

        byte[] randomBytes;

        try {
            randomBytes = new byte[99];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(randomBytes);

        }catch (Exception e){
            randomBytes = new byte[99];
        }

        String newUUID = Base64.getEncoder().encodeToString(randomBytes);


        config.options().header("This is the main configuration file for OPItems\nSome options may impact gameplay and could lead to lag and server crashes, so use\nwith caution and make sure you know what each option does before configuring.\n\n\n You can reset the config by deleting the config.yml file and restarting your server.\n\n");


        config.addDefault("PrivatePocketDimensionPerformanceModeActivated", Boolean.FALSE);
        config.addDefault("EnableItemsForNewerVersions", Boolean.TRUE);

        config.addDefault("DisableOPItemsCrafting", Boolean.FALSE);
        config.addDefault("AllowCraftKnockyTheStick", Boolean.TRUE);
        config.addDefault("AllowCraftTheAntiDamage", Boolean.TRUE);
        config.addDefault("AllowCraftBlockySword", Boolean.TRUE);
        config.addDefault("AllowCraftPickyPick", Boolean.TRUE);
        config.addDefault("AllowCraftPiercer", Boolean.TRUE);
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
        config.addDefault("AllowCraftTNTDetonator", Boolean.TRUE);
        config.addDefault("AllowCraftCursedSword", Boolean.TRUE);
        config.addDefault("AllowCraftInfWaterBucket", Boolean.TRUE);
        config.addDefault("AllowCraftProtectiveElytra", Boolean.TRUE);
        config.addDefault("AllowCraftPrivatePocketDimension", Boolean.TRUE);
        config.addDefault("AllowCraftAntiExplosionHelmet", Boolean.TRUE);
        config.addDefault("AllowCraftAndActivatedWandOfHome", Boolean.TRUE);
        config.addDefault("AllowCraftTNTBow", Boolean.TRUE);

        config.addDefault("AllowCraftOtherItems", Boolean.TRUE);



        config.addDefault("CursedSwordEnabled", Boolean.TRUE);
        config.addDefault("EnableCraftWandOfWarden", Boolean.TRUE);
        config.addDefault("EnablePiercer", Boolean.TRUE);
        config.addDefault("EnableJumpyBoots", Boolean.TRUE);
        config.addDefault("PrivatePocketDimensionEnabled", Boolean.TRUE);
        config.addDefault("EnablePortal2Go", Boolean.TRUE);
        config.addDefault("EnableSkullImitator", Boolean.TRUE);
        config.addDefault("EnableLandmine", Boolean.TRUE);
        config.addDefault("EnableLandminePerformanceMode", Boolean.FALSE);
        config.addDefault("EnableRiptider", Boolean.TRUE);
        config.addDefault("ActivateWandofBlocks", Boolean.TRUE);


        config.addDefault("AllowBoomer", Boolean.TRUE);
        config.addDefault("AllowEndsword", Boolean.TRUE);
        config.addDefault("AllowBlitzer", Boolean.TRUE);
        config.addDefault("AllowCrafter", Boolean.TRUE);
        config.addDefault("AllowBlazer", Boolean.TRUE);
        config.addDefault("AllowBower", Boolean.TRUE);
        config.addDefault("AllowPigCannon", Boolean.TRUE);
        config.addDefault("AllowFlyFeather", Boolean.TRUE);
        config.addDefault("AllowAntiFall", Boolean.TRUE);
        config.addDefault("AllowHookOfVelectory", Boolean.TRUE);
        config.addDefault("AllowCraftWandofBlocks", Boolean.TRUE);

        config.addDefault("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock", Integer.valueOf(50));
        config.addDefault("AntiExplosionHelmetAntiExploEnchLevel", Integer.valueOf(75));
        config.addDefault("TNTBowTNTAmount", 50);
        config.addDefault("HookOfVelectoryCDms", 999L);
        config.addDefault("BowerCDms", 176);
        config.addDefault("BlitzerCDms", 666L);
        config.addDefault("PigCannonCDms", 333L);
        config.addDefault("TeleportSwordCDms", 100L);
        config.addDefault("enderPearlSwordCDms", 1000L);
        config.addDefault("PiercerDamageLevel", 3);
        config.addDefault("PiercerKnockbackLevel", 3);
        config.addDefault("wand_of_(massive)_boom_cooldown_MilliSeconds", 1000);
        config.addDefault("launcher_cooldown_MilliSeconds", 4000);
        config.addDefault("Wand_of_Boom_Explosion_Strength", 10);
        config.addDefault("Wand_of_Massive_Boom_Explosion_Strength", 20);
        config.addDefault("CraftedKnockyTheStickKnockbackEnchantmentLevel", 10);
        config.addDefault("CraftedBlockySwordDamageAllEnchantmentLevel", 17);
        config.addDefault("CraftedTheAntiDamageProtectionEnchantmentLevel", 75);
        config.addDefault("CraftedPickyPickDigSpeedEnchantmentLevel", 1200);
        config.addDefault("CraftedPickyPickLootBonusBlocksEnchantmentLevel", 5);


        config.addDefault("UUID-DoNotChange", newUUID);


        //AUTOITEMSREMOVE
        config.addDefault("EnableAutomaticPeriodicItemsRemove", Boolean.FALSE);
        config.addDefault("AutomaticPeriodicItemsRemoveWarningDurationSecs", Integer.valueOf(60));
        config.addDefault("AutomaticPeriodicItemsRemovePeriodeInMinutes", Integer.valueOf(30));

        //LOGGER
        config.addDefault("CLoggerMode", Integer.valueOf(0));
        config.addDefault("CLoggerFlushIntervallSec", Integer.valueOf(300));

    }

}
