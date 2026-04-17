
package items.managers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

public class giveItems
{

    public static void giveItemsMessage(final Player player) {

        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Missing argument: /opitems give <itemNumber> <targetPlayer>");
    }

    public static void giveItems(final Player player, int itemNum, int p1, int p2) {

        try {

            GiveErrorBackgiver.setPlayer(player);
            player.getInventory().addItem(RawItemsGenerator.getItem(itemNum, p1, p2));


        } catch (Exception e) {

            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Command execution failed!");
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "The given number does not represent an OPItem / The OPItems with the corresponding number has been disabled");
        }


    }

}
