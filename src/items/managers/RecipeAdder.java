
package items.managers;

import utis.CLogger;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import cel20.op.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import java.util.HashMap;
import java.util.List;

public class RecipeAdder
{
    static HashMap<Integer, NamespacedKey> map;
    
    static {
        RecipeAdder.map = new HashMap<Integer, NamespacedKey>();
    }
    
    public static void removeRecipe() {
        try {
            for (final NamespacedKey p : RecipeAdder.map.values()) {
                Bukkit.removeRecipe(p);
            }
        }
        catch (Exception ex) {}
    }
    
    public static void addRecipe1(final Main pluginint, final int level) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_1");
        RecipeAdder.map.put(1, key);
        final ItemStack itemStack = new ItemStack(Material.STICK, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Knocky the Stick");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, level, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a!a", "a@a", "a@a" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('!', Material.SLIME_BLOCK);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe2(final Main pluginint, final int level) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_2");
        RecipeAdder.map.put(2, key);
        final ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "The Blocky Sword");
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, level, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a!a", "!!!", "a@a" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe3(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_3");
        RecipeAdder.map.put(3, key);
        final ItemStack itemStack = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "The Anti Damage");
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 75, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "!a!", "!!!", "!!!" });
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe4(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_4");
        RecipeAdder.map.put(4, key);
        final ItemStack itemStack = new ItemStack(Material.ARROW, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Bower");
        itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a!a", "b!b", "@!@" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.BOW);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe5(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_5");
        RecipeAdder.map.put(5, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Blazer");
        itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a!a", "aba", "a@a" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe6(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_6");
        RecipeAdder.map.put(6, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_POWDER, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Boomer");
        itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { " ! ", " b ", " @ " });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.TNT);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe7(final Main pluginint, final int speed, final int loot) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_7");
        RecipeAdder.map.put(7, key);
        final ItemStack itemStack = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "PickyPick");
        itemMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 1200, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "!!!", "a@a", "a@a" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe8(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_8");
        RecipeAdder.map.put(8, key);
        final ItemStack itemStack = new ItemStack(Material.COOKED_PORKCHOP, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Pig Cannon");
        itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "b@b", "@!@", "a@a" });
        shapedRecipe.setIngredient('@', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('!', Material.PIG_SPAWN_EGG);
        shapedRecipe.setIngredient('b', Material.BOW);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe9(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_9");
        RecipeAdder.map.put(9, key);
        final ItemStack itemStack = new ItemStack(Material.PIG_SPAWN_EGG, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Pig spawn Egg");
        itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a@a", "@!@", "a@a" });
        shapedRecipe.setIngredient('@', Material.PORKCHOP);
        shapedRecipe.setIngredient('!', Material.NETHER_STAR);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe10(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_10");
        RecipeAdder.map.put(10, key);
        final ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Endsword");
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "b@b", "@!@", "a@a" });
        shapedRecipe.setIngredient('@', Material.ENDER_PEARL);
        shapedRecipe.setIngredient('!', Material.NETHERITE_SWORD);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe11(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_11");
        RecipeAdder.map.put(11, key);
        final ItemStack itemStack = new ItemStack(Material.PRISMARINE_SHARD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Blitzer");
        itemMeta.addEnchant(Enchantment.OXYGEN, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "b@b", "@!@", "aca" });
        shapedRecipe.setIngredient('@', Material.PRISMARINE_SHARD);
        shapedRecipe.setIngredient('!', Material.NETHERITE_SWORD);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('c', Material.NETHERITE_BLOCK);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe12(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_12");
        RecipeAdder.map.put(12, key);
        final ItemStack itemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Crafter");
        itemMeta.addEnchant(Enchantment.PIERCING, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a@a", "@!@", "a@a" });
        shapedRecipe.setIngredient('@', Material.DIAMOND);
        shapedRecipe.setIngredient('!', Material.CRAFTING_TABLE);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe13(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_13");
        RecipeAdder.map.put(13, key);
        final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "FlyFeather");
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a@a", "a!a", "aaa" });
        shapedRecipe.setIngredient('@', Material.DRAGON_BREATH);
        shapedRecipe.setIngredient('a', Material.NETHERITE_BLOCK);
        shapedRecipe.setIngredient('!', Material.FEATHER);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe14(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_14");
        RecipeAdder.map.put(14, key);
        final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - As long as this is in your inventory, you will be immune to fall-damage");
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aba", "!@!", "aaa" });
        shapedRecipe.setIngredient('@', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('b', Material.NETHERITE_BLOCK);
       
        shapedRecipe.setIngredient('!', Material.FEATHER);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe15(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_15");
        RecipeAdder.map.put(15, key);
        final ItemStack itemStack = new ItemStack(Material.FISHING_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Hook of Velectory");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aa@", "a@b", "@ab" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe16(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_16");
        RecipeAdder.map.put(16, key);
        final ItemStack itemStack = new ItemStack(Material.IRON_HELMET, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Night Visor");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "b@b", "aca" });
        shapedRecipe.setIngredient('@', Material.DIAMOND_HELMET);
        shapedRecipe.setIngredient('b', Material.IRON_INGOT);
       
        shapedRecipe.setIngredient('c', Material.LANTERN);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe17(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_17");
        RecipeAdder.map.put(17, key);
        final ItemStack itemStack = new ItemStack(Material.IRON_HELMET, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Water Helmet");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "b@b", "aca" });
        shapedRecipe.setIngredient('@', Material.DIAMOND_HELMET);
        shapedRecipe.setIngredient('b', Material.IRON_INGOT);
       
        shapedRecipe.setIngredient('c', Material.TURTLE_HELMET);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe18(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_18");
        RecipeAdder.map.put(18, key);
        final ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Fire Shoes");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aaa", "b@b", "bcb" });
        shapedRecipe.setIngredient('@', Material.LEATHER_BOOTS);
        shapedRecipe.setIngredient('b', Material.IRON_INGOT);
       
        shapedRecipe.setIngredient('c', Material.LAVA_BUCKET);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe19(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_19");
        RecipeAdder.map.put(19, key);
        final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Laucher");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.SOUL_SPEED, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aba", "b@b", "aba" });
        shapedRecipe.setIngredient('@', Material.FEATHER);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
       
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe20(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_20");
        RecipeAdder.map.put(20, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Wand of Boom");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.CHANNELING, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "@a@", "tbt", "@t@" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('a', Material.TNT);
        shapedRecipe.setIngredient('t', Material.BLAZE_ROD);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe21(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_21");
        RecipeAdder.map.put(21, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Wand of Massive Boom");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.LUCK, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "@a@", "tbt", "@t@" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_BLOCK);
        shapedRecipe.setIngredient('a', Material.TNT);
        shapedRecipe.setIngredient('t', Material.BLAZE_ROD);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe22(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_22");
        RecipeAdder.map.put(22, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Wand of Invisibility");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "btb", "bab" });
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('a', Material.PHANTOM_MEMBRANE);
        shapedRecipe.setIngredient('t', Material.DRAGON_BREATH);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe23(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_23");
        RecipeAdder.map.put(23, key);
        final ItemStack itemStack = new ItemStack(Material.IRON_LEGGINGS, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Speed Leggings");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bab", "beb", "btb" });
        shapedRecipe.setIngredient('a', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('t', Material.DIAMOND);
        shapedRecipe.setIngredient('e', Material.IRON_LEGGINGS);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe24(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_24");
        RecipeAdder.map.put(24, key);
        final ItemStack itemStack = new ItemStack(Material.SPONGE, 4);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Super Sponge");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bab", "aba", "bab" });
        shapedRecipe.setIngredient('a', Material.SPONGE);
        shapedRecipe.setIngredient('b', Material.GOLD_INGOT);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe25(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_25");
        RecipeAdder.map.put(25, key);
        final ItemStack itemStack = new ItemStack(Material.SPONGE, 4);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Lava Sponge");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bab", "aca", "bab" });
        shapedRecipe.setIngredient('a', Material.SPONGE);
        shapedRecipe.setIngredient('b', Material.GOLD_INGOT);
        shapedRecipe.setIngredient('c', Material.MAGMA_BLOCK);
        try {
            try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
        }
        catch (IllegalStateException ex) {}
    }
    
    public static void addRecipe26(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_26");
        RecipeAdder.map.put(26, key);
        final ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Enderpearler");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addEnchant(Enchantment.MENDING, 10, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "dcd", "cac", "cbc" });
        shapedRecipe.setIngredient('a', Material.NETHERITE_SWORD);
        shapedRecipe.setIngredient('b', Material.ENDER_EYE);
        shapedRecipe.setIngredient('c', Material.ENDER_PEARL);
        shapedRecipe.setIngredient('d', Material.NETHERITE_INGOT);
        try {
            try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
        }
        catch (IllegalStateException ex) {}
    }
    
    public static void addRecipe27(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_27");
        RecipeAdder.map.put(27, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Tnt Detonator");
        itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Right-click on a TNT-Block to add to the list");
        lore.add(ChatColor.RED + " - Right-click + Sneak to activate all listed TNT-Blocks");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "a!a", "aba", "a@a" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('!', Material.BLAZE_POWDER);
        
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe28(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_28");
        RecipeAdder.map.put(28, key);
        final ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Cursed Sword");
        itemMeta.addEnchant(Enchantment.OXYGEN, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        itemMeta.addEnchant(Enchantment.DURABILITY, 255, true);
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Right-click to teleport towards the direktion you're looking");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "b!b", "bxb", "a@a" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('!', Material.BLAZE_POWDER);
       
        shapedRecipe.setIngredient('x', Material.GLOWSTONE);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe29(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_29");
        RecipeAdder.map.put(29, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Private Pocket Dimension Wand");
        itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FALL, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Right-click to change between the Overworld and your Private Dimension");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "cxc", "a@a" });
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_BLOCK);
       
        shapedRecipe.setIngredient('c', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('x', Material.NETHER_STAR);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe30(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_30");
        RecipeAdder.map.put(30, key);
        final ItemStack itemStack = new ItemStack(Material.NETHERITE_HELMET, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Anti Explosion Helmet");
        itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bcb", "bab", "aaa" });
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
       
        shapedRecipe.setIngredient('c', Material.DIAMOND);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe31(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_31");
        RecipeAdder.map.put(31, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Wand of Home");
        itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 75, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Right-click in the air to teleport to your home");
        lore.add(ChatColor.RED + " - Right-click + Sneak to set your home");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "ada", "aca" });
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
       
        shapedRecipe.setIngredient('c', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('d', Material.BELL);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe32(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_32");
        RecipeAdder.map.put(32, key);
        final ItemStack itemStack = new ItemStack(Material.BOW, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "TNT Bow");
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
        itemMeta.addEnchant(Enchantment.LUCK, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });

        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "ada", "ccc" });
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
       
        shapedRecipe.setIngredient('c', Material.TNT);
        shapedRecipe.setIngredient('d', Material.BOW);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    
    public static void addRecipe33(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_33");
        RecipeAdder.map.put(33, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "Wand of Blocks");
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
        itemMeta.addEnchant(Enchantment.THORNS, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Right-click to charge");
        lore.add(ChatColor.RED + " - Right-click + Sneak to release the Blocks");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "ebe", "ada", "aca" });
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
       
        shapedRecipe.setIngredient('c', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('d', Material.SLIME_BLOCK);

        shapedRecipe.setIngredient('e', Material.NETHERITE_BLOCK);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    public static void addRecipe34(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_34");
        RecipeAdder.map.put(34, key);
        final ItemStack itemStack = new ItemStack(Material.STICK, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Portal2Go");
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
        itemMeta.addEnchant(Enchantment.THORNS, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Right-click in the Air to travel between the Overworld and the Nether");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aaa", "aba", "aaa" });
        shapedRecipe.setIngredient('b', Material.FLINT_AND_STEEL);
        shapedRecipe.setIngredient('a', Material.OBSIDIAN);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    public static void addRecipe35(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_35");
        RecipeAdder.map.put(35, key);
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Skull Imitator");
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
        itemMeta.addEnchant(Enchantment.THORNS, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Right-click in the Air to change the texture");
        lore.add(ChatColor.RED + " - Place + Sneak to place and lock this heads texture");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aaa", "aba", "aaa" });
        shapedRecipe.setIngredient('b', Material.APPLE);
        shapedRecipe.setIngredient('a', Material.BAMBOO);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    public static void addRecipe36(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_36");
        RecipeAdder.map.put(36, key);
        final ItemStack itemStack = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 4);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Landmine");
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
        itemMeta.addEnchant(Enchantment.THORNS, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Place on the ground to set up");
        lore.add(ChatColor.RED + " - Explodes when destroyed or stepped on");
        lore.add(ChatColor.RED + " - Players have to diffuse it to safely destroy it");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aba", "bab", "aba" });
        shapedRecipe.setIngredient('b', Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        shapedRecipe.setIngredient('a', Material.TNT);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    public static void addRecipe37(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_37");
        RecipeAdder.map.put(37, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Defuser");
        itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Click on a landmine to diffuse");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "aba", "xcx", "xcx" });
        shapedRecipe.setIngredient('b', Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        shapedRecipe.setIngredient('a', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('c', Material.BLAZE_ROD);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }
    public static void addRecipe38(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_38");
        RecipeAdder.map.put(38, key);
        final ItemStack itemStack = new ItemStack(Material.WATER_BUCKET, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Infinitive Water Bucket");
        itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "xcx", "xax", "bbb" });
        shapedRecipe.setIngredient('b', Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        shapedRecipe.setIngredient('a', Material.WATER_BUCKET);
        shapedRecipe.setIngredient('c', Material.DIAMOND);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe39(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_39");
        RecipeAdder.map.put(39, key);
        final ItemStack itemStack = new ItemStack(Material.ELYTRA, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Protective Elytra");

        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
        itemMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, true);

        itemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        itemMeta.addEnchant(Enchantment.MENDING, 3, true);

        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "ccc", "xax", "bdb" });
        shapedRecipe.setIngredient('a', Material.ELYTRA);
        shapedRecipe.setIngredient('b', Material.DIAMOND);
        shapedRecipe.setIngredient('c', Material.DIAMOND);
        shapedRecipe.setIngredient('d', Material.NETHERITE_CHESTPLATE);



        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe40(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_40");
        RecipeAdder.map.put(40, key);
        final ItemStack itemStack = new ItemStack(Material.TRIDENT, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Riptider");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Currently not finished!");
        lore.add(ChatColor.RED + " - This Trident can always use its riptide enchantment!");
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "ccc", "xax", "bdb" });
        shapedRecipe.setIngredient('a', Material.HEART_OF_THE_SEA);
        shapedRecipe.setIngredient('x', Material.DIAMOND);
        shapedRecipe.setIngredient('b', Material.FEATHER);
        shapedRecipe.setIngredient('c', Material.QUARTZ);
        shapedRecipe.setIngredient('d', Material.TRIDENT);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }


    public static void addRecipe41(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_41");
        RecipeAdder.map.put(41, key);
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Wand of Warden");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
        itemMeta.addEnchant(Enchantment.QUICK_CHARGE, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Click anywhere on the ground to spawn a warden!");
        lore.add(ChatColor.RED + " - Effect: -5 Hearts; Spawns Warden on the clicked position");
        lore.add(ChatColor.RED + " - Cooldown: 90s");
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "cxc", "xax", "bdb" });
        shapedRecipe.setIngredient('a', Material.NETHER_STAR);
        shapedRecipe.setIngredient('x', Material.OBSIDIAN);
        shapedRecipe.setIngredient('b', Material.IRON_BARS);
        shapedRecipe.setIngredient('c', Material.OBSERVER);
        shapedRecipe.setIngredient('d', Material.END_ROD);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe42(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_42");
        RecipeAdder.map.put(42, key);
        final ItemStack itemStack = new ItemStack(Material.DIAMOND_BOOTS, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Jumpy Boots");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.RED + " - Currently not finished!");
        lore.add(ChatColor.RED + " - Enables one to triple jump");
        lore.add(ChatColor.RED + " - Can be upgraded to netherite and enchanted!");
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "xbx", "xcx", "xax" });
        shapedRecipe.setIngredient('x', Material.DIAMOND);
        shapedRecipe.setIngredient('b', Material.DIAMOND_BLOCK);
        shapedRecipe.setIngredient('c', Material.FEATHER);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

}
