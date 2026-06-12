package items.managers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GiveErrorBackgiver {

    static volatile Player player;

    public static void setPlayer(Player p) {
        player = p;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void giveLatestPlayerErrorMessageEnchError() {
        try {
            player.sendMessage(ChatColor.RED + "The item from the command you got was not (properly) enchanted due to the enchantment parameters missing.");
            player.sendMessage(ChatColor.RED + "Usage: /opitems give 'item' 'player' 'ench_lvl_primary' 'ech_lvl_secondary'");
            player.sendMessage(ChatColor.RED + "'ench_lvl_primary' 'ech_lvl_secondary' is only needed if the enchantment level is existent and variable.");
            player.sendMessage(ChatColor.RED + "They can be replaced with the value -5 to create an item with the default enactment levels.");
        } catch (Exception e) {
        }
    }

}
