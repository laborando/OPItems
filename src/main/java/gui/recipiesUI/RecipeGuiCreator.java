package gui.recipiesUI;

import items.NameSpaces;
import items.managers.RawItemsGenerator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class RecipeGuiCreator {

    public static void generateInventory(Player player, int page){

        Inventory gui = Bukkit.createInventory(null, 54, ChatColor.DARK_BLUE + "OPItems recipes - Page " + page);

        ItemStack is = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta im = is.getItemMeta();

        //Bottom
        im.setDisplayName(" ");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "r_gui_locked");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER, page);

        is.setItemMeta(im);

        gui.setItem(46, is);
        gui.setItem(47, is);
        gui.setItem(48, is);
        //Symmetry
        gui.setItem(50, is);
        gui.setItem(51, is);
        gui.setItem(52, is);



        //Items per se
        for (int i = 0; i < 45; i++) {

            int cItem = i + page * 45 + 1;

            ItemStack item = RawItemsGenerator.getItem(cItem, -5, -5, true);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "r_gui_locked");
            meta.getPersistentDataContainer().set(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER, page);
            meta.getPersistentDataContainer().set(NameSpaces.opitemsGuiID, PersistentDataType.INTEGER, cItem);

            item.setItemMeta(meta);

            gui.setItem(i, item);

        }


        //Close Menu
        is.setType(Material.BARRIER);
        im.setDisplayName("Close menu");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "close");
        is.setItemMeta(im);
        gui.setItem(49, is);

        //Arrows
        is.setType(Material.ARROW);
        im.setDisplayName("Previous Page");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "left");
        is.setItemMeta(im);
        gui.setItem(45, is);

        im.setDisplayName("Next Page");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "right");
        is.setItemMeta(im);
        gui.setItem(53, is);

        player.openInventory(gui);

    }

}
