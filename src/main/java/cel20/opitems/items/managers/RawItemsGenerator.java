package cel20.opitems.items.managers;

import ca.spottedleaf.starlight.common.light.StarLightInterface;
import cel20.opitems.op.Main;
import cel20.opitems.items.NameSpaces;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;


/**
 * Class for generating OPItems <br>
 * Returned ItemStack is ready for usage
 */
public class RawItemsGenerator {

    public static ItemStack getItem(int id, int... lvl) {
        int level = (lvl.length > 0) ? lvl[0] : -1;

        if (level != -1) {
            return getItem(id, level, 0);
        } else {
            return getItem(id, 0, 0);
        }
    }

    public static ItemStack getItem(int id, int param1, int param2) {
        return getItem(id, param1, param2, false);
    }


    public static ItemStack getItem(int id, int param1, int param2, boolean isGUI) {


        List<String> description = new ArrayList<>();
        List<String> usage = new ArrayList<>();

        ItemStack itemStack;
        ItemMeta itemMeta;

        NamespacedKey itemTypeIDNS = new NamespacedKey(Main.getPluginInstance(), "itemTypeID");
        NamespacedKey itemTypeVL = new NamespacedKey(Main.getPluginInstance(), "itemVersionLevel");

        switch (id) {
            case 1:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Knocky the Stick");
                description.add("A stick with some real knockback");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                if (param1 == -5) {
                    param1 = 10;
                }
                itemMeta.addEnchant(Enchantment.KNOCKBACK, param1, true);


                if (param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();
                break;

            case 2:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "The Blocky Sword");
                description.add("Quite the sword");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                if (param1 == -5) {
                    param1 = 10;
                }
                itemMeta.addEnchant(Enchantment.SHARPNESS, param1, true);


                if (param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();

                itemMeta.setUnbreakable(true);

                break;

            case 3:
                itemStack = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "The Anti Damage");
                description.add("Heavy, but sturdy");

                if (param1 == -5) {
                    param1 = 10;
                }


                itemMeta.addEnchant(Enchantment.PROTECTION, param1, true);

                if (param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();

                itemMeta.setUnbreakable(true);
                break;


            case 4:
                itemStack = new ItemStack(Material.ARROW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Bower");
                description.add("A arrow that somehow shoots arrows");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;


            case 5:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Blazer");
                description.add("Shoots fireballs");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 6:
                itemStack = new ItemStack(Material.BLAZE_POWDER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Boomer");
                description.add("Shoots TNT");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 7:
                itemStack = new ItemStack(Material.NETHERITE_PICKAXE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "PickyPick");
                description.add("A fast and lucky pickaxe");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                if (param1 == -5) {
                    param1 = 100;
                }

                if (param2 == -5) {
                    param2 = 6;
                }

                itemMeta.addEnchant(Enchantment.FORTUNE, param2, true); // loot
                itemMeta.addEnchant(Enchantment.EFFICIENCY, param1, true); // speed
                itemMeta.setUnbreakable(true);
                if (param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();
                break;

            case 8:
                itemStack = new ItemStack(Material.COOKED_PORKCHOP, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Pig Cannon");
                description.add("Shoots Pigs");
                description.add("Don't ask why, I got no idea");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
                break;

            case 9:
                itemStack = new ItemStack(Material.PIG_SPAWN_EGG, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "'Pig'");
                description.add("An egg holding a 'pig' made from pork bound together by a nether star");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                break;

            case 10:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Endsword");
                description.add("A sword disrespecting the fabric of space-time");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 11:
                itemStack = new ItemStack(Material.PRISMARINE_SHARD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Blitzer");
                description.add("A tool for summoning lightning");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.RESPIRATION, 10, true);
                break;

            case 12:
                itemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Crafter");
                description.add("A portable crafting table");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PIERCING, 10, true);
                break;

            case 13:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Feather of Flight");
                description.add("Allows users to levitate at will");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 14:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "AntiFall");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "nofall");

                description.add("Prevents fall-damage");

                break;

            case 15:
                itemStack = new ItemStack(Material.FISHING_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Hook of Velectory");
                description.add("Accelerates the user towards the hook");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 16:
                itemStack = new ItemStack(Material.IRON_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Night Visor");
                description.add("Grants nightly vision");

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "night_vision");

                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 17:
                itemStack = new ItemStack(Material.IRON_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Water Helmet");
                description.add("Grants the ability to breath under water");
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "water_breathing");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 18:
                itemStack = new ItemStack(Material.LEATHER_BOOTS, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Fire Shoes");
                description.add("Very aesthetical shoes with some flames on top");
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsCosmetic, PersistentDataType.STRING, "fire_norm");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 19:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Launcher");
                description.add("Launches the user into the air");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.SOUL_SPEED, 10, true);
                break;

            case 20:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Boom");
                description.add("A wand for making things go boom");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.CHANNELING, 10, true);
                break;

            case 21:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Massive Boom");
                description.add("A wand for making things go even more boom");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 10, true);
                break;

            case 22:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Invisibility");
                description.add("Grants the user invisibility");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.EFFICIENCY, 10, true);
                break;

            case 23:
                itemStack = new ItemStack(Material.IRON_LEGGINGS, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Speed Leggings");
                description.add("Grants the user increased speed");
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "speed_effect");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 24:
                itemStack = new ItemStack(Material.SPONGE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Super Sponge");
                description.add("A bigger sponge for bigger problems");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 25:
                itemStack = new ItemStack(Material.SPONGE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Lava Sponge");
                description.add("A sponge modified to handle the hot stuff");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FLAME, 10, true);
                break;

            case 26:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Enderpearler");
                description.add("A sword with the ability to throw ender pearls");
                itemMeta.setUnbreakable(true);
                break;

            case 27:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Tnt Detonator");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                description.add("A wand for detonating TNT remotely (and anonymously)");

                usage.add("- Right-click a TNT-Block to connect it to the detonator");
                usage.add("- Right-click air + sneak to detonate the connected TNT-Blocks");

                break;

            case 28:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Cursed Sword");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                description.add("A sword for insta-killing monsters");
                description.add("May or may not have a downside");
                break;

            case 29:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Private Pocket Dimension Wand");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                description.add("A wand enabling access to your own private dimension");
                break;

            case 30:
                itemStack = new ItemStack(Material.NETHERITE_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Anti Explosion Helmet");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                description.add("A helmet that's just pretty strong against explosions");
                break;

            case 31:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Home");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


                description.add("A wand for traveling home fast");

                usage.add("Right-click air to teleport home");
                usage.add("Right-click + Sneak to set new home");

                break;

            case 32:
                itemStack = new ItemStack(Material.BOW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "TNT Bow");
                description.add("A bow with some extra explosive flavour");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 33:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Blocks");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                description.add("A wand for controlling blocks and shooting them");

                usage.add("- Right-click to charge");
                usage.add("- Right-click + sneak to release the Blocks");
                break;

            case 34:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Portal2Go");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                description.add("A wand enabling easy travel between the overworld and the nether");
                break;

            case 35:
                itemStack = new ItemStack(Material.PLAYER_HEAD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Skull Imitator");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                description.add("A fake skull imitating the user");

                usage.add("- Right-click air to update the texture");
                usage.add("- Place + sneak to place and lock this heads texture");

                break;

            case 36:
                itemStack = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Landmine");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "landmine");

                description.add("A landmine for some extra fun");

                usage.add("- Place on the ground to set up");
                usage.add("- Explodes when destroyed or stepped on");
                usage.add("- Can be disabled with a defuser");

                break;

            case 37:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Defuser");
                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "defuse");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                description.add("A tool for removing some 'extra fun'");

                usage.add("- Click on a landmine to diffuse it");

                break;

            case 38:
                itemStack = new ItemStack(Material.WATER_BUCKET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Infinite Water Bucket");
                description.add("A bucket with no bottom");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 39:
                itemStack = new ItemStack(Material.ELYTRA, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Protective Elytra");
                itemMeta.addEnchant(Enchantment.PROTECTION, 10, true);
                itemMeta.addEnchant(Enchantment.FIRE_PROTECTION, 3, true);
                itemMeta.addEnchant(Enchantment.BLAST_PROTECTION, 3, true);
                itemMeta.addEnchant(Enchantment.PROJECTILE_PROTECTION, 3, true);
                itemMeta.addEnchant(Enchantment.UNBREAKING, 3, true);
                itemMeta.addEnchant(Enchantment.MENDING, 3, true);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                description.add("A elytra with some defensive capabilities");
                break;

            case 40:
                itemStack = new ItemStack(Material.COOKED_BEEF, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Eternal Steak");

                description.add("An eternal steak...");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 41:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Warden");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                description.add("A wand for summoning a warden ");
                break;

            case 42:
                itemStack = new ItemStack(Material.FIREWORK_ROCKET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setMaxStackSize(1);
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Infinite Rocket");
                description.add("Infinite rocket for flying even further");
                break;

            case 43:
                itemStack = new ItemStack(Material.BOW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Piercer");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 44:
                itemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Portable Work Station");
                description.add("A portable multiuse workstation");

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "workstation");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 45:
                itemStack = new ItemStack(Material.HONEY_BOTTLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Strange Bottle");

                description.add("A bottle with a strange substance that never empties");
                description.add("Tastes interesting");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 46:
                itemStack = new ItemStack(Material.MILK_BUCKET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Infinite Milk Bucket");

                description.add("A Bucket with quite an amount of milk to drink");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 47:
                itemStack = new ItemStack(Material.ENDER_CHEST, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Portable Ender Chest");
                description.add("Just a portable ender chest");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 48:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Subspace Stick");

                description.add("A wand enabling access to the subspace for faster travel");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 49:
                itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Experience Storage");

                //Here, the custom List<String> lore is a must be!
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Click to transfer experience to this bottle");
                lore.add(ChatColor.RED + " - Shift + throw to release the exp");
                lore.add("");
                lore.add(ChatColor.DARK_PURPLE + "Current exp stored: 0");
                itemMeta.setLore(lore);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsXPStorageAmount, PersistentDataType.INTEGER, 0);

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 50:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Item Frame Hider");
                description.add("A tool for hiding item frames");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                break;

            default:

                if (isGUI) {
                    itemStack = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1);
                    itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName("This position is open for future additions");
                } else {
                    itemStack = new ItemStack(Material.STICK, 1);
                    itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(ChatColor.RED + "There was an error getting this item | id: " + id + "," + param1 + "," + param2);
                }
                break;
        }

        if(!itemMeta.hasLore()){
            List<Component> re = new ArrayList<Component>();

            for (String i : description){
                re.add(Component.text(i, TextColor.color(84, 84, 84)));
            }
            if(!usage.isEmpty())
                re.add(Component.empty());

            for (String i : usage){
                re.add(Component.text(i, TextColor.color(255, 16, 24)));
            }

            itemMeta.lore(re);
        }



        itemStack.setItemMeta(itemMeta);
        itemMeta = itemStack.getItemMeta();

        try {

            itemMeta.setRarity(ItemRarity.EPIC);

            //Pig-Egg has to be usable like normal
            if (id == 9) {

                List<String> cLore = itemMeta.getLore();

                if (cLore == null)
                    cLore = new ArrayList<>();

                cLore.add("");
                cLore.add(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "OPItems");

                itemMeta.setLore(cLore);

            }





            if (!isGUI) {
                itemMeta.getPersistentDataContainer().set(itemTypeIDNS, PersistentDataType.STRING, "opitems_" + id);
                itemMeta.getPersistentDataContainer().set(itemTypeVL, PersistentDataType.STRING, "opitems_" + Main.opitemsVersion);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsMarker, PersistentDataType.STRING, "true");
                List<String> cLore = itemMeta.getLore();

                if (cLore == null)
                    cLore = new ArrayList<>();

                cLore.add("");
                cLore.add(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "OPItems");

                itemMeta.setLore(cLore);


                itemStack.setItemMeta(itemMeta);
            } else {
                itemMeta.getPersistentDataContainer().set(itemTypeIDNS, PersistentDataType.STRING, "opitems_illegal");
                itemMeta.getPersistentDataContainer().set(itemTypeVL, PersistentDataType.STRING, "opitems_" + Main.opitemsVersion);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsMarker, PersistentDataType.STRING, "true");

                itemStack.setItemMeta(itemMeta);
            }


        } catch (Exception e) {
            return itemStack;
        }
        return itemStack;
    }
}
