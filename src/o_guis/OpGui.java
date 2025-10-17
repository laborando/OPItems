
package o_guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OpGui
{
    public static void openOpitemsGui(final Player p) {
        final Inventory gui = Bukkit.createInventory(null, 9, new StringBuilder().append(ChatColor.BOLD).append(ChatColor.RED).append("Deprecated - OPItems GUI").toString());
        final ItemStack geti = new ItemStack(Material.GOLD_BLOCK, 1);
        final ItemMeta getit = geti.getItemMeta();
        getit.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Deprecated").toString());
        getit.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        getit.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        geti.setItemMeta(getit);
        gui.setItem(0, geti);
        final ItemStack getii = new ItemStack(Material.CRAFTING_TABLE, 1);
        final ItemMeta getitt = geti.getItemMeta();
        getitt.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Open Crafting Table").toString());
        getitt.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        getitt.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        getii.setItemMeta(getitt);
        gui.setItem(1, getii);
        final ItemStack guiglass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        final ItemMeta guiglassi = guiglass.getItemMeta();
        guiglassi.setDisplayName(new StringBuilder().append(ChatColor.GOLD).toString().toString());
        guiglassi.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        guiglassi.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        guiglassi.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        guiglass.setItemMeta(guiglassi);
        final ItemStack ophelp = new ItemStack(Material.REDSTONE_TORCH, 1);
        final ItemMeta ophelpi = ophelp.getItemMeta();
        ophelpi.setDisplayName(ChatColor.GOLD + "Click to display the OPItems-Help-Message");
        ophelpi.addEnchant(Enchantment.SOUL_SPEED, 1, true);
        ophelpi.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ophelpi.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ophelp.setItemMeta(ophelpi);

        gui.setItem(2, ophelp);
        gui.setItem(3, guiglass);
        gui.setItem(4, guiglass);
        gui.setItem(5, guiglass);
        final ItemStack id = new ItemStack(Material.REDSTONE_TORCH, 1);
        final ItemMeta al = guiglass.getItemMeta();
        al.setDisplayName(ChatColor.GOLD + "Display Changelog");
        al.addEnchant(Enchantment.WATER_WORKER, 1, true);
        al.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        al.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        id.setItemMeta(al);
        gui.setItem(6, id);
        final ItemStack i = new ItemStack(Material.REDSTONE_TORCH, 1);
        final ItemMeta it = guiglass.getItemMeta();
        it.setDisplayName(ChatColor.GOLD + "Deprecated - View Plugin Settings");
        it.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        it.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        i.setItemMeta(it);
        gui.setItem(7, i);
        final ItemStack exitb = new ItemStack(Material.BARRIER, 1);
        final ItemMeta exitbi = exitb.getItemMeta();
        exitbi.setDisplayName(new StringBuilder().append(ChatColor.BOLD).append(ChatColor.DARK_RED).append("Close Menu").toString());
        exitbi.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        exitbi.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        exitb.setItemMeta(exitbi);
        gui.setItem(8, exitb);
        p.openInventory(gui);
    }
}
