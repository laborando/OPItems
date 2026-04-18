package cmd;

import cel20.op.Main;
import cel20.op.Test;
import cmd.cmds.Give;
import cmd.cmds.Help;
import cmd.cmds.Recipe;
import cmd.cmds.Version;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import items.classic.Sponges.SuperSponge;
import items.managers.RecipeAdder;
import items.managers.upgrade.ItemUpgrader;
import items.normal.CursedSword;
import items.normal.Landmine;
import manage.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;
import utis.CLogger;
import utis.Celutis;
import utis.Logutis;

import java.io.File;
import java.util.Collection;

import static utis.Celutis.deleteDirectory;

public class CmdExe {


    public static void execute(String label, @NotNull CommandSourceStack commandSourceStack, @NonNull @NotNull String[] args) {

        CommandSender sender = commandSourceStack.getSender();

        String arg;
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
        String arg3 = null;
        try {
            arg3 = args[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            arg3 = "";
        }
        String arg4 = null;
        try {
            arg4 = args[3];
        } catch (ArrayIndexOutOfBoundsException e) {
            arg4 = "";
        }
        String arg5 = null;
        try {
            arg5 = args[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            arg5 = "";
        }
        if (label.equalsIgnoreCase("items")) {
            if (sender.isOp()) {
                if (arg.equalsIgnoreCase("remove")) {
                    final Items items = new Items();
                    Bukkit.broadcastMessage(new StringBuilder().append(ChatColor.BOLD).append(ChatColor.RED).append("All Items will be removed in 10 sec.!").toString());
                    Bukkit.getScheduler().runTaskLater((Plugin) Main.getPluginInstance(), () -> items.removeItems(), 200L);
                }
                if (arg.equalsIgnoreCase("player_heap")) {
                    sender.sendMessage("Per-player item count:");
                    final Items items = new Items();
                    items.ItemsPlayerHeap();
                }
                if (arg.equalsIgnoreCase("remove_now")) {
                    sender.sendMessage("Loaded items are being removed...");
                    final Items items = new Items();
                    items.removeItems();
                }

                sender.sendMessage("Subcommand not found / not given!");

            } else {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
            }


        }
        if (label.equalsIgnoreCase("opitems")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "No Subcommand! Execute '/opitems help' for a list of available subcommands");
            }

            if (arg.equalsIgnoreCase("test")) {
                if (sender.isOp()) {
                    Test.runCurrentTest((Player) sender);
                }
            }

            if (arg.equalsIgnoreCase("upgradeItems")) {
                if (sender instanceof Player)
                    ItemUpgrader.upgradeMainItem((Player) sender);
            } else


            if (arg.equalsIgnoreCase("give")) {
                if (sender.isOp()) {

                    Give.execute(sender, arg2, arg3, arg4, arg5);

                } else {
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have the permission to execute this command!");
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
                    p.getInventory().addItem(Celutis.getSkullbyName(arg2));
                    sender.sendMessage(ChatColor.GOLD + "Operation Executed!");
                }


            } else if (arg.equalsIgnoreCase("help")) {
                Help.execute(sender);
            }
            else if (arg.equalsIgnoreCase("version")) {
                Version.execute(sender);
            } else if (arg.equalsIgnoreCase("update")) {
                if (sender.isOp()) {
                    Main.executeUpdate(sender);
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have the permission to perform this command!");
                }

            } else if (arg.equalsIgnoreCase("super_sponge")) {
                if (sender instanceof Player) {
                    if (sender.isOp()) {
                        final Player p = (Player) sender;
                        final Block block = p.getLocation().getBlock();
                        SuperSponge.run_sponge(block);
                    } else {
                        sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "This Command cannot be executed in the Console!");
                }
            } else if (arg.equalsIgnoreCase("reset_cursed_sword_list")) {
                if (sender.isOp()) {
                    CursedSword.resetList();
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                }
            } else if (arg.equalsIgnoreCase("display_sword_list")) {
                if (sender.isOp()) {
                    CursedSword.sendMsgList(sender);
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                }
            } else if (arg.equalsIgnoreCase("set_gliding")) {
                if (sender.isOp()) {

                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.RED + "You are not a Player!");
                    }

                    Player p = (Player) sender;

                    p.setGliding(true);


                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                }
            } else if (arg.equalsIgnoreCase("reset_landmines")) {
                if (sender.isOp()) {
                    Landmine.reset();
                    sender.sendMessage(ChatColor.GOLD + "Operation Executed!");
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have the Permission to perform this command!");
                }
            }

            //LOGGER
            else if (arg.equalsIgnoreCase("report")) {

                if (!(sender.isOp())) {
                    sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "You don't have the permission to execute this command!");
                } else {
                    if (!(CLogger.isEnabled())) {

                        sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "CLogger is not enabled! Starting CLogger... Execute the command again to generate the report!");
                        CLogger.startSynced(Main.getPluginInstance().getDataFolder().toString(), 60);


                    } else {
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

                Recipe.execute(sender);

            } else if (arg.equalsIgnoreCase("remove_recipes")) {
                if (sender.isOp()) {
                    RecipeAdder.removeRecipes();
                    sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "All Recipes Removed. Restart the Server to re-add them.");
                }
            } else if (arg.equalsIgnoreCase("remove_recipes_all")) {
                if (sender.isOp()) {
                    sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "All Recipes Removed. Restart the Server to re-add them.");
                }
            }

            //


            else {
                sender.sendMessage(ChatColor.RED + "Subcommand not found! Execute '/opitems help' for a list of available subcommands");
            }
        }
    }
}
