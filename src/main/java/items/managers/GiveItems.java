
package items.managers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GiveItems
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
