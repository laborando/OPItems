package cel20.opitems.items.managers;

import cel20.opitems.op.Main;
import cel20.opitems.items.NameSpaces;
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


        List<String> lore = new ArrayList<>();

        ItemStack itemStack;
        ItemMeta itemMeta;

        NamespacedKey itemTypeIDNS = new NamespacedKey(Main.getPluginInstance(), "itemTypeID");
        NamespacedKey itemTypeVL = new NamespacedKey(Main.getPluginInstance(), "itemVersionLevel");

        switch (id) {
            case 1:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Knocky the Stick");
                lore.add(ChatColor.RED + " - A stick with some real knockback");
                itemMeta.setLore(lore);
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
                lore.add(ChatColor.RED + " - Quite the sword");
                itemMeta.setLore(lore);
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
                //lore.add(ChatColor.RED + " - Heavy, but protects you against pretty much anything");
                itemMeta.setLore(lore);

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
                lore.add(ChatColor.RED + " - Infinitely shoots arrows");
                itemMeta.setLore(lore);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;


            case 5:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Blazer");
                lore.add(ChatColor.RED + " - Shoots fireballs");
                itemMeta.setLore(lore);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 6:
                itemStack = new ItemStack(Material.BLAZE_POWDER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Boomer");
                lore.add(ChatColor.RED + " - Shoots TNT");
                itemMeta.setLore(lore);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 7:
                itemStack = new ItemStack(Material.NETHERITE_PICKAXE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "PickyPick");
                lore.add(ChatColor.RED + " - A fast pickaxe with some extra luck");
                itemMeta.setLore(lore);
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
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Shoots pigs");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
                break;

            case 9:
                itemStack = new ItemStack(Material.PIG_SPAWN_EGG, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "'Pig'");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - An egg holding a 'pig' made from pork bound together by a nether star");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                break;

            case 10:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Endsword");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Teleports you in the direction you're looking");
                itemMeta.setLore(lore);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 11:
                itemStack = new ItemStack(Material.PRISMARINE_SHARD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Blitzer");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Summons lightning at the targeted block");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.RESPIRATION, 10, true);
                break;

            case 12:
                itemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Crafter");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Opens a crafting menu");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PIERCING, 10, true);
                break;

            case 13:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Feather of Flight");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Click to enables flying");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 14:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "AntiFall");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "nofall");

                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Blocks fall damage if in inventory");
                itemMeta.setLore(lore);
                break;

            case 15:
                itemStack = new ItemStack(Material.FISHING_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Hook of Velectory");
                lore.add(ChatColor.RED + " - Accelerates you towards the hook when reeling in");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 16:
                itemStack = new ItemStack(Material.IRON_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Night Visor");
                lore.add(ChatColor.RED + " - Grants night vision");
                itemMeta.setLore(lore);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "night_vision");

                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 17:
                itemStack = new ItemStack(Material.IRON_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Water Helmet");
                lore.add(ChatColor.RED + " - Grants water breathing");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "water_breathing");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 18:
                itemStack = new ItemStack(Material.LEATHER_BOOTS, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Fire Shoes");
                lore.add(ChatColor.RED + " - Cosmetic fire shoes");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsCosmetic, PersistentDataType.STRING, "fire_norm");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 19:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Launcher");
                lore.add(ChatColor.RED + " - Launches yourself up into the air");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.SOUL_SPEED, 10, true);
                break;

            case 20:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Boom");
                lore.add(ChatColor.RED + " - A wand for making things go boom");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.CHANNELING, 10, true);
                break;

            case 21:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Massive Boom");
                lore.add(ChatColor.RED + " - A wand for even more boom");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 10, true);
                break;

            case 22:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Invisibility");
                lore.add(ChatColor.RED + " - Grants invisibility");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.EFFICIENCY, 10, true);
                break;

            case 23:
                itemStack = new ItemStack(Material.IRON_LEGGINGS, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Speed Leggings");
                lore.add(ChatColor.RED + " - Grants a speed boost");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "speed_effect");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 24:
                itemStack = new ItemStack(Material.SPONGE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Super Sponge");
                lore.add(ChatColor.RED + " - A bigger sponge for bigger problems");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 25:
                itemStack = new ItemStack(Material.SPONGE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Lava Sponge");
                lore.add(ChatColor.RED + " - A sponge for some hot stuff");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FLAME, 10, true);
                break;

            case 26:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Enderpearler");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Throws enderpearls");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);
                break;

            case 27:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Tnt Detonator");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore27 = new ArrayList<>();
                lore27.add(ChatColor.RED + " - Right-click on a TNT-Block to connect it to the detonator");
                lore27.add(ChatColor.RED + " - Right-click air + sneak to activate the connected TNT-Blocks");
                itemMeta.setLore(lore27);
                break;

            case 28:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Cursed Sword");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore28 = new ArrayList<>();
                lore28.add(ChatColor.RED + " - Attacking enemies kills them instantly");
                lore28.add(ChatColor.RED + " - What could be the downside?");
                itemMeta.setLore(lore28);
                break;

            case 29:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Private Pocket Dimension Wand");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore29 = new ArrayList<>();
                lore29.add(ChatColor.RED + " - Right-click to change between the overworld and your private dimension");
                itemMeta.setLore(lore29);
                break;

            case 30:
                itemStack = new ItemStack(Material.NETHERITE_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Anti Explosion Helmet");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore30 = new ArrayList<>();
                lore30.add(ChatColor.RED + " - A helmet that's just pretty strong against explosions");
                itemMeta.setLore(lore30);
                break;

            case 31:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Home");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore31 = new ArrayList<>();
                lore31.add(ChatColor.RED + " - Right-click in the air to teleport to your home");
                lore31.add(ChatColor.RED + " - Right-click + Sneak to set your home");
                itemMeta.setLore(lore31);
                break;

            case 32:
                itemStack = new ItemStack(Material.BOW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "TNT Bow");
                lore.add(ChatColor.RED + " - Shoots an arrow with some extra TNT attached");
                itemMeta.setLore(lore);
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
                List<String> lore33 = new ArrayList<>();
                lore33.add(ChatColor.RED + " - Right-click to charge");
                lore33.add(ChatColor.RED + " - Right-click + sneak to release the Blocks");
                itemMeta.setLore(lore33);
                break;

            case 34:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Portal2Go");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore34 = new ArrayList<>();
                lore34.add(ChatColor.RED + " - Right-click to travel between the overworld and the nether");
                itemMeta.setLore(lore34);
                break;

            case 35:
                itemStack = new ItemStack(Material.PLAYER_HEAD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Skull Imitator");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore35 = new ArrayList<>();
                lore35.add(ChatColor.RED + " - Right-click in the air to change the texture");
                lore35.add(ChatColor.RED + " - Place + Sneak to place and lock this heads texture");
                itemMeta.setLore(lore35);
                break;

            case 36:
                itemStack = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Landmine");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "landmine");

                List<String> lore36 = new ArrayList<>();
                lore36.add(ChatColor.RED + " - Place on the ground to set up");
                lore36.add(ChatColor.RED + " - Explodes when destroyed or stepped on");
                itemMeta.setLore(lore36);
                break;

            case 37:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Defuser");

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "defuse");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore37 = new ArrayList<>();
                lore37.add(ChatColor.RED + " - Click on a landmine to diffuse it");
                itemMeta.setLore(lore37);
                break;

            case 38:
                itemStack = new ItemStack(Material.WATER_BUCKET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Infinite Water Bucket");
                lore.add(ChatColor.RED + " - A bucket with no bottom");
                itemMeta.setLore(lore);
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
                break;

            case 40:
                itemStack = new ItemStack(Material.COOKED_BEEF, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Eternal Steak");
                List<String> lore40 = new ArrayList<>();
                lore40.add(ChatColor.RED + " - An eternal steak...");
                itemMeta.setLore(lore40);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 41:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Wand of Warden");
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore41 = new ArrayList<>();
                lore41.add(ChatColor.RED + " - Click a block to spawn a warden for 5 hearts");
                itemMeta.setLore(lore41);
                break;

            case 42:
                itemStack = new ItemStack(Material.FIREWORK_ROCKET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setMaxStackSize(1);
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Infinite Rocket");
                List<String> lore42 = new ArrayList<>();
                lore42.add(ChatColor.RED + " - Infinite rocket for flying even further");
                itemMeta.setLore(lore42);
                break;

            case 43:
                itemStack = new ItemStack(Material.BOW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Piercer");
                List<String> lore43 = new ArrayList<>();
                lore43.add(ChatColor.RED + " - Shoots piercing arrows");
                itemMeta.setLore(lore43);

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 44:
                itemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Portable Work Station");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - A portable multiuse workstation");
                itemMeta.setLore(lore);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "workstation");

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 45:
                itemStack = new ItemStack(Material.HONEY_BOTTLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Strange Bottle");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - A bottle with some substance that never empties");
                lore.add(ChatColor.RED + " - Seems to have different effects");
                itemMeta.setLore(lore);

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 46:
                itemStack = new ItemStack(Material.MILK_BUCKET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Infinite Milk Bucket");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - A Bucket with quite an amount of milk to drink");
                itemMeta.setLore(lore);

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 47:
                itemStack = new ItemStack(Material.ENDER_CHEST, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Portable Ender Chest");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Click to open your ender chest");
                itemMeta.setLore(lore);

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 48:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Subspace Stick");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Used to access the subspace for faster travel");
                itemMeta.setLore(lore);

                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 49:
                itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.DARK_RED + "Experience Storage");
                lore = new ArrayList<>();
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
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Click on a item frame to make it invisible");
                itemMeta.setLore(lore);

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
