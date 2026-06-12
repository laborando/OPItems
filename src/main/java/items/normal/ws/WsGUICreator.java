package items.normal.ws;

import items.NameSpaces;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class WsGUICreator {
    public static void showWSMenu(final Player p) {
        final Inventory gui = Bukkit.createInventory(null, 9, new StringBuilder().append(ChatColor.DARK_BLUE).append("Workstation").toString());

        ItemStack is = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta im = is.getItemMeta();

        //Nonused Slots
        im.setDisplayName(ChatColor.BOLD + "");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "ws_locked");

        is.setItemMeta(im);

        gui.setItem(0, is);
        gui.setItem(8, is);

        //Close Menu
        is.setType(Material.BARRIER);
        im.setDisplayName("Close menu");
        is.setItemMeta(im);
        gui.setItem(4, is);

        //Close Menu
        is.setType(Material.CRAFTING_TABLE);
        im.setDisplayName(ChatColor.RESET + "Open crafting Table");
        is.setItemMeta(im);
        gui.setItem(1, is);

        //Close Menu
        is.setType(Material.STONECUTTER);
        im.setDisplayName(ChatColor.RESET + "Open stonecutter");
        is.setItemMeta(im);
        gui.setItem(2, is);

        //Close Menu
        is.setType(Material.ANVIL);
        im.setDisplayName(ChatColor.RESET + "Open anvil");
        is.setItemMeta(im);
        gui.setItem(3, is);

        //Close Menu
        is.setType(Material.LOOM);
        im.setDisplayName(ChatColor.RESET + "Open loom");
        is.setItemMeta(im);
        gui.setItem(5, is);

        //Close Menu
        is.setType(Material.SMITHING_TABLE);
        im.setDisplayName(ChatColor.RESET + "Open smithing table");
        is.setItemMeta(im);
        gui.setItem(6, is);

        //Close Menu
        is.setType(Material.CARTOGRAPHY_TABLE);
        im.setDisplayName(ChatColor.RESET + "Open cartography table");
        is.setItemMeta(im);
        gui.setItem(7, is);


        p.openInventory(gui);
    }
}
