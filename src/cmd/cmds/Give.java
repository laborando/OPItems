package cmd.cmds;

import items.managers.giveItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Give {

    public static void execute(CommandSender sender, String arg, String targetPlayer) {

        if (targetPlayer == null || targetPlayer.equalsIgnoreCase("")) {
            if (sender instanceof Player) {

                final Player p = (Player) sender;
                if (arg.equalsIgnoreCase("old")) {
                    giveItems.giveItemsOld(p);
                } else {
                    try {
                        int itemNum = Integer.parseInt(arg);
                        giveItems.giveItems(p, itemNum);
                    } catch (NumberFormatException e) {
                        giveItems.giveItemsMessage(p);
                    }
                }
            } else {
                sender.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.DARK_RED).append("This Command cannot be executed in the console").toString());
            }
        }else{

            Player p = Bukkit.getPlayer(targetPlayer);

            if(sender.getName().equalsIgnoreCase(targetPlayer))
                sender.sendMessage("Info: You can give items to yourself by executing /opitems give <itemNumber>, <player> is only required when giving to other players");

            if(p == null){
                sender.sendMessage(ChatColor.RED + "The player " + targetPlayer + " was not found!");
                return;
            }

            if(!p.getName().equalsIgnoreCase(targetPlayer))
                p = null;

            if(p == null){
                sender.sendMessage(ChatColor.RED + "The player " + targetPlayer + " was not found!");
                return;
            }

            if (arg.equalsIgnoreCase("old")) {
                giveItems.giveItemsOld(p);
            } else {
                try {
                    int itemNum = Integer.parseInt(arg);
                    giveItems.giveItems(p, itemNum);
                } catch (NumberFormatException e) {
                    giveItems.giveItemsMessage(p);
                }
            }


        }




    }

}
