package cmd.cmds;

import items.abracator.StringIDAssociator;
import items.abracator.TotalItems;
import items.managers.GiveItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Give {

    public static void execute(CommandSender sender, String arg, String targetPlayer, String p1, String p2) {

        int n1 = -1;
        int n2 = -1;

        n1 = ((p1 == null) || !p1.isEmpty()) ? Integer.parseInt(p1) : -1;
        n2 = ((p2 == null) || !p2.isEmpty()) ? Integer.parseInt(p2) : -1;


        if (targetPlayer == null || targetPlayer.equalsIgnoreCase("")) {
            if (sender instanceof Player) {

                final Player p = (Player) sender;
                if (arg.equalsIgnoreCase("old")) {

                    sender.sendMessage("This feature has been deprecated.");

                } else {
                    try {
                        GiveItems.giveItems(p, recipeStringToNum(arg), n1, n2);
                    } catch (NumberFormatException e) {
                        GiveItems.giveItemsMessage(p);
                    }
                }
            } else {
                sender.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.DARK_RED).append("This Command cannot be executed in the console").toString());
            }
        }else{

            Player p = Bukkit.getPlayer(targetPlayer);

            /*
            if(sender.getName().equalsIgnoreCase(targetPlayer))
                sender.sendMessage("Info: You can give items to yourself by executing /opitems give <itemNumber>, <player> is only required when giving to other players");
            */


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

                sender.sendMessage("This feature has been deprecated.");

            } else {
                try {

                    GiveItems.giveItems(p, recipeStringToNum(arg), n1, n2);
                } catch (NumberFormatException e) {
                    GiveItems.giveItemsMessage(p);
                }
            }


        }




    }

    public static int recipeStringToNum(String r){

        try {
            return Integer.parseInt(r);
        }catch (Exception awwwNoInteger){}

        String casedString = r.trim().toLowerCase();

        for (StringIDAssociator itemId : TotalItems.itemIds) {

            if (casedString.equalsIgnoreCase(itemId.name.replace(" ", ""))) {

                return itemId.id;

            }

        }

        return -1;

    }

}
