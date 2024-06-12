package celutis;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Logutis {


    public static void createReportAndLog(){

        List<String> rep = new ArrayList<>();

        rep.add("Version: " + Bukkit.getVersion());
        rep.add("BukkitVersion: " + Bukkit.getBukkitVersion());
        rep.add("Scheduler: " + Bukkit.getScheduler());
        rep.add("WorldType: " + Bukkit.getWorldType());
        rep.add("ItemFactory: " + Bukkit.getItemFactory());
        rep.add("WarningState: " + Bukkit.getWarningState());
        rep.add("WorldContainer: " + Bukkit.getWorldContainer());
        rep.add("Players Connected: " + Bukkit.getOnlinePlayers().size());
        rep.add("Idle Timeout: " + Bukkit.getIdleTimeout());
        rep.add("View Distance: " + Bukkit.getViewDistance());
        rep.add("Worlds:");
        for (World world : Bukkit.getWorlds()) {
            rep.add("   - " + world.getName());
            rep.add("      -> IsAutoSave: " + world.isAutoSave());
            rep.add("      -> MaxHeight: " + world.getMaxHeight());
            rep.add("      -> Absolute World Folder: " + world.getWorldFolder().getAbsolutePath());
            rep.add("      -> Generator: " + world.getGenerator());
            rep.add("      -> UUID: " + world.getUID());
            rep.add("      -> Players: ");
            for (Player player : world.getPlayers()) {
                rep.add("           -> " + player.getName() + ";" + player.getUniqueId());
            }
            rep.add("      -> Chunks: ");
            for (Chunk c : world.getLoadedChunks()) {
                rep.add("           -> Coords:" + c.getX() + ";" + c.getZ());
                rep.add("                 -> Entity Count:" + c.getEntities().length);
                rep.add("                 -> TileEntity Count:" + c.getTileEntities().length);
            }
        }

        rep.add("Plugins:");
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            rep.add("   - " + plugin.getName());
            rep.add("      -> Enabled: " + plugin.isEnabled());
            rep.add("      -> Naggable: " + plugin.isNaggable());
            rep.add("      -> Desc: " + plugin.getDescription());
        }


        for (String s : rep) {
            CLogger.log(s);
        }
        CLogger.flushNow();

    }

}
