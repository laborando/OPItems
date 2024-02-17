
package cel20.op;

import java.util.logging.Logger;
import java.io.File;

import items.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Block;
import o_guis.Gui_handler;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;

import events.hookofvelectory;
import events.super_sponge_start_logic;
import events.leggingevent;
import events.bootevent;
import events.armorevent;
import events.nofall;
import events.flystick;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.HashMap;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.plugin.java.JavaPlugin;

import cmd.CmdExe;
import cmd.TabComp;

public class Main extends JavaPlugin implements Listener
{

    private static Main instance;
    public File getFileNonProt() {
        return super.getFile();
    }
	
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
    public static boolean landminePerfModeEnabeled=false;
    public HashMap<String, Long> cooldown_wand_boom;
    public HashMap<String, Long> Launcher_Cooldown;
    private static final String HEADER = "This is the main configuration file for OPItems\nSome options may impact gameplay and could lead to Lag and Server Crashes, so use\nwith caution and make sure you know what each option does before configuring.\n\n\n You can Reset the Settings by Deleting the Config.yml File and Restarting your Server.\n\n";
    private static final String ONE = "Warning: Setting some Values too high could make the Server lagging or crashing upon use of some Items";
    public static int ore_gen_chance_private_dim;
    public static int config_anti_explo_helmet_lvl;
    public static boolean isprivatedimenableled;
    public static int update;
    public FileConfiguration config;
    static Plugin p;
    public static Updater.ReleaseType update_type;
    private String data_save_cursed_sword;
    private String data_save_homes;
    private String data_save_play_dim;
    public static int tntbowamount;
    public static String opitems_version = "Not Innited";

    public static boolean priDimPerformMode=false;

    static {
        Main.ore_gen_chance_private_dim = 100;
        Main.config_anti_explo_helmet_lvl = 75;
        Main.isprivatedimenableled = true;
        Main.update = 0;
        Main.update_type = null;
        Main.tntbowamount = 50;
    }
    
    public Main() {
        this.cooldown_wand_boom = new HashMap<String, Long>();
        this.Launcher_Cooldown = new HashMap<String, Long>();
        this.config = this.getConfig();
        this.data_save_cursed_sword = null;
        this.data_save_homes = null;
        this.data_save_play_dim = null;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerLoginEvent e) {
        final FileConfiguration config = this.getConfig();
        final String UUIDSERVER = config.getString("UUIDinternal");
        final String Message = "A Player joined v1.9.4! Online Players: " + (Bukkit.getOnlinePlayers().size() + 1) + " Ver: " + Bukkit.getVersion() + ". "+ "  OPItems-Server-UUID: " + UUIDSERVER;
        celsdcwebhookintigration.sendMessage(Message);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerQuitEvent e) {
    	final String UUIDSERVER = config.getString("UUIDinternal");
        final String Message = "A Player left a Server (1.9.4)! Players now online: " + (Bukkit.getOnlinePlayers().size() - 1 + "  OPItems-Server-UUID: " + UUIDSERVER);
        celsdcwebhookintigration.sendMessage(Message);
    }
    
    public void onEnable() {
        Main.p = (Plugin)this;
        instance = this;

        Bukkit.getLogger().info("[OPItems] OPItems is loading...");

        landmine.load();
        cursed_sword.loadData(this.data_save_cursed_sword = this.getDataFolder() + "/op_cursed_sword_data");
        WandOfHome.loadData(this.data_save_homes = this.getDataFolder() + "/wand_of_home_data");
        DimensionWand.loadData(this.data_save_play_dim = this.getDataFolder() + "/farm_dim_play_data");
        
        //Bukkit.getLogger().info("Loaded List<Entity> for Cursed Sword | File: /plugins/OPItems/op_cursed_sword_data");
        
        int test = randomrange(0, 1500240);
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
        final Main plugin = this;
        
        Bukkit.getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new flystick(), this);
        this.getServer().getPluginManager().registerEvents(new nofall(), this);
        this.getServer().getPluginManager().registerEvents(new armorevent(), this);
        this.getServer().getPluginManager().registerEvents(new bootevent(), this);
        this.getServer().getPluginManager().registerEvents(new leggingevent(), this);
        this.getServer().getPluginManager().registerEvents(new super_sponge_start_logic(), this);
        this.getServer().getPluginManager().registerEvents(new tntlayer(), this);
        this.getServer().getPluginManager().registerEvents(new DimensionWand(), this);
        this.getServer().getPluginManager().registerEvents(new Gui_handler(), this);
        this.getServer().getPluginManager().registerEvents(new TntBow(), this);
        
        //Bukkit.getLogger().info("[OPItems]Registered Events");
        final FileConfiguration config = this.getConfig();
        config.options().header("This is the main configuration file for OPItems\nSome options may impact gameplay and could lead to Lag and Server Crashes, so use\nwith cautio and make sure you know what each option does before configuring.\n\n\n You can Reset the Settings by Deleting the Config.yml File and Restarting your Server.\n\n");
        config.addDefault("wand_of_(massive)_boom_cooldown_MiliSeconds", 1000);
        config.addDefault("launcher_cooldown_MiliSeconds", 4000);
        config.addDefault("Wand_of_Boom_Explosion_Strenght", 10);
        config.addDefault("Wand_of_Massive_Boom_Explosion_Strenght", 20);
        config.addDefault("CraftedKnockyTheStickKnockbackEnchantmentLevel", 10);
        config.addDefault("CraftedBlockySwordDamageAllEnchantmentLevel", 17);
        config.addDefault("CraftedTheAntiDamageProtectionEnchantmentLevel", 75);
        config.addDefault("CraftedPickyPickDigSpeedEnchantmentLevel", 1200);
        config.addDefault("CraftedPickyPickLootBonusBlocksEnchantmentLevel", 5);
        config.addDefault("AllowBommer", true);
        config.addDefault("AllowEndsword", true);
        config.addDefault("AllowBlitzer", true);
        config.addDefault("AllowCrafter", true);
        config.addDefault("AllowBlazer", true);
        config.addDefault("AllowBower", true);
        config.addDefault("AllowPigCannon", true);
        config.addDefault("AllowFlyFeather", true);
        config.addDefault("AllowAntiFall", true);
        config.addDefault("AllowCraftOtherItems", true);
        config.addDefault("AllowHookofVelectory", true);
        config.addDefault("AllowCraftNightVisor", true);
        config.addDefault("AllowCraftWaterHelmet", true);
        config.addDefault("AllowCraftLaucher", true);
        config.addDefault("AllowCraftFireShoes", true);
        config.addDefault("AllowCraftWandOfBoom", true);
        config.addDefault("AllowCraftWandOfMassiveBoom", true);
        config.addDefault("AllowCraftWandOfInvisiblity", true);
        config.addDefault("AllowCraftSpeedLeggings", true);
        config.addDefault("AllowCraftSuperSponge", true);
        config.addDefault("AllowCrafLavaSponge", true);
        config.addDefault("AllowCraftEnderpealer", true);
        config.addDefault("UUIDinternal", rndnumfinal);
        config.addDefault("AllowCraftTNTDetonator", true);
        config.addDefault("AllowCraftCursedSword", true);
        config.addDefault("CursedSwordEnabled", true);
        config.addDefault("PrivatePocketDimensionEnabled", true);
        config.addDefault("AllowCraftPrivatePocketDimension", true);
        config.addDefault("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock", 50);
        config.addDefault("AllowCraftAntiExplosionHelmet", true);
        config.addDefault("AntiExplosionHelmetAntiExploEnchLevel", 75);
        config.addDefault("AllowCraftandActivatedWandofHome", true);
        config.addDefault("AllowCraftTNTBow", true);
        config.addDefault("TNTBowTNTAmount", 50);
        config.addDefault("ActivateWandofBlocks", true);
        config.addDefault("AllowCraftWandofBlocks", true);
        config.addDefault("EnablePortal2Go", true);
        config.addDefault("EnableSkullImitator", true);
        config.addDefault("EnableLandmine", true);
        config.addDefault("EnableLandminePerformanceMode", false);

        //PRIVATE POCKET DIMESION
        //PrivatePocketDimensionPerformanceModeActivated
        config.addDefault("PrivatePocketDimensionPerformanceModeActivated", false);

        //AUTOITEMSREMOVE
        config.addDefault("EnableAutomaticPeriodicItemsRemove", false);
        config.addDefault("AutomaticPeriodicItemsRemoveWarningDurationSecs", 60);
        config.addDefault("AutomaticPeriodicItemsRemovePeriodeInMinutes", 30);



        //TNTBowTNTAmount
        config.options().copyDefaults(true);
        this.saveConfig();
        //Bukkit.getLogger().info("[OPItems]Loaded Config");




        if (config.getBoolean("EnableAutomaticPeriodicItemsRemove")) {
            manage.AutoItems.innitAutoRemove(config.getInt("AutomaticPeriodicItemsRemovePeriodeInMinutes"), config.getInt("AutomaticPeriodicItemsRemoveWarningDurationSecs"));
            Bukkit.getLogger().info("[OPItems] AutoItemRemove Started!");
        }

        //ActivateWandofBlocks
        if (config.getBoolean("ActivateWandofBlocks")) {
        	this.getServer().getPluginManager().registerEvents(new WandOfBlocks(), this);
        }
        
        
        if (config.getBoolean("CursedSwordEnabled")) {
            this.getServer().getPluginManager().registerEvents(new cursed_sword(), this);
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
            this.getServer().getPluginManager().registerEvents(new hookofvelectory(), this);
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
        if (config.getBoolean("AllowCraftWandOfBoom")) {
            RecipeAdder.addRecipe20(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfMassiveBoom")) {
            RecipeAdder.addRecipe21(plugin);
        }
        if (config.getBoolean("AllowCraftWandOfInvisiblity")) {
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
            this.getServer().getPluginManager().registerEvents(new WandOfHome(), this);
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
            this.getServer().getPluginManager().registerEvents(new portal2go(), this);
        }

        //config.addDefault("EnableCraftSkullImitator", (Object)true);
        if (config.getBoolean("EnableSkullImitator")) {
            RecipeAdder.addRecipe35(plugin);
            this.getServer().getPluginManager().registerEvents(new SkullImitator(), this);
        }
        //PrivatePocketDimensionPerformanceModeActivated
        if (config.getBoolean("PrivatePocketDimensionPerformanceModeActivated")) {
            priDimPerformMode=true;
        }
        //EnableLandmine
        if (config.getBoolean("EnableSkullImitator")) {
            RecipeAdder.addRecipe36(plugin);
            this.getServer().getPluginManager().registerEvents((Listener)new landmine(), (Plugin)this);
        }
        //EnableLandminePerformanceMode
        if (config.getBoolean("EnableLandminePerformanceMode")) {
            landminePerfModeEnabeled=true;
        }

        Main.ore_gen_chance_private_dim = config.getInt("PrivatePocketDimensionOreSpawnChancePerGeneratedStoneBlock");
        Main.isprivatedimenableled = config.getBoolean("PrivatePocketDimensionEnabled");
        Main.config_anti_explo_helmet_lvl = config.getInt("AntiExplosionHelmetAntiExploEnchLevel");
        Main.tntbowamount = config.getInt("TNTBowTNTAmount");


        try {
            Bukkit.getLogger().info("[OPItems]Looking for Updates");
            final Updater updater = new Updater((Plugin) this, 443495, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, true);
            Bukkit.getLogger().info("Name: " + updater.getLatestName());
            Bukkit.getLogger().info("Result: " + updater.getResult());
            Bukkit.getLogger().info("Update Type: " + updater.getLatestType());
            if (updater.getResult() == Updater.UpdateResult.UPDATE_AVAILABLE) {
                Main.update = 1;
            }
            if (updater.getResult() == Updater.UpdateResult.FAIL_BADID) {
                Bukkit.getLogger().severe("[OPItems] ERROR whilst looking for Updates, THIS PLUGIN WILL NOT AUTOUPDATE!");
                Bukkit.getLogger().severe("[OPItems] If this doesn't disappear after a few hours, autoupdate stopped working!");
            }

            if (Main.update == 1) {
                Bukkit.getLogger().warning(ANSI_RED + "IMPORTANT" + ANSI_RESET);
                if (updater.getLatestType() == Updater.ReleaseType.RELEASE) {
                    Bukkit.getLogger().info(ANSI_YELLOW + "A new Update for OPItems has been found. Please update with /opitems update" + ANSI_RESET);
                }
                if (updater.getLatestType() == Updater.ReleaseType.BETA) {
                    Bukkit.getLogger().info(ANSI_YELLOW + "A new Update for OPItems has been found. The update is in the BETA stage! If you want to update, do it with /opitems update" + ANSI_RESET);
                }
                if (updater.getLatestType() == Updater.ReleaseType.ALPHA) {
                    Bukkit.getLogger().info(ANSI_YELLOW + "A new Update for OPItems has been found. The update is in the ALPHA stage! If you want to update, do it with /opitems update" + ANSI_RESET);
                }
                Main.update_type = updater.getLatestType();
            }

        }catch (java.lang.IllegalStateException ignored){}

        this.getCommand("opitems").setExecutor(new CmdExe());
        this.getCommand("items").setExecutor(new CmdExe());
        this.getCommand("opitemsversion").setExecutor(new CmdExe());
        this.getCommand("opitemshelp").setExecutor(new CmdExe());
        
        this.getCommand("opitems").setTabCompleter(new TabComp());
        this.getCommand("items").setTabCompleter(new TabComp());
        
        cursed_sword.loadData(this.data_save_cursed_sword = this.getDataFolder() + "/op_cursed_sword_data");
        WandOfHome.loadData(this.data_save_homes = this.getDataFolder() + "/wand_of_home_data");
        DimensionWand.loadData(this.data_save_play_dim = this.getDataFolder() + "/farm_dim_play_data");
        
        Bukkit.getLogger().info("[OPItems]Successfully Enabled");
        Bukkit.getLogger().info("");

        Bukkit.getLogger().info("|-----------------------------|");
        Bukkit.getLogger().info("|     OPItems 1.9.5 (Skull)   |");
        Bukkit.getLogger().info("|             by              |");
        Bukkit.getLogger().info("|            cel20            |");
        Bukkit.getLogger().info("|-----------------------------|");
        Bukkit.getLogger().info("");
        opitems_version = "1.9.5";
        

    }
    
    public void onDisable() {
        Bukkit.getLogger().warning("[OPItems] Disabling... Saving Data...");
        cursed_sword.saveData(this.data_save_cursed_sword);
        //Bukkit.getLogger().info("Saved List<Entity> for Cursed Sword | File: /plugins/OPItems/op_cursed_sword_data");
        WandOfHome.saveData(this.data_save_homes);
        //Bukkit.getLogger().info("Saved HashMap<String, Location> for Wand of Home | File: /plugins/OPItems/wand_of_home_data");
        DimensionWand.saveData(this.data_save_play_dim);

        landmine.save();
        
        RecipeAdder.removeRecipe();
        //Bukkit.getLogger().warning("Recipes removed...");
        Bukkit.getLogger().warning("OPItems is now disabled");
    }
    
    
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      
      if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)
        return; 
      ItemStack item = p.getInventory().getItemInMainHand();
      if (item == null)
        return; 
      Material a = item.getType();
      if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
        if (a == Material.NETHERITE_SWORD && 
          item.getItemMeta().getDisplayName().contains(ChatColor.BOLD + "Enderpearler")) {
          EnderPearl ep = (EnderPearl)e.getPlayer().launchProjectile( EnderPearl.class);
          ep.setBounce(true);
          ep.eject();
        } 
        if (a == Material.FLINT && 
          item.containsEnchantment(Enchantment.ARROW_DAMAGE))
          if (e.getClickedBlock().getY() == p.getLocation().getY()) {
            p.sendMessage("Ja");
            double bx = e.getClickedBlock().getX();
            double by = e.getClickedBlock().getY();
            double px = p.getLocation().getX();
            double py = p.getLocation().getY();
            double y = by - py;
            double x = bx - px;
            Location b = e.getClickedBlock().getLocation();
            if (x < 0.0D) {
              Location tp = null;
              tp.setX(b.getX() - 1.0D);
              tp.setY(b.getY());
              tp.setZ(b.getZ());
              p.teleport(tp);
            } 
          } else {
            p.sendMessage(ChatColor.DARK_RED + "The Block you are clicking, has to be on the same Height as you.");
          }  
      } 
      
        
      
      
      if (a == Material.FEATHER && 
        item.containsEnchantment(Enchantment.ARROW_DAMAGE))
        if (this.config.getBoolean("AllowFlyFeather")) {
          if (p.getGameMode() == GameMode.CREATIVE) {
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "This item is not made for Creative");
          } else if (p.getAllowFlight()) {
            p.setFlying(false);
            p.setAllowFlight(false);
          } else {
            p.setAllowFlight(true);
            p.sendMessage(ChatColor.GREEN + "You can fly now");
            p.sendMessage("You can only fly with the fly feather in the inventory");
            p.sendMessage("If you can't fly now, try again in 30 sek.");
          } 
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        }  
      if (a == Material.FEATHER && 
        item.containsEnchantment(Enchantment.SOUL_SPEED)) {
        double cooldownTime = this.config.getDouble("launcher_cooldown_MiliSeconds");
        if (this.Launcher_Cooldown.containsKey(p.getName())) {
          double secondsLeft = ((double) this.Launcher_Cooldown.get(p.getName()) / 1000L) + cooldownTime / 1000.0D - ((double) System.currentTimeMillis() / 1000L);
          if (secondsLeft > 0.0D) {
            p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "You cant use this Item for another " + secondsLeft + " seconds!");
            return;
          } 
        } 
        Player player = e.getPlayer();
        Location loctemp123412347860 = player.getLocation();
        org.bukkit.util.Vector vec = new org.bukkit.util.Vector(0.0D, loctemp123412347860.getY() + 50.0D, 0.0D);
        
        //0.0D, loctemp123412347860.getY() + 50.0D, 0.0D
        player.setVelocity(vec);
        this.Launcher_Cooldown.put(p.getName(), System.currentTimeMillis());
      } 
      if (a == Material.BLAZE_ROD && 
        item.containsEnchantment(Enchantment.FIRE_ASPECT))
        if (this.config.getBoolean("AllowBlazer")) {
          Fireball f = (Fireball)e.getPlayer().launchProjectile(Fireball.class);
          f.setIsIncendiary(true);
          f.setYield(10.0F);
          p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.0F, 1.0F);
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        }  
      if (a == Material.ARROW && 
        item.containsEnchantment(Enchantment.FROST_WALKER))
        if (this.config.getBoolean("AllowBower")) {
          Arrow f = e.getPlayer().launchProjectile(Arrow.class);
          f.setFireTicks(1000000);
          f.setVelocity(f.getVelocity().multiply(5));
          f.setShotFromCrossbow(true);
          f.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
          f.setPierceLevel(100);
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        }  
      if (a == Material.BLAZE_POWDER && 
        item.containsEnchantment(Enchantment.FROST_WALKER))
        if (this.config.getBoolean("AllowBommer")) {
          Fireball f = (Fireball)e.getPlayer().launchProjectile(Fireball.class);
          f.setYield(0.0F);
          f.setVelocity(f.getVelocity().multiply(3));
          f.addPassenger(p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT));
          p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.0F, 1.0F);
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        }  
      if (a == Material.PIG_SPAWN_EGG && 
        item.containsEnchantment(Enchantment.FIRE_ASPECT))
        e.setCancelled(true); 
      if (a == Material.COOKED_PORKCHOP && 
        item.containsEnchantment(Enchantment.FIRE_ASPECT)) {
        e.setCancelled(true);
        if (this.config.getBoolean("AllowPigCannon")) {
          Arrow f = (Arrow)e.getPlayer().launchProjectile(Arrow.class);
          f.setFireTicks(0);
          f.setVelocity(f.getVelocity().multiply(0.5D));
          f.setDamage(0.0D);
          f.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
          f.setPierceLevel(0);
          f.addPassenger(p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.PIG));
          p.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 1.0F);
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        } 
      } 
      if (a == Material.BLAZE_ROD && 
        item.containsEnchantment(Enchantment.CHANNELING)) {
        double cooldownTime = this.config.getDouble("wand_of_(massive)_boom_cooldown_MiliSeconds");
        if (this.cooldown_wand_boom.containsKey(p.getName())) {
          double secondsLeft = ((double) this.cooldown_wand_boom.get(p.getName()) / 1000L) + cooldownTime / 1000.0D - ((double) System.currentTimeMillis() / 1000L);
          if (secondsLeft > 0.0D) {
            p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "You cant use this Item for another " + secondsLeft + " seconds!");
            return;
          } 
        } 
        Block prel = p.getTargetBlockExact(150);
        if (prel != null) {
          Location loc2345 = prel.getLocation();
          p.getWorld().createExplosion(loc2345, this.config.getInt("Wand_of_Boom_Explosion_Strenght"));
          this.cooldown_wand_boom.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
        } 
      } 
      if (a == Material.BLAZE_ROD && 
        item.containsEnchantment(Enchantment.DIG_SPEED))
        if (p.isInvisible()) {
          p.setInvisible(false);
        } else {
          p.setInvisible(true);
        }  
      if (a == Material.BLAZE_ROD && 
        item.containsEnchantment(Enchantment.LUCK)) {
        double cooldownTime = this.config.getDouble("wand_of_(massive)_boom_cooldown_MiliSeconds");
        if (this.cooldown_wand_boom.containsKey(p.getName())) {
          double secondsLeft = ((double) this.cooldown_wand_boom.get(p.getName()).longValue() / 1000L) + cooldownTime / 1000.0D - (System.currentTimeMillis() / 1000L);
          if (secondsLeft > 0.0D) {
            p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "You cant use this Item for another " + secondsLeft + " seconds!");
            return;
          } 
        } 
        Block prel = p.getTargetBlockExact(150);
        if (prel != null) {
          Location loc2345 = prel.getLocation();
          p.getWorld().createExplosion(loc2345, this.config.getInt("Wand_of_Massive_Boom_Explosion_Strenght"));
          this.cooldown_wand_boom.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
        } 
      } 
      if (a == Material.NETHERITE_SWORD && 
        item.containsEnchantment(Enchantment.ARROW_DAMAGE))
        if (this.config.getBoolean("AllowEndsword")) {
          Location location = p.getLocation().clone();
          Location location2 = p.getLocation().clone();
          Location location3 = p.getLocation().clone();
          Location location4 = p.getLocation().clone();
          Location location5 = p.getLocation().clone();
          Location location6 = p.getLocation().clone();
          Location location7 = p.getLocation().clone();
          Location location1 = p.getLocation().clone();
          location.add(p.getEyeLocation().getDirection().multiply(8));
          location2.add(p.getEyeLocation().getDirection().multiply(2));
          location3.add(p.getEyeLocation().getDirection().multiply(3));
          location4.add(p.getEyeLocation().getDirection().multiply(4));
          location5.add(p.getEyeLocation().getDirection().multiply(5));
          location6.add(p.getEyeLocation().getDirection().multiply(6));
          location7.add(p.getEyeLocation().getDirection().multiply(7));
          location1.add(p.getEyeLocation().getDirection().multiply(1));
          Block block = location.getBlock();
          Block block2 = location.getBlock();
          Block block3 = location.getBlock();
          Block block4 = location.getBlock();
          Block block5 = location.getBlock();
          Block block6 = location.getBlock();
          Block block7 = location.getBlock();
          Block block1 = location.getBlock();
          if (block1.isPassable()) {
            if (block2.isPassable()) {
              if (block3.isPassable()) {
                if (block4.isPassable()) {
                  if (block5.isPassable()) {
                    if (block6.isPassable()) {
                      if (block7.isPassable()) {
                        if (block.isPassable()) {
                          p.teleport(location);
                          p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                        } else {
                          p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                        } 
                      } else {
                        p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                      } 
                    } else {
                      p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                    } 
                  } else {
                    p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                  } 
                } else {
                  p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                } 
              } else {
                p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
              } 
            } else {
              p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
            } 
          } else {
            p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
          } 
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        }  
      if (a == Material.PRISMARINE_SHARD && 
        item.containsEnchantment(Enchantment.OXYGEN))
        if (this.config.getBoolean("AllowBlitzer")) {
          Block prel = p.getTargetBlockExact(150);
          if (prel != null) {
            Location l = prel.getLocation();
            p.getWorld().strikeLightning(l);
            p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0F, 1.0F);
          } 
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        }  
      if (a == Material.CRAFTING_TABLE && 
        item.containsEnchantment(Enchantment.PIERCING)) {
        e.setCancelled(true);
        if (this.config.getBoolean("AllowCrafter")) {
          Player pl = e.getPlayer();
          Location l = pl.getLocation();
          pl.openWorkbench(null, true);
        } else {
          p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
        } 
      }
    }
    

    
    

    public static Plugin getPluginInstance() {
        return Main.p;
    }
    
    public Logger getLoggerClass() {
        return super.getLogger();
    }
    
    private static int randomrange(final int min, final int max) {
        return (int) celutis.celutis.randomRangeDouble(min, max);
    }
    public static void executeUpdate(CommandSender sender) {
    	
    	Updater updater;
    	updater = new Updater((Plugin)p, 443495, ((Main) p).getFileNonProt(), Updater.UpdateType.DEFAULT, true);
    	
    	if (updater.getResult() == Updater.UpdateResult.SUCCESS) {
            Main.update = 0;
            sender.sendMessage(ChatColor.GOLD + "OPItems has been Updated. Please restart your server to activate the Update.");
        }
        else if (updater.getResult() == Updater.UpdateResult.NO_UPDATE) {
            sender.sendMessage(ChatColor.GOLD + "OPItems is running the newest Version");
        }
        else {
            sender.sendMessage(String.valueOf(ChatColor.RED) + ChatColor.BOLD + "UPDATE FAILED:");
            sender.sendMessage(String.valueOf(ChatColor.RED) + ChatColor.BOLD + "OPItems Failed to Update. Error:");
            sender.sendMessage(updater.getResult().toString());
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public boolean isOnPrivatePocketPerformMode(){
        return priDimPerformMode;
    }
    
}
