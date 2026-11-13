package cel20.opitems.cmd.cmd.opitems.sub.routines;

import cel20.opitems.items.managers.GiveItems;
import cel20.opitems.items.managers.abracator.StringIDAssociator;
import cel20.opitems.items.managers.abracator.TotalItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveLogic {

    public static void executeGive(CommandSender sender, String arg, String targetPlayer, String p1, String p2) {

        int n1;
        int n2;

        n1 = ((p1 == null) || !p1.isEmpty()) ? -1 : Integer.parseInt(p1);
        n2 = ((p2 == null) || !p2.isEmpty()) ? -1 : Integer.parseInt(p2);


        if (targetPlayer == null || targetPlayer.equalsIgnoreCase("")) {
            if (sender instanceof Player p) {

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
                sender.sendMessage(String.valueOf(ChatColor.DARK_RED) + ChatColor.DARK_RED + "This Command cannot be executed in the console");
            }
        } else {

            Player p = Bukkit.getPlayer(targetPlayer);


            if (p == null) {
                sender.sendMessage(ChatColor.RED + "The player " + targetPlayer + " was not found!");
                return;
            }

            if (!p.getName().equalsIgnoreCase(targetPlayer))
                p = null;

            if (p == null) {
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

    public static int recipeStringToNum(String r) {

        try {
            return Integer.parseInt(r);
        } catch (Exception ignored) {
        }

        String casedString = r.trim().toLowerCase();

        for (StringIDAssociator itemId : TotalItems.itemIds) {

            if (casedString.equalsIgnoreCase(itemId.name().replace(" ", ""))) {

                return itemId.id();

            }

        }

        return -1;

    }

}
