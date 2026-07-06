package cel20.opitems.gui.itemEnableUI;

import cel20.opitems.items.NameSpaces;
import cel20.opitems.items.abracator.TotalItems;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class EnableClickHandler {
    public static void onInventoryClick(InventoryClickEvent event) {

        final HumanEntity entity = event.getWhoClicked();
        final ItemStack item = event.getCurrentItem();


        if (item == null) return;
        if (item.isEmpty()) return;

        ItemMeta meta = item.getItemMeta();

        if (meta == null)
            return;

        PersistentDataContainer container = meta.getPersistentDataContainer();

        String abl = container.get(NameSpaces.opitemsGui, PersistentDataType.STRING);
        if (abl != null && abl.contains("e_gui_locked")) {

            event.setCancelled(true);

            if (!(entity instanceof Player player))
                return;


            String function = container.get(NameSpaces.opitemsGuiFunction, PersistentDataType.STRING);

            if (function == null)
                function = "nothing";

            switch (function) {
                case "right":
                    player.closeInventory();

                    int targetPageRight = 1;

                    try {
                        targetPageRight += container.get(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER);
                    } catch (Exception e) {
                        targetPageRight = 0;
                    }

                    EnableGuiCreator.generateInventory(player, targetPageRight);

                    return;
                case "left":
                    player.closeInventory();
                    int targetPageLeft = -1;

                    try {
                        targetPageLeft += container.get(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER);
                    } catch (Exception e) {
                        targetPageLeft = 0;
                    }

                    if (targetPageLeft < 0)
                        targetPageLeft = 0;

                    EnableGuiCreator.generateInventory(player, targetPageLeft);
                    return;

                case "close":

                    player.closeInventory();
                    return;

                case "enable":

                    int toEnable = -1;

                    try {
                        toEnable = container.get(NameSpaces.opitemsGuiID, PersistentDataType.INTEGER);
                    } catch (Exception ignored) {
                    }

                    TotalItems.enable(toEnable);

                    player.closeInventory();
                    EnableSoloGUI.showSoloRecipe(player, toEnable, 0);

                    return;

                case "disable":

                    int toDisable = -1;

                    try {
                        toDisable = container.get(NameSpaces.opitemsGuiID, PersistentDataType.INTEGER);
                    } catch (Exception ignored) {
                    }

                    TotalItems.disable(toDisable);

                    player.closeInventory();
                    EnableSoloGUI.showSoloRecipe(player, toDisable, 0);
                    return;

            }


            int id = -1;


            try {
                id = container.get(NameSpaces.opitemsGuiID, PersistentDataType.INTEGER);
            } catch (Exception ignored) {
            }

            if (id == -1)
                return;

            if (item.getType() == Material.LIGHT_GRAY_STAINED_GLASS_PANE)
                return;

            if (item.getType() == Material.GRAY_STAINED_GLASS_PANE)
                return;

            if (item.getType() == Material.GREEN_CONCRETE)
                return;

            if (item.getType() == Material.RED_CONCRETE)
                return;

            player.closeInventory();
            int toPage = 0;

            try {
                toPage = container.get(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER);
            } catch (Exception ignored) {
            }


            EnableSoloGUI.showSoloRecipe(player, id, toPage);


        }

    }
}
