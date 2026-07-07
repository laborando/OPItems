package cel20.opitems.items.managers.upgrade;

import cel20.opitems.op.GlobalVars;
import cel20.opitems.items.managers.RawItemsGenerator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for upgrading old versions of OPItems
 */
public class ItemUpgrader {

    /**
     * Upgrades the item in p's main-hand
     * @param p Target Player
     */
    public static void upgradeItem(Player p) {

        if(!GlobalVars.canUpgradeItems){
            p.sendMessage(ChatColor.RED + "Item upgrading has been disabled.");
            return;
        }

        ItemStack item = p.getInventory().getItemInMainHand();

        if (item.getType() == Material.AIR) {
            p.sendMessage(ChatColor.RED + "The target item has to be selected.");
            return;
        }

        if (item.getAmount() > 1) {
            p.sendMessage(ChatColor.RED + "Please hold only one item at a time.");
            return;
        }

        p.sendMessage(ChatColor.GREEN + "Comparing selected item against database...");

        OldItemDataset.ensureCreatedDataset();

        final boolean[] hasFound = {false};
        AtomicInteger targetId = new AtomicInteger(-1);

        OldItemDataset.itemList.forEach(ic -> {

            if (!hasFound[0] && ic.doesMatch(item)) {
                targetId.set(ic.id);
                hasFound[0] = true;
            }

        });

        if (hasFound[0]) {
            if (p.getInventory().contains(item)) {

                Inventory inv = p.getInventory();

                for (int i = 0; i < inv.getSize(); i++) {
                    ItemStack inow = inv.getItem(i);
                    if (inow != null && inow.equals(item)) {
                        inv.clear(i);

                        break;
                    }
                }
                p.getInventory().addItem(RawItemsGenerator.getItem(targetId.get(), -5, -5));

                p.sendMessage(ChatColor.GREEN + "The item was updated. Item-ID: " + targetId.get());
            } else {
                p.sendMessage(ChatColor.RED + "The item checked for was not found in the inventory anymore");
            }


        } else {
            p.sendMessage(ChatColor.RED + "The item in the main-hand was not found in the database");
        }


    }
}
