package cel20.opitems.items.managers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GiveItems {

    /**
     * Sends player p a missing argument messsage for /opitems give
     */
    public static void giveItemsMessage(final Player player) {

        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Missing argument: /opitems give <itemNumber> <targetPlayer>");
    }

    /**
     * Gives player p an OPItem with
     */
    public static void giveItems(final Player player, int itemNum, int ench1, int ench2) {

        try {

            GiveErrorBackgiver.setPlayer(player);
            player.getInventory().addItem(RawItemsGenerator.getItem(itemNum, ench1, ench2));


        } catch (Exception e) {

            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Command execution failed!");
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "The given number does not represent an OPItem / The OPItems with the corresponding number has been disabled");
        }


    }

}
