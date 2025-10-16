package items.managers.upgrade;

import items.managers.rawItemsGenerator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.atomic.AtomicInteger;

public class ItemUpgrader {

    public static void upgradeMainItem(Player p){


        p.sendMessage(ChatColor.GREEN + "Comparing item against database...");
        ItemStack item = p.getInventory().getItemInMainHand();

        if(item.getType() == Material.AIR){
            p.sendMessage(ChatColor.RED + "Please only hold the item in the main hand.");
            return;
        }

        if(item.getAmount() > 1){
            p.sendMessage(ChatColor.RED + "Please hold one item at a time.");
            return;
        }

        OldItemDataset.ensureCreatedDataset();

        final boolean[] hasFound = {false};
        AtomicInteger targetId = new AtomicInteger(-1);

        OldItemDataset.itemList.forEach(ic -> {


            if(!hasFound[0] && ic.doesMatch(item)){
                targetId.set(ic.id);
                hasFound[0] = true;
            }

        });

        if(hasFound[0]){
            if(p.getInventory().contains(item)){

                Inventory inv = p.getInventory();

                for (int i = 0; i < inv.getSize(); i++) {
                ItemStack inow = inv.getItem(i);
                if (inow != null && inow.equals(item)) {
                    inv.clear(i);

                    break;
                }
            }
                p.getInventory().addItem(rawItemsGenerator.getItem(targetId.get(), -5, -5));

                p.sendMessage(ChatColor.GREEN + "The item was updated. Item-ID: " + targetId.get());
            }else{
                p.sendMessage(ChatColor.RED + "The item checked for was not found in the inventory anymore");
            }




        }else{
            p.sendMessage(ChatColor.RED + "The item in the main-hand was not found in the database");
        }


    }
}
