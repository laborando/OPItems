package gui.itemEnableUI;

import items.NameSpaces;
import items.abracator.CItem;
import items.abracator.TotalItems;
import items.managers.RawItemsGenerator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class EnableSoloGUI {


    public static void showSoloRecipe(Player player, int id, int retPage) {


        Inventory gui = Bukkit.createInventory(null, 54, ChatColor.DARK_BLUE + "OPItems config");

        ItemStack is = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta im = is.getItemMeta();

        //Bottom
        im.setDisplayName(" ");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "e_gui_locked");

        is.setItemMeta(im);


        //Items per se
        for (int i = 0; i < 54; i++) {

            gui.setItem(i, is);

        }


        ItemStack item = RawItemsGenerator.getItem(id, -5, -5, true);
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "e_gui_locked");
        meta.getPersistentDataContainer().set(NameSpaces.opitemsGuiID, PersistentDataType.INTEGER, id);
        item.setItemMeta(meta);

        gui.setItem(19, item);

        //Close Menu
        is.setType(Material.BARRIER);
        im.setDisplayName("Close menu");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "close");
        is.setItemMeta(im);
        gui.setItem(49, is);

        //Arrows
        is.setType(Material.ARROW);
        im.setDisplayName("Return");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "left");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER, retPage + 1);
        is.setItemMeta(im);
        gui.setItem(45, is);

        im.setDisplayName("Return");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "right");
        im.getPersistentDataContainer().set(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER, retPage - 1);
        is.setItemMeta(im);
        gui.setItem(53, is);

        //Empty --------------------------------------------------------------------------------------------------------------

        ItemStack empty = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta emptyMeta = empty.getItemMeta();

        emptyMeta.setDisplayName(" ");
        emptyMeta.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "e_gui_locked");

        empty.setItemMeta(emptyMeta);

        //Recipe
        CItem cItem = TotalItems.get(id);

        if (cItem == null) {

            item.setType(Material.BARRIER);
            im.setDisplayName("There was an error fetching this recipe");
            im.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "right");
            im.getPersistentDataContainer().set(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER, retPage - 1);
            is.setItemMeta(im);
            gui.setItem(22, is);

            player.openInventory(gui);

            return;
        }

        boolean isEnabled = cItem.enabled;

        for (int i = 0; i < 9; i++) {

            Material rMaterial = cItem.materials[i];

            if (rMaterial == null) {
                gui.setItem(getIVSlot(i), empty);
                continue;
            }

            ItemStack rItem = new ItemStack(rMaterial);
            ItemMeta rMeta = rItem.getItemMeta();
            rMeta.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "e_gui_locked");
            rItem.setItemMeta(rMeta);

            gui.setItem(getIVSlot(i), rItem);


        }
        ItemStack enabledSign;
        ItemMeta enabledMeta;
        if (isEnabled) {
            enabledSign = new ItemStack(Material.GREEN_CONCRETE, 1);
            enabledMeta = enabledSign.getItemMeta();

            enabledMeta.setDisplayName(ChatColor.GREEN + "This item is enabled. Click to disable");
            enabledMeta.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "e_gui_locked");
            enabledMeta.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "disable");
            enabledMeta.getPersistentDataContainer().set(NameSpaces.opitemsGuiID, PersistentDataType.INTEGER, id);

            enabledSign.setItemMeta(enabledMeta);
        } else {
            enabledSign = new ItemStack(Material.RED_CONCRETE, 1);
            enabledMeta = enabledSign.getItemMeta();

            enabledMeta.setDisplayName(ChatColor.RED + "This item is disabled. Click to enable");
            enabledMeta.getPersistentDataContainer().set(NameSpaces.opitemsGui, PersistentDataType.STRING, "e_gui_locked");
            enabledMeta.getPersistentDataContainer().set(NameSpaces.opitemsGuiID, PersistentDataType.INTEGER, id);
            enabledMeta.getPersistentDataContainer().set(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING, "enable");

            enabledSign.setItemMeta(enabledMeta);
        }

        gui.setItem(25, enabledSign);


        player.openInventory(gui);


    }

    public static int getIVSlot(int recipeSlot) {

        return switch (recipeSlot) {
            case 0 -> 12;
            case 1 -> 13;
            case 2 -> 14;
            case 3 -> 21;
            case 4 -> 22;
            case 5 -> 23;
            case 6 -> 30;
            case 7 -> 31;
            case 8 -> 32;
            default -> 0;
        };

    }

}
