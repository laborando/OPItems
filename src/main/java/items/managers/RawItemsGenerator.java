package items.managers;

import cel20.op.GlobalVars;
import cel20.op.Main;
import items.NameSpaces;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
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


        ItemStack itemStack;
        ItemMeta itemMeta;

        NamespacedKey itemTypeIDNS = new NamespacedKey(Main.getPluginInstance(), "itemTypeID");
        NamespacedKey itemTypeVL = new NamespacedKey(Main.getPluginInstance(), "itemVersionLevel");

        List<String> lore = new ArrayList<>();

        switch (id) {
            case 1:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Knocky the Stick");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                if(param1 == -5){
                    param1 = (int) Main.getPluginInstance().getConfig().get("CraftedKnockyTheStickKnockbackEnchantmentLevel");
                }
                    itemMeta.addEnchant(Enchantment.KNOCKBACK, param1, true);


                if(param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();
                break;

            case 2:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "The Blocky Sword");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                if(param1 == -5){
                    param1 = (int) Main.getPluginInstance().getConfig().get("CraftedBlockySwordDamageAllEnchantmentLevel");
                }
                    itemMeta.addEnchant(Enchantment.SHARPNESS, param1, true);


                if(param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();
                break;

            case 3:
                itemStack = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "The Anti Damage");

                if(param1 == -5){
                    param1 = (int) Main.getPluginInstance().getConfig().get("CraftedTheAntiDamageProtectionEnchantmentLevel");
                }


                itemMeta.addEnchant(Enchantment.PROTECTION, param1, true);

                if(param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;


            case 4:
                itemStack = new ItemStack(Material.ARROW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Bower");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
                itemMeta.addEnchant(Enchantment.INFINITY, 75, true);
                itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
                break;


            case 5:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Blazer");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
                itemMeta.addEnchant(Enchantment.INFINITY, 75, true);
                itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
                break;

            case 6:
                itemStack = new ItemStack(Material.BLAZE_POWDER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Boomer");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
                itemMeta.addEnchant(Enchantment.INFINITY, 75, true);
                itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
                break;

            case 7:
                itemStack = new ItemStack(Material.NETHERITE_PICKAXE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "PickyPick");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                if(param1 == -5){
                    param1 = (int) Main.getPluginInstance().getConfig().get("CraftedPickyPickDigSpeedEnchantmentLevel");
                }

                if(param2 == -5){
                    param2 = (int) Main.getPluginInstance().getConfig().get("CraftedPickyPickLootBonusBlocksEnchantmentLevel");
                }

                itemMeta.addEnchant(Enchantment.FORTUNE, param2, true); // loot
                itemMeta.addEnchant(Enchantment.EFFICIENCY, param1, true); // speed
                if(param1 == -1)
                    GiveErrorBackgiver.giveLatestPlayerErrorMessageEnchError();
                break;

            case 8:
                itemStack = new ItemStack(Material.COOKED_PORKCHOP, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Pig Cannon");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Shoots pigs");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
                break;

            case 9:
                itemStack = new ItemStack(Material.PIG_SPAWN_EGG, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Pig spawn Egg");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Just for crafting");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
                break;

            case 10:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Endsword");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Teleports you in the direction you're looking");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.SHARPNESS, 10, true);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 11:
                itemStack = new ItemStack(Material.PRISMARINE_SHARD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Blitzer");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Summons lightning at the targeted block");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.RESPIRATION, 10, true);
                break;

            case 12:
                itemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Crafter");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Opens the crafting menu");
                itemMeta.setLore(lore);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PIERCING, 10, true);
                break;

            case 13:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "FlyFeather");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Enables flying");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 14:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "AntiFall");
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "nofall");

                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Blocks fall damage if in inventory");
                itemMeta.setLore(lore);
                break;

            case 15:
                itemStack = new ItemStack(Material.FISHING_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Hook of Velectory");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 16:
                itemStack = new ItemStack(Material.IRON_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Night Visor");

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "night_vision");

                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 17:
                itemStack = new ItemStack(Material.IRON_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Water Helmet");
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "water_breathing");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 18:
                itemStack = new ItemStack(Material.LEATHER_BOOTS, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Fire Shoes");
                itemMeta.setUnbreakable(true);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsCosmetic, PersistentDataType.STRING, "fire_norm");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 19:
                itemStack = new ItemStack(Material.FEATHER, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Laucher");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.SOUL_SPEED, 10, true);
                break;

            case 20:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Wand of Boom");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.CHANNELING, 10, true);
                break;

            case 21:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Wand of Massive Boom");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 10, true);
                break;

            case 22:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Wand of Invisibility");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.EFFICIENCY, 10, true);
                break;

            case 23:
                itemStack = new ItemStack(Material.IRON_LEGGINGS, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Speed Leggings");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 24:
                itemStack = new ItemStack(Material.SPONGE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Super Sponge");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.PUNCH, 10, true);
                break;

            case 25:
                itemStack = new ItemStack(Material.SPONGE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Lava Sponge");
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.FLAME, 10, true);
                break;

            case 26:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Enderpearler");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - Throws ender pearls");
                itemMeta.setLore(lore);
                itemMeta.setUnbreakable(true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                itemMeta.addEnchant(Enchantment.MENDING, 10, true);
                break;

            case 27:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Tnt Detonator");
                itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 75, true);
                itemMeta.addEnchant(Enchantment.INFINITY, 75, true);
                itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
                itemMeta.addEnchant(Enchantment.PUNCH, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore27 = new ArrayList<>();
                lore27.add(ChatColor.RED + " - Right-click on a TNT-Block to add to the list");
                lore27.add(ChatColor.RED + " - Right-click + sneak to activate all listed TNT-Blocks");
                itemMeta.setLore(lore27);
                break;

            case 28:
                itemStack = new ItemStack(Material.NETHERITE_SWORD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Cursed Sword");
                itemMeta.addEnchant(Enchantment.RESPIRATION, 75, true);
                itemMeta.addEnchant(Enchantment.INFINITY, 75, true);
                itemMeta.addEnchant(Enchantment.UNBREAKING, 255, true);
                itemMeta.addEnchant(Enchantment.PUNCH, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore28 = new ArrayList<>();
                lore28.add(ChatColor.RED + " - Right-click to teleport towards the direction you're looking");
                lore28.add(ChatColor.RED + " - Attacking enemies kills them instantly");
                lore28.add(ChatColor.RED + " - What could be the downside?");
                itemMeta.setLore(lore28);
                break;

            case 29:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Private Pocket Dimension Wand");
                itemMeta.addEnchant(Enchantment.DEPTH_STRIDER, 75, true);
                itemMeta.addEnchant(Enchantment.INFINITY, 75, true);
                itemMeta.addEnchant(Enchantment.FROST_WALKER, 75, true);
                itemMeta.addEnchant(Enchantment.FEATHER_FALLING, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore29 = new ArrayList<>();
                lore29.add(ChatColor.RED + " - Right-click to change between the overworld and your private dimension");
                itemMeta.setLore(lore29);
                break;

            case 30:
                itemStack = new ItemStack(Material.NETHERITE_HELMET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Anti Explosion Helmet");
                itemMeta.addEnchant(Enchantment.BLAST_PROTECTION, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore30 = new ArrayList<>();
                lore30.add(ChatColor.RED + "A helmet that's just pretty strong against explosions");
                itemMeta.setLore(lore30);
                break;

            case 31:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Wand of Home");
                itemMeta.addEnchant(Enchantment.BLAST_PROTECTION, 75, true);
                itemMeta.addEnchant(Enchantment.FIRE_PROTECTION, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore31 = new ArrayList<>();
                lore31.add(ChatColor.RED + " - Right-click in the air to teleport to your home");
                lore31.add(ChatColor.RED + " - Right-click + Sneak to set your home");
                itemMeta.setLore(lore31);
                break;

            case 32:
                itemStack = new ItemStack(Material.BOW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "TNT Bow");
                itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 33:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Wand of Blocks");
                itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
                itemMeta.addEnchant(Enchantment.THORNS, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore33 = new ArrayList<>();
                lore33.add(ChatColor.RED + " - Right-click to charge");
                lore33.add(ChatColor.RED + " - Right-click + sneak to release the Blocks");
                itemMeta.setLore(lore33);
                break;

            case 34:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Portal2Go");
                itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
                itemMeta.addEnchant(Enchantment.THORNS, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore34 = new ArrayList<>();
                lore34.add(ChatColor.RED + " - Right-click in the air to travel between the overworld and the nether");
                itemMeta.setLore(lore34);
                break;

            case 35:
                itemStack = new ItemStack(Material.PLAYER_HEAD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Skull Imitator");
                itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
                itemMeta.addEnchant(Enchantment.THORNS, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore35 = new ArrayList<>();
                lore35.add(ChatColor.RED + " - Right-click in the air to change the texture");
                lore35.add(ChatColor.RED + " - Place + Sneak to place and lock this heads texture");
                itemMeta.setLore(lore35);
                break;

            case 36:
                itemStack = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 4);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Landmine");
                itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
                itemMeta.addEnchant(Enchantment.THORNS, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "landmine");

                List<String> lore36 = new ArrayList<>();
                lore36.add(ChatColor.RED + " - Place on the ground to set up");
                lore36.add(ChatColor.RED + " - Explodes when destroyed or stepped on");
                lore36.add(ChatColor.RED + " - Can be diffused");
                itemMeta.setLore(lore36);
                break;

            case 37:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Defuser");

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "defuse");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore37 = new ArrayList<>();
                lore37.add(ChatColor.RED + " - Click on a landmine to diffuse");
                itemMeta.setLore(lore37);
                break;

            case 38:
                itemStack = new ItemStack(Material.WATER_BUCKET, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Infinite Water Bucket");
                itemMeta.addEnchant(Enchantment.SWEEPING_EDGE, 75, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 39:
                itemStack = new ItemStack(Material.ELYTRA, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Protective Elytra");
                itemMeta.addEnchant(Enchantment.PROTECTION, 10, true);
                itemMeta.addEnchant(Enchantment.FIRE_PROTECTION, 3, true);
                itemMeta.addEnchant(Enchantment.BLAST_PROTECTION, 3, true);
                itemMeta.addEnchant(Enchantment.PROJECTILE_PROTECTION, 3, true);
                itemMeta.addEnchant(Enchantment.UNBREAKING, 3, true);
                itemMeta.addEnchant(Enchantment.MENDING, 3, true);
                break;

            case 40:
                itemStack = new ItemStack(Material.TRIDENT, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Unused OPItems itemslot 40");
                List<String> lore40 = new ArrayList<>();
                lore40.add(ChatColor.RED + " - !");
                lore40.add(ChatColor.RED + " - !");
                itemMeta.setLore(lore40);
                break;

            case 41:
                itemStack = new ItemStack(Material.BLAZE_ROD, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Wand of Warden");
                itemMeta.addEnchant(Enchantment.PUNCH, 1, false);
                itemMeta.addEnchant(Enchantment.QUICK_CHARGE, 1, false);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore41 = new ArrayList<>();
                lore41.add(ChatColor.RED + " - Click anywhere on the ground to spawn a warden!");
                lore41.add(ChatColor.RED + " - Effect: -5 Hearts; Spawns Warden at the clicked position");
                itemMeta.setLore(lore41);
                break;

            case 42:
                itemStack = new ItemStack(Material.DIAMOND_BOOTS, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.DARK_RED + "Not Implemented");
                List<String> lore42 = new ArrayList<>();
                lore42.add(ChatColor.RED + " - Currently not implemented!");
                lore42.add(ChatColor.RED + " - Enables one to triple jump");
                itemMeta.setLore(lore42);
                break;

            case 43:
                itemStack = new ItemStack(Material.BOW, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Piercer");
                List<String> lore43 = new ArrayList<>();
                lore43.add(ChatColor.RED + " - Shoots piercing arrows");
                itemMeta.setLore(lore43);
                itemMeta.addEnchant(Enchantment.PUNCH, 3, true);
                itemMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 3, true);
                itemMeta.addEnchant(Enchantment.PUNCH, 3, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;

            case 44:
                itemStack = new ItemStack(Material.CRAFTING_TABLE, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Portable Work Station");
                lore = new ArrayList<>();
                lore.add(ChatColor.RED + " - A portable multiuse workstation");
                lore.add(ChatColor.RED + " - Wont work for now");
                itemMeta.setLore(lore);

                itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsAbilities, PersistentDataType.STRING, "workstation");

                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                break;


            default:
                itemStack = new ItemStack(Material.STICK, 1);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "There was an error getting this item | id: " + id + "," + param1 + "," + param2);
                break;
        }

        try {
            itemMeta.getPersistentDataContainer().set(itemTypeIDNS, PersistentDataType.STRING, "opitems_" + id);
            itemMeta.getPersistentDataContainer().set(itemTypeVL, PersistentDataType.STRING, "opitems_" + GlobalVars.itemVersionLevel);

            itemMeta.getPersistentDataContainer().set(NameSpaces.opitemsMarker, PersistentDataType.STRING, "true");
            List<String> cLore = itemMeta.getLore();

            if(cLore == null)
                cLore = new ArrayList<>();

            cLore.add("");
            cLore.add(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "OPItems");

            itemMeta.setLore(cLore);

            itemStack.setItemMeta(itemMeta);

        } catch (Exception e) {
            return itemStack;
        }
        return itemStack;
    }
}
