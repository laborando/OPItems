package cel20.op.load;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import utis.Updater;

public class UpdateHandler {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void handleStartupUpdater(Main m)
    {
        try {
            Bukkit.getLogger().info("[OPItems]Looking for Updates");
            final Updater updater = new Updater(m, 443495, m.getFileNonProt(), Updater.UpdateType.NO_DOWNLOAD, true);
            Bukkit.getLogger().info("Name: " + updater.getLatestName());
            Bukkit.getLogger().info("Result: " + updater.getResult());
            Bukkit.getLogger().info("Update Type: " + updater.getLatestType());
            if (updater.getResult() == Updater.UpdateResult.UPDATE_AVAILABLE) {
                Main.update = 1;
            }else if (updater.getResult() == Updater.UpdateResult.FAIL_BADID) {
                Bukkit.getLogger().severe("[OPItems] There was an error looking for an update, if m isn't only temporary, look for updates yourself around every month. ");
            }

            if (Main.update == 1) {
                Bukkit.getLogger().warning(ANSI_RED + "IMPORTANT" + ANSI_RESET);
                if (updater.getLatestType() == Updater.ReleaseType.RELEASE) {
                    Bukkit.getLogger().info(ANSI_YELLOW + "A new Update for OPItems has been found. Please update with /opitems update" + ANSI_RESET);
                }else if (updater.getLatestType() == Updater.ReleaseType.BETA) {
                    Bukkit.getLogger().info(ANSI_YELLOW + "A new Update for OPItems has been found. The update is in the BETA stage it might be a bit more unstable! If you want to update, do it with /opitems update" + ANSI_RESET);
                }else if (updater.getLatestType() == Updater.ReleaseType.ALPHA) {
                    Bukkit.getLogger().info(ANSI_YELLOW + "A new Update for OPItems has been found. The update is in the ALPHA stage! If you want to update, do it with /opitems update" + ANSI_RESET);
                }
                Main.update_type = updater.getLatestType();
            }

        }catch (java.lang.IllegalStateException ignored){}
        
        
    }

    public static void executeUpdate(CommandSender sender, Main p) {

        Updater updater;
        updater = new Updater(p, 443495, p.getFileNonProt(), Updater.UpdateType.DEFAULT, true);

        if (updater.getResult() == Updater.UpdateResult.SUCCESS) {
            Main.update = 0;
            sender.sendMessage(ChatColor.GOLD + "OPItems has been Updated. Please restart your server to activate the Update.");
        }
        else if (updater.getResult() == Updater.UpdateResult.NO_UPDATE) {
            sender.sendMessage(ChatColor.GOLD + "OPItems is running the newest Version");
        }
        else {
            sender.sendMessage(String.valueOf(ChatColor.RED) + ChatColor.BOLD + "UPDATE FAILED:");
            sender.sendMessage(String.valueOf(ChatColor.RED) + ChatColor.BOLD + "OPItems Failed to Update. Error:");
            sender.sendMessage(updater.getResult().toString());
        }
    }
    
}
