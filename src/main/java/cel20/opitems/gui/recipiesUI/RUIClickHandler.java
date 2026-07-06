package cel20.opitems.gui.recipiesUI;

import cel20.opitems.items.NameSpaces;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class RUIClickHandler {
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
        if (abl != null && abl.contains("r_gui_locked")) {

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

                    RecipeGuiCreator.generateInventory(player, targetPageRight);

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

                    RecipeGuiCreator.generateInventory(player, targetPageLeft);
                    return;

                case "close":
                    player.closeInventory();
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

            player.closeInventory();
            int toPage = 0;

            try {
                toPage = container.get(NameSpaces.opitemsGuiPage, PersistentDataType.INTEGER);
            } catch (Exception ignored) {
            }


            RecipeSoloGUI.showSoloRecipe(player, id, toPage);


        }

    }
}
