
package items.managers;

import cel20.op.GlobalVars;
import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import utis.CLogger;

import java.util.HashMap;

import static items.managers.RawItemsGenerator.getItem;

public class RecipeAdder {
    static HashMap<Integer, NamespacedKey> map;

    static {
        RecipeAdder.map = new HashMap<>();
    }

    public static void removeRecipes() {
        try {
            for (final NamespacedKey p : RecipeAdder.map.values()) {
                Bukkit.removeRecipe(p);
            }
        } catch (Exception ex) {
        }
    }


    private static void addRecipeWithItem(Main plugin, int id, Integer param1, Integer param2, Integer param3, String[] shape, char[] keys, Material[] materials) {
        if (GlobalVars.craftingDisabled) return;

        NamespacedKey key = new NamespacedKey(plugin, "opitems_recipe_" + id);
        map.put(id, key);

        ItemStack item;
        if (param1 != null && param2 != null && param3 != null) item = getItem(id, param1, param2, param3);
        else if (param1 != null && param2 != null) item = getItem(id, param1, param2);
        else if (param1 != null) item = getItem(id, param1);
        else item = getItem(id);

        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(shape);

        for (int i = 0; i < keys.length; i++) {
            recipe.setIngredient(keys[i], materials[i]);
        }

        try {
            Bukkit.addRecipe(recipe);
        } catch (Error e) {
            System.err.println("Error adding recipe " + id + ": " + e.getMessage());
        }
    }

    public static void addRecipe1(final Main pluginint, final int level) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_1");
        RecipeAdder.map.put(1, key);

        ItemStack itemStack = getItem(1, level);

        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"a!a", "a@a", "a@a"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('!', Material.SLIME_BLOCK);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if(!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe2(final Main pluginint, final int level) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey( pluginint, "opitems_desc_2");
        RecipeAdder.map.put(2, key);
        final ItemStack itemStack = getItem(2, level);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape("a!a", "!!!", "a@a");
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        }catch (Error e){
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe3(final Main pluginint, int protLevel) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_3");
        RecipeAdder.map.put(3, key);
        final ItemStack itemStack = getItem(3, protLevel);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"!a!", "!!!", "!!!"});
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe4(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_4");
        RecipeAdder.map.put(4, key);
        final ItemStack itemStack = getItem(4);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"a!a", "b!b", "@!@"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.BOW);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe5(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_5");
        RecipeAdder.map.put(5, key);
        final ItemStack itemStack = getItem(5);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"a!a", "aba", "a@a"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe6(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_6");
        RecipeAdder.map.put(6, key);
        final ItemStack itemStack = getItem(6);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{" ! ", " b ", " @ "});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.TNT);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe7(final Main pluginint, final int speed, final int loot) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_7");
        RecipeAdder.map.put(7, key);
        final ItemStack itemStack = getItem(7, speed, loot);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"!!!", "a@a", "a@a"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('!', Material.NETHERITE_BLOCK);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe8(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_8");
        RecipeAdder.map.put(8, key);
        final ItemStack itemStack = getItem(8);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"b@b", "@!@", "a@a"});
        shapedRecipe.setIngredient('@', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('!', Material.PIG_SPAWN_EGG);
        shapedRecipe.setIngredient('b', Material.BOW);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe9(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_9");
        RecipeAdder.map.put(9, key);
        final ItemStack itemStack = getItem(9);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"a@a", "@!@", "a@a"});
        shapedRecipe.setIngredient('@', Material.PORKCHOP);
        shapedRecipe.setIngredient('!', Material.NETHER_STAR);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe10(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_10");
        RecipeAdder.map.put(10, key);
        final ItemStack itemStack = getItem(10);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"b@b", "@!@", "a@a"});
        shapedRecipe.setIngredient('@', Material.ENDER_PEARL);
        shapedRecipe.setIngredient('!', Material.NETHERITE_SWORD);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe11(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_11");
        RecipeAdder.map.put(11, key);
        final ItemStack itemStack = getItem(11);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"b@b", "@!@", "aca"});
        shapedRecipe.setIngredient('@', Material.PRISMARINE_SHARD);
        shapedRecipe.setIngredient('!', Material.NETHERITE_SWORD);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('c', Material.NETHERITE_BLOCK);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe12(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_12");
        RecipeAdder.map.put(12, key);
        final ItemStack itemStack = getItem(12);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"a@a", "@!@", "a@a"});
        shapedRecipe.setIngredient('@', Material.DIAMOND);
        shapedRecipe.setIngredient('!', Material.CRAFTING_TABLE);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe13(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_13");
        RecipeAdder.map.put(13, key);
        final ItemStack itemStack = getItem(13);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"a@a", "a!a", "aaa"});
        shapedRecipe.setIngredient('@', Material.DRAGON_BREATH);
        shapedRecipe.setIngredient('a', Material.NETHERITE_BLOCK);
        shapedRecipe.setIngredient('!', Material.FEATHER);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe14(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_14");
        RecipeAdder.map.put(14, key);
        final ItemStack itemStack = getItem(14);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aba", "!@!", "aaa"});
        shapedRecipe.setIngredient('@', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('b', Material.NETHERITE_BLOCK);

        shapedRecipe.setIngredient('!', Material.FEATHER);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe15(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_15");
        RecipeAdder.map.put(15, key);
        final ItemStack itemStack = getItem(15);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aa@", "a@b", "@ab"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe16(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_16");
        RecipeAdder.map.put(16, key);
        final ItemStack itemStack = getItem(16);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bbb", "b@b", "aca"});
        shapedRecipe.setIngredient('@', Material.DIAMOND_HELMET);
        shapedRecipe.setIngredient('b', Material.IRON_INGOT);

        shapedRecipe.setIngredient('c', Material.LANTERN);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe17(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_17");
        RecipeAdder.map.put(17, key);
        final ItemStack itemStack = getItem(17);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bbb", "b@b", "aca"});
        shapedRecipe.setIngredient('@', Material.DIAMOND_HELMET);
        shapedRecipe.setIngredient('b', Material.IRON_INGOT);

        shapedRecipe.setIngredient('c', Material.TURTLE_HELMET);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe18(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_18");
        RecipeAdder.map.put(18, key);
        final ItemStack itemStack = getItem(18);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aaa", "b@b", "bcb"});
        shapedRecipe.setIngredient('@', Material.LEATHER_BOOTS);
        shapedRecipe.setIngredient('b', Material.IRON_INGOT);

        shapedRecipe.setIngredient('c', Material.LAVA_BUCKET);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe19(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_19");
        RecipeAdder.map.put(19, key);
        final ItemStack itemStack = getItem(19);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aba", "b@b", "aba"});
        shapedRecipe.setIngredient('@', Material.FEATHER);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe20(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_20");
        RecipeAdder.map.put(20, key);
        final ItemStack itemStack = getItem(20);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"@a@", "tbt", "@t@"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('a', Material.TNT);
        shapedRecipe.setIngredient('t', Material.BLAZE_ROD);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe21(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_21");
        RecipeAdder.map.put(21, key);
        final ItemStack itemStack = getItem(21);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"@a@", "tbt", "@t@"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_BLOCK);
        shapedRecipe.setIngredient('a', Material.TNT);
        shapedRecipe.setIngredient('t', Material.BLAZE_ROD);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe22(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_22");
        RecipeAdder.map.put(22, key);
        final ItemStack itemStack = getItem(22);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bbb", "btb", "bab"});
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('a', Material.PHANTOM_MEMBRANE);
        shapedRecipe.setIngredient('t', Material.DRAGON_BREATH);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe23(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_23");
        RecipeAdder.map.put(23, key);
        final ItemStack itemStack = getItem(23);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bab", "beb", "btb"});
        shapedRecipe.setIngredient('a', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('t', Material.DIAMOND);
        shapedRecipe.setIngredient('e', Material.IRON_LEGGINGS);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe24(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_24");
        RecipeAdder.map.put(24, key);
        final ItemStack itemStack = getItem(24);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bab", "aba", "bab"});
        shapedRecipe.setIngredient('a', Material.SPONGE);
        shapedRecipe.setIngredient('b', Material.GOLD_INGOT);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe25(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_25");
        RecipeAdder.map.put(25, key);
        final ItemStack itemStack = getItem(25);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bab", "aca", "bab"});
        shapedRecipe.setIngredient('a', Material.SPONGE);
        shapedRecipe.setIngredient('b', Material.GOLD_INGOT);
        shapedRecipe.setIngredient('c', Material.MAGMA_BLOCK);
        try {
            try {
                Bukkit.getServer().addRecipe(shapedRecipe);
            } catch (Error e) {
                Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
                Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
                if (!(CLogger.isEnabled()))
                    CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

            }
        } catch (IllegalStateException ex) {
        }
    }

    public static void addRecipe26(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_26");
        RecipeAdder.map.put(26, key);
        final ItemStack itemStack = getItem(26);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape("dcd", "cac", "cbc");
        shapedRecipe.setIngredient('a', Material.NETHERITE_SWORD);
        shapedRecipe.setIngredient('b', Material.ENDER_EYE);
        shapedRecipe.setIngredient('c', Material.ENDER_PEARL);
        shapedRecipe.setIngredient('d', Material.NETHERITE_INGOT);
        try {
            try {
                Bukkit.getServer().addRecipe(shapedRecipe);
            } catch (Error e) {
                Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
                Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
                if (!(CLogger.isEnabled()))
                    CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

                CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
                CLogger.logAndFlush(e.getMessage());

            }
        } catch (IllegalStateException ex) {
        }
    }

    public static void addRecipe27(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_27");
        RecipeAdder.map.put(27, key);
        final ItemStack itemStack = getItem(27);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"a!a", "aba", "a@a"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('!', Material.BLAZE_POWDER);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

                CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
                CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe28(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_28");
        RecipeAdder.map.put(28, key);
        final ItemStack itemStack = getItem(28);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"b!b", "bxb", "a@a"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('!', Material.BLAZE_POWDER);

        shapedRecipe.setIngredient('x', Material.GLOWSTONE);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe29(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_29");
        RecipeAdder.map.put(29, key);
        final ItemStack itemStack = getItem(29);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bbb", "cxc", "a@a"});
        shapedRecipe.setIngredient('@', Material.BAMBOO);
        shapedRecipe.setIngredient('b', Material.NETHERITE_BLOCK);

        shapedRecipe.setIngredient('c', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('x', Material.NETHER_STAR);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe30(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_30");
        RecipeAdder.map.put(30, key);
        final ItemStack itemStack = getItem(30);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bcb", "bab", "aaa"});
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);

        shapedRecipe.setIngredient('c', Material.DIAMOND);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe31(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_31");
        RecipeAdder.map.put(31, key);
        final ItemStack itemStack = getItem(31);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bbb", "ada", "aca"});
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);

        shapedRecipe.setIngredient('c', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('d', Material.BELL);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe32(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_32");
        RecipeAdder.map.put(32, key);
        final ItemStack itemStack = getItem(32);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"bbb", "ada", "ccc"});
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);

        shapedRecipe.setIngredient('c', Material.TNT);
        shapedRecipe.setIngredient('d', Material.BOW);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe33(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_33");
        RecipeAdder.map.put(33, key);
        final ItemStack itemStack = getItem(33);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"ebe", "ada", "aca"});
        shapedRecipe.setIngredient('b', Material.NETHERITE_INGOT);

        shapedRecipe.setIngredient('c', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('d', Material.SLIME_BLOCK);

        shapedRecipe.setIngredient('e', Material.NETHERITE_BLOCK);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe34(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_34");
        RecipeAdder.map.put(34, key);
        final ItemStack itemStack = getItem(34);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aaa", "aba", "aaa"});
        shapedRecipe.setIngredient('b', Material.FLINT_AND_STEEL);
        shapedRecipe.setIngredient('a', Material.OBSIDIAN);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe35(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_35");
        RecipeAdder.map.put(35, key);
        final ItemStack itemStack = getItem(35);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aaa", "aba", "aaa"});
        shapedRecipe.setIngredient('b', Material.APPLE);
        shapedRecipe.setIngredient('a', Material.BAMBOO);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe36(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_36");
        RecipeAdder.map.put(36, key);
        final ItemStack itemStack = getItem(36);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aba", "bab", "aba"});
        shapedRecipe.setIngredient('b', Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        shapedRecipe.setIngredient('a', Material.TNT);
        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe37(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_37");
        RecipeAdder.map.put(37, key);
        final ItemStack itemStack = getItem(37);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"aba", "xcx", "xcx"});
        shapedRecipe.setIngredient('b', Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        shapedRecipe.setIngredient('a', Material.NETHERITE_INGOT);
        shapedRecipe.setIngredient('c', Material.BLAZE_ROD);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe38(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_38");
        RecipeAdder.map.put(38, key);
        final ItemStack itemStack = getItem(38);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"xcx", "xax", "bbb"});
        shapedRecipe.setIngredient('b', Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        shapedRecipe.setIngredient('a', Material.WATER_BUCKET);
        shapedRecipe.setIngredient('c', Material.DIAMOND);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe39(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey((Plugin) pluginint, "opitems_desc_39");
        RecipeAdder.map.put(39, key);
        final ItemStack itemStack = getItem(39);

        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"ccc", "xax", "bdb"});
        shapedRecipe.setIngredient('a', Material.ELYTRA);
        shapedRecipe.setIngredient('b', Material.DIAMOND);
        shapedRecipe.setIngredient('c', Material.DIAMOND);
        shapedRecipe.setIngredient('d', Material.NETHERITE_CHESTPLATE);


        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe40(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_40");
        RecipeAdder.map.put(40, key);
        final ItemStack itemStack = getItem(40);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"ccc", "xax", "bdb"});
        shapedRecipe.setIngredient('a', Material.HEART_OF_THE_SEA);
        shapedRecipe.setIngredient('x', Material.DIAMOND);
        shapedRecipe.setIngredient('b', Material.FEATHER);
        shapedRecipe.setIngredient('c', Material.QUARTZ);
        shapedRecipe.setIngredient('d', Material.TRIDENT);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }


    public static void addRecipe41(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_41");
        RecipeAdder.map.put(41, key);
        final ItemStack itemStack = getItem(41);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"cxc", "xax", "bdb"});
        shapedRecipe.setIngredient('a', Material.NETHER_STAR);
        shapedRecipe.setIngredient('x', Material.OBSIDIAN);
        shapedRecipe.setIngredient('b', Material.IRON_BARS);
        shapedRecipe.setIngredient('c', Material.OBSERVER);
        shapedRecipe.setIngredient('d', Material.END_ROD);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe42(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_42");
        RecipeAdder.map.put(42, key);
        final ItemStack itemStack = getItem(42);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[]{"xbx", "xcx", "xax"});
        shapedRecipe.setIngredient('x', Material.DIAMOND);
        shapedRecipe.setIngredient('b', Material.DIAMOND_BLOCK);
        shapedRecipe.setIngredient('c', Material.FEATHER);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe43(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_43");
        RecipeAdder.map.put(43, key);
        final ItemStack itemStack = getItem(43);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "xbx", "xcx", "xax" });
        shapedRecipe.setIngredient('a', Material.BLAZE_ROD);
        shapedRecipe.setIngredient('b', Material.DIAMOND_BLOCK);
        shapedRecipe.setIngredient('c', Material.BOW);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

    public static void addRecipe44(final Main pluginint) {
        if (GlobalVars.craftingDisabled)
            return;

        final NamespacedKey key = new NamespacedKey(pluginint, "opitems_desc_44");
        RecipeAdder.map.put(44, key);
        final ItemStack itemStack = getItem(44);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape("abc", "xxx", "def");
        shapedRecipe.setIngredient('a', Material.CRAFTING_TABLE);
        shapedRecipe.setIngredient('b', Material.STONECUTTER);
        shapedRecipe.setIngredient('c', Material.ANVIL);
        shapedRecipe.setIngredient('d', Material.LOOM);
        shapedRecipe.setIngredient('e', Material.SMITHING_TABLE);
        shapedRecipe.setIngredient('f', Material.CARTOGRAPHY_TABLE);
        shapedRecipe.setIngredient('x', Material.DIAMOND);

        try {
            Bukkit.getServer().addRecipe(shapedRecipe);
        } catch (Error e) {
            Bukkit.getLogger().severe("There was an error adding an recipe! Is this a reload? Please try again.");
            Bukkit.getLogger().warning("The Error was logged in: $DATAFOLDER/opitems/logs/log_$CURRENTTIMEMILLIS.cel20!");
            if (!(CLogger.isEnabled())) CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);

            CLogger.log("ERROR! Adding Recipe " + shapedRecipe.getKey() + "! Error Message:");
            CLogger.logAndFlush(e.getMessage());

        }
    }

}
