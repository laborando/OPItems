
package items.managers;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class give_items
{

    public static void giveItemsMessage(final Player player) {

        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Missing argument: /opitems give <itemNumber> ");
    }

    public static void giveItems(final Player player, int itemNum) {

        try {
            final NamespacedKey key = new NamespacedKey(Main.getPluginInstance(), "opitems_desc_" + itemNum);

            player.getInventory().addItem(Bukkit.getRecipe(key).getResult());
        } catch (Exception e) {

            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Command execution failed!");
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "The given number does not represent an OPItem / The OPItems with the corresponding number has been disabled");
        }


    }
    public static void giveItemsOld(final Player player){


        final ItemStack nv = new ItemStack(Material.IRON_HELMET, 1);
        final ItemMeta iM = nv.getItemMeta();
        iM.setDisplayName(ChatColor.BOLD + "Night Visor");
        iM.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.ARROW_DAMAGE);
        nv.setType(Material.LEATHER_BOOTS);
        iM.setDisplayName(ChatColor.BOLD + "Fire Shoes");
        iM.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.ARROW_DAMAGE);
        nv.setType(Material.SPONGE);
        iM.setDisplayName(ChatColor.BOLD + "Super Sponge");
        iM.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.ARROW_DAMAGE);
        nv.setType(Material.SPONGE);
        iM.setDisplayName(ChatColor.BOLD + "Lava Sponge");
        iM.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.ARROW_FIRE);
        nv.setType(Material.FLINT);
        iM.setDisplayName(ChatColor.BOLD + "Trough Wallers");
        iM.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.ARROW_DAMAGE);
        nv.setType(Material.IRON_LEGGINGS);
        iM.setDisplayName(ChatColor.BOLD + "Legging of Speed");
        iM.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.ARROW_DAMAGE);
        nv.setType(Material.BLAZE_ROD);
        iM.setDisplayName(ChatColor.BOLD + "Wand of Invisibility");
        iM.addEnchant(Enchantment.DIG_SPEED, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.DIG_SPEED);
        nv.setType(Material.FEATHER);
        iM.setDisplayName(ChatColor.BOLD + "Launcher");
        iM.addEnchant(Enchantment.SOUL_SPEED, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.SOUL_SPEED);
        nv.setType(Material.BLAZE_ROD);
        iM.addEnchant(Enchantment.CHANNELING, 10, true);
        iM.setDisplayName(ChatColor.BOLD + "Wand of Boom");
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.CHANNELING);
        nv.setType(Material.BLAZE_ROD);
        iM.addEnchant(Enchantment.LUCK, 10, true);
        iM.setDisplayName(ChatColor.BOLD + "Wand of Massive Boom");
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        iM.removeEnchant(Enchantment.LUCK);
        nv.setType(Material.IRON_HELMET);
        iM.setDisplayName(ChatColor.BOLD + "Water Helmet");
        iM.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        nv.setItemMeta(iM);
        player.getInventory().addItem(new ItemStack[] { nv });
        final ItemStack i = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = i.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "FlyFeather");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        i.setItemMeta(itemMeta);
        player.getInventory().addItem(new ItemStack[] { i });
        final ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        final ItemMeta chestplatem = chestplate.getItemMeta();
        chestplatem.setDisplayName(ChatColor.BOLD + "The Anti Damage");
        chestplatem.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 75, true);
        chestplate.setItemMeta(chestplatem);
        chestplatem.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplate.setType(Material.FEATHER);
        chestplatem.setDisplayName(ChatColor.BOLD + "AntiFall");
        chestplatem.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        chestplatem.setUnbreakable(true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.ARROW_FIRE);
        chestplate.setType(Material.ARROW);
        chestplatem.setDisplayName(ChatColor.BOLD + "Bower");
        chestplatem.addEnchant(Enchantment.FROST_WALKER, 75, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.FROST_WALKER);
        chestplate.setType(Material.FISHING_ROD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Hook of Velectory");
        chestplatem.setUnbreakable(true);
        chestplatem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        chestplatem.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.ARROW_DAMAGE);
        chestplate.setType(Material.STICK);
        chestplatem.setDisplayName(ChatColor.BOLD + "Knocky the Stick");
        chestplatem.addEnchant(Enchantment.KNOCKBACK, 10, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.KNOCKBACK);
        chestplate.setType(Material.NETHERITE_SWORD);
        chestplatem.setDisplayName(ChatColor.BOLD + "The blocky Sword");
        chestplatem.addEnchant(Enchantment.DAMAGE_ALL, 75, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.DAMAGE_ALL);
        chestplate.setType(Material.BLAZE_ROD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Blazer");
        chestplatem.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.FIRE_ASPECT);
        chestplate.setType(Material.BLAZE_POWDER);
        chestplatem.setDisplayName(ChatColor.BOLD + "Boomer");
        chestplatem.addEnchant(Enchantment.FROST_WALKER, 75, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.FROST_WALKER);
        chestplate.setType(Material.NETHERITE_PICKAXE);
        chestplatem.setDisplayName(ChatColor.BOLD + "The picky Pick");
        chestplatem.addEnchant(Enchantment.DIG_SPEED, 1200, true);
        chestplatem.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.DIG_SPEED);
        chestplatem.removeEnchant(Enchantment.LOOT_BONUS_BLOCKS);
        chestplate.setType(Material.COOKED_PORKCHOP);
        chestplatem.setDisplayName(ChatColor.BOLD + "Pig Cannon");
        chestplatem.addEnchant(Enchantment.FIRE_ASPECT, 75, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.FIRE_ASPECT);
        chestplatem.removeEnchant(Enchantment.DAMAGE_ALL);
        chestplate.setType(Material.NETHERITE_SWORD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Endsword");
        chestplatem.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        chestplatem.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.ARROW_DAMAGE);
        chestplatem.removeEnchant(Enchantment.DAMAGE_ALL);
        chestplate.setType(Material.PRISMARINE_SHARD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Blitzer");
        chestplatem.addEnchant(Enchantment.OXYGEN, 10, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.OXYGEN);
        chestplate.setType(Material.CRAFTING_TABLE);
        chestplatem.setDisplayName(ChatColor.BOLD + "Crafter");
        chestplatem.addEnchant(Enchantment.PIERCING, 10, true);
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.PIERCING);
        chestplate.setType(Material.NETHERITE_SWORD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Enderpearler");
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplate.setType(Material.BLAZE_ROD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Tnt Detonator");
        chestplatem.addEnchant(Enchantment.DEPTH_STRIDER, 75, true);
        chestplatem.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        chestplatem.addEnchant(Enchantment.FROST_WALKER, 75, true);
        chestplatem.addEnchant(Enchantment.ARROW_DAMAGE, 75, true);
        chestplatem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.DEPTH_STRIDER);
        chestplatem.removeEnchant(Enchantment.ARROW_INFINITE);
        chestplatem.removeEnchant(Enchantment.FROST_WALKER);
        chestplatem.removeEnchant(Enchantment.ARROW_DAMAGE);
        chestplate.setType(Material.BLAZE_ROD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Private Pocket Dimension Wand");
        chestplatem.addEnchant(Enchantment.DEPTH_STRIDER, 75, true);
        chestplatem.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        chestplatem.addEnchant(Enchantment.FROST_WALKER, 75, true);
        chestplatem.addEnchant(Enchantment.PROTECTION_FALL, 75, true);
        chestplatem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        chestplatem.removeEnchant(Enchantment.DEPTH_STRIDER);
        chestplatem.removeEnchant(Enchantment.ARROW_INFINITE);
        chestplatem.removeEnchant(Enchantment.FROST_WALKER);
        chestplatem.removeEnchant(Enchantment.PROTECTION_FALL);
        chestplate.setType(Material.NETHERITE_HELMET);
        chestplatem.setDisplayName(ChatColor.BOLD + "Anti Explosion");
        chestplatem.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 75, true);
        chestplatem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });
        

        itemMeta.setDisplayName(ChatColor.BOLD + "Cursed Sword");
        itemMeta.addEnchant(Enchantment.OXYGEN, 75, true);
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        itemMeta.addEnchant(Enchantment.DURABILITY, 255, true);
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 75, true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });

        

        chestplatem.removeEnchant(Enchantment.PROTECTION_EXPLOSIONS);
        chestplate.setType(Material.NETHERITE_SWORD);
        chestplatem.setDisplayName(ChatColor.BOLD + "Cursed Sword");
        chestplatem.addEnchant(Enchantment.OXYGEN, 75, true);
        chestplatem.addEnchant(Enchantment.ARROW_INFINITE, 75, true);
        chestplatem.addEnchant(Enchantment.DURABILITY, 75, true);
        chestplatem.addEnchant(Enchantment.ARROW_DAMAGE, 75, true);
        chestplatem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        chestplate.setItemMeta(chestplatem);
        player.getInventory().addItem(new ItemStack[] { chestplate });

    }
}
