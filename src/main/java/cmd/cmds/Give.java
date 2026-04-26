package cmd.cmds;

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

        switch (casedString) {
            case "knockythestick":
                return 1;
            case "theblockysword":
                return 2;
            case "theantidamage":
                return 3;
            case "bower":
                return 4;
            case "blazer":
                return 5;
            case "boomer":
                return 6;
            case "pickypick":
                return 7;
            case "pigcannon":
                return 8;
            case "pigspawnegg":
                return 9;
            case "endsword":
                return 10;
            case "blitzer":
                return 11;
            case "crafter":
                return 12;
            case "flyfeather":
                return 13;
            case "antifall":
                return 14;
            case "hookofvelectory":
                return 15;
            case "nightvisor":
                return 16;
            case "waterhelmet":
                return 17;
            case "fireshoes":
                return 18;
            case "launcher":
                return 19;
            case "wandofboom":
                return 20;
            case "wandofmassiveboom":
                return 21;
            case "wandofinvisibility":
                return 22;
            case "speedleggings":
                return 23;
            case "supersponge":
                return 24;
            case "lavasponge":
                return 25;
            case "enderpearler":
                return 26;
            case "tntdetonator":
                return 27;
            case "cursedsword":
                return 28;
            case "pocketdimensionwand":
                return 29;
            case "antiexplosionhelmet":
                return 30;
            case "wandofhome":
                return 31;
            case "tntbow":
                return 32;
            case "wandofblocks":
                return 33;
            case "portal2go":
                return 34;
            case "skullimitator":
                return 35;
            case "landmine":
                return 36;
            case "defuser":
                return 37;
            case "infinitewaterbucket":
                return 38;
            case "protectivelytra":
                return 39;
            case "eternalsteak":
                return 40;
            case "wandofwarden":
                return 41;
            case "infiniterocket":
                return 42;
            case "piercer":
                return 43;
            case "workstation":
                return 44;
            case "strangebottle":
                return 45;


            default:
                return -1;
        }

    }

}
