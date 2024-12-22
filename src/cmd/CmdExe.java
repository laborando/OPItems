package cmd;

import java.io.File;
import java.util.UUID;

import cel20.op.Test;
import items.managers.RecipeAdder;
import items.normal.cursed_sword;
import items.normal.fake_player;
import items.managers.give_items;
import items.normal.landmine;
import utis.CLogger;
import utis.Logutis;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import cel20.op.Main;
import events.mega_sponge;
import o_guis.op_gui;
import manage.Items;

import static utis.celutis.deleteDirectory;

public class CmdExe implements CommandExecutor{

    private boolean cLoggerStartingStage = false;

	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        String arg = null;
        try {
            arg = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            arg = "";
        }
        String arg2 = null;
        try {
            arg2 = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            arg2 = "";
        }
        if (label.equalsIgnoreCase("opitemsversion")) {

            sender.sendMessage(ChatColor.GOLD + "Changelog for v1.9.8(a)");
            sender.sendMessage(ChatColor.RED + "OPItems BETA Version!");
            sender.sendMessage(ChatColor.GOLD + "");
            sender.sendMessage(ChatColor.GOLD + "Used API: craftbukkit-1.16.5");
            sender.sendMessage(ChatColor.GOLD + "Compatible Versions 1.16.x, 1.17.x, 1.18.x, 1.19.x, 1.20.1, 1.20.2, 1.20.3, 1.20.*, 1.21.1, 1.21.2, 1.21.3, 1.21.4");
            sender.sendMessage(ChatColor.GOLD + "Target Version: 1.21.4");
            sender.sendMessage(ChatColor.GOLD + "Newer Items supported Versions: 1.20+");
            sender.sendMessage(ChatColor.GOLD + "");
            sender.sendMessage(ChatColor.BLUE + "Added Items:");
            sender.sendMessage(ChatColor.YELLOW + "- Wand of Warden");
            sender.sendMessage(ChatColor.GOLD + "");
            sender.sendMessage(ChatColor.BLUE + "Changes:");
            sender.sendMessage(ChatColor.YELLOW + "- Readded /give command");
            sender.sendMessage(ChatColor.YELLOW + "- Restructured the plugin");
            sender.sendMessage(ChatColor.YELLOW + "- Added Error handler for recipes");
            sender.sendMessage(ChatColor.GOLD + "");
            sender.sendMessage(ChatColor.BLUE + "Fixed Bugs:");
            sender.sendMessage(ChatColor.YELLOW + "- Landmines within unloaded worlds deleting its data when restarting");
            sender.sendMessage(ChatColor.YELLOW + "- Private Pocket Dimension not unloading properly when quitting");
            sender.sendMessage(ChatColor.YELLOW + "- Portal2Go going from nether to the overworld");
            sender.sendMessage(ChatColor.YELLOW + "- Private Dimensions using false generators because of automatic world reloading");
            sender.sendMessage(ChatColor.YELLOW + "- Private Dimensions Wand teleporting to false Y-Coords");
            sender.sendMessage(ChatColor.GOLD + "");
            sender.sendMessage(ChatColor.BLUE + "Other");
            sender.sendMessage(ChatColor.YELLOW + "- The Sourcecode is now available on GitHub");

        }
        if (label.equalsIgnoreCase("items")) {
            if (sender.isOp()) {
                if (arg.equalsIgnoreCase("remove")) {
                    final Items items = new Items();
                    Bukkit.broadcastMessage(new StringBuilder().append(ChatColor.BOLD).append(ChatColor.RED).append("All Items will be removed in 10 sec.!").toString());
                    Bukkit.getScheduler().runTaskLater((Plugin) Main.getPluginInstance(), () -> items.removeItems(), 200L);
                }
                if (arg.equalsIgnoreCase("player_heap")) {
                    final Items items = new Items();
                    items.ItemsPlayerHeap();
                }
                if (arg.equalsIgnoreCase("remove_now")) {
                    final Items items = new Items();
                    items.removeItems();
                }

            } else {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
            }


        }
        if (label.equalsIgnoreCase("opitemshelp")) {
            if (sender.isOp()) {
                sender.sendMessage(ChatColor.GOLD + "OPItems by Cel20");
                sender.sendMessage(ChatColor.GOLD + "This Plugin can be configurated in the /plugins/opitems/plugin.yml file");
                sender.sendMessage(ChatColor.GOLD + "Important Commands: ");
                sender.sendMessage(ChatColor.GOLD + "/opitems recipes | Gives you a link to the recipes");
                sender.sendMessage(ChatColor.GOLD + "/opitems gui | opens the GUI of OPItems");
                sender.sendMessage(ChatColor.GOLD + "/opitems help | displays this message");
                sender.sendMessage(ChatColor.GOLD + "/opitemsversion | displays the current Version and Changelog");
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
            }
        }
        if (label.equalsIgnoreCase("updateopitems")) {
            if (sender.isOp()) {
                sender.sendMessage(ChatColor.GOLD + "Trying to Update OPItems");


                Main.executeUpdate(sender);


            } else {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
            }
        }
        if (label.equalsIgnoreCase("opitems")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "No Subcommand! Please write /opitems <help | give | gui | update>");
                return true;
            }

            if (arg.equalsIgnoreCase("test")) {
                if (sender.isOp()) {
                    Test.runCurrentTest((Player) sender);
                }
            }

            if (arg.equalsIgnoreCase("give")) {
                if (sender.isOp()) {

                    if (sender instanceof Player) {


                        final Player p = (Player) sender;

                        if (arg2.equalsIgnoreCase("old")) {
                            give_items.giveItemsOld(p);
                        }else{
                            try {
                                int itemNum = Integer.parseInt(arg2);
                                give_items.giveItems(p, itemNum);
                            } catch (NumberFormatException e) {
                                give_items.giveItemsMessage(p);
                            }

                        }



                    } else {
                        sender.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.DARK_RED).append("This Command cannot be executed in the console").toString());
                    }
                } else {
                    sender.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.DARK_RED).append("YOU DON'T HAVE THE PERMISSION TO PERFORM THIS COMMAND").toString());
                }
            }
            //cancel_automated_item_removal
            else if (arg.equalsIgnoreCase("cancel_automated_item_removal")) {
                if (sender.isOp()) {
                    manage.AutoItems.cancelAutomatedItemRemoval();
                    sender.sendMessage(ChatColor.GOLD + "Automated Item Removal Cancelled!");
                } else {
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have the permission to execute this command!");
                }
            } else if (arg.equalsIgnoreCase("skull")) {
                arg2 = null;
                try {
                    arg2 = args[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    arg2 = "";
                }
                if (!(sender.isOp())) {
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have the permission to execute this command!");
                } else if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.GOLD + "This command cannot be executed in the console!");
                } else if (arg2 == "" | arg2 == null) {
                    sender.sendMessage(ChatColor.RED + "Usage: /opitems skull <player_name>");
                } else {
                    Player p = (Player) sender;
                    p.getInventory().addItem(utis.celutis.getSkullbyName(arg2));
                    sender.sendMessage(ChatColor.GOLD + "Operation Executed!");
                }


            } else if (arg.equalsIgnoreCase("playerspawntest")) {
                if (sender instanceof Player) {
                    if (sender.isOp() && sender instanceof Player) {
                        final Player p = (Player) sender;
                        final String angst = "temp";
                        try {
                            fake_player fp = new fake_player((WorldServer) p.getWorld(), new GameProfile(UUID.randomUUID(), "test"), p.getLocation());
                            fp.spawn();
                        } catch (Error e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.DARK_RED).append("You don't have the permission to perform this command!").toString());
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "This Command cannot be executed in the console");
                }
            } else if (arg.equalsIgnoreCase("gui")) {
                if (sender instanceof Player) {
                    if (sender.isOp()) {
                        op_gui.openOpitemsGui((Player) sender);
                    } else {
                        sender.sendMessage(new StringBuilder().append(ChatColor.DARK_RED).append(ChatColor.DARK_RED).append("You don't have the permission to perform this command!").toString());
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "This Command cannot be executed in the console");
                }
            } else if (arg.equalsIgnoreCase("help")) {
                if (sender instanceof Player) {
                    ((Player) sender).chat("/opitemshelp");
                }else{
                    sender.sendMessage(ChatColor.RED + "This command is currently not available int the console! Please use: /opitemshelp");
                }
            } else if (arg.equalsIgnoreCase("version")) {
                if (sender instanceof Player){
                    ((Player) sender).chat("/opitemsversion");
                }else{
                    sender.sendMessage(ChatColor.RED + "This command is currently not available int the console! Please use: /opitemsversion");
                }

            } else if (arg.equalsIgnoreCase("update")) {
                if (sender.isOp()) {
                    sender.sendMessage(ChatColor.GOLD + "Trying to Update OPItems");
                    Main.executeUpdate(sender);
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
                }

            } else if (arg.equalsIgnoreCase("super_sponge")) {
                if (sender instanceof Player) {
                    if (sender.isOp()) {
                        final Player p = (Player) sender;
                        final Block block = p.getLocation().getBlock();
                        mega_sponge.run_sponge(block);
                    } else {
                        sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "This Command cannot be executed in the Console!");
                }
            } else if (arg.equalsIgnoreCase("reset_cursed_sword_list")) {
                if (sender.isOp()) {
                    cursed_sword.resetList();
                }else{
                    sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                }
            } else if (arg.equalsIgnoreCase("display_sword_list")) {
                if (sender.isOp()) {
                    cursed_sword.sendMsgList(sender);
                }else{
                sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
            }
            } else if (arg.equalsIgnoreCase("set_gliding")) {
                if (sender.isOp()) {

                    if(!(sender instanceof Player)){
                        sender.sendMessage(ChatColor.RED + "You are not a Player!");
                        return false;
                    }

                    Player p = (Player) sender;

                    p.setGliding(true);



                }else{
                    sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                }
            } else if (arg.equalsIgnoreCase("reset_landmines")) {
                if (sender.isOp()) {
                    landmine.reset();
                    sender.sendMessage(ChatColor.GOLD + "Operation Executed!");
                }else{
                    sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                }
            }

            //LOGGER
            else if (arg.equalsIgnoreCase("report")) {

                if (!(sender.isOp())) {
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have the permission to execute this command!");
                }else{
                    if(!(CLogger.isEnabled())){

                            sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "CLogger is not enabled! Starting CLogger... Execute the command again to generate the report!");
                            CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);



                    }else{
                        Logutis.createReportAndLog();
                        sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Report generated!");
                    }
                }
            }

            //DELETE WORLD

            else if (arg.equalsIgnoreCase("delete_all_pocket_worlds")) {

                if (!(sender.isOp())) {
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have the permission to execute this command!");
                } else if (!(arg2.contains("confirm"))) {
                    sender.sendMessage(ChatColor.RED + "Confirm deletion? -> /opitems delete_pocket_world confirm");
                    sender.sendMessage(ChatColor.RED + "This deletes all worlds that contain 'pocket-world-' in their name!");
                } else {
                    for (World world : Bukkit.getWorlds()) {
                        if (world.getName().contains("pocket-world-")) {
                            World worldtodelete = world;
                            File folder = worldtodelete.getWorldFolder();
                            Bukkit.getServer().unloadWorld(worldtodelete, false);
                            deleteDirectory(folder);
                        }
                    }
                    sender.sendMessage(ChatColor.GOLD + "Operation Executed!");
                }


            } else if (arg.equalsIgnoreCase("unload_world")) {
                arg2 = null;
                try {
                    arg2 = args[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    arg2 = "";
                }
                if (!(sender.isOp())) {
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have the permission to execute this command!");
                } else {
                    Bukkit.getServer().unloadWorld(arg2, false);
                    sender.sendMessage(ChatColor.GOLD + "Operation Executed!");
                }
            }









        //RECIPIES
            else if (arg.equalsIgnoreCase("recipes")) {
            	sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Recipes for the items: https://legacy.curseforge.com/minecraft/bukkit-plugins/opitems/screenshots");
            }else if (arg.equalsIgnoreCase("remove_recipes")) {
            	if (sender.isOp()) {
            	RecipeAdder.removeRecipe();
            	sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "All Recipes Removed. Restart the Server to re-add them.");
            	}
            	}else if (arg.equalsIgnoreCase("remove_recipes_all")) {
                	if (sender.isOp()) {
                    	sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "All Recipes Removed. Restart the Server to re-add them.");
                    	}
                    	}
            
            //


            else {
                sender.sendMessage(ChatColor.RED + "Subcommand not Found! /opitems <give | gui | help | update | skull>");
            }
        }
        return false;
    }

}
