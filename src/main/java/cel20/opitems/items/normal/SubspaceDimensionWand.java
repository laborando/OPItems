package cel20.opitems.items.normal;

import cel20.opitems.dimensions.subspaceDimension.SubspaceDimensionChunkGenerator;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import cel20.opitems.utis.Celutis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SubspaceDimensionWand {

    static List<String> players_in_customw = new ArrayList<>();
    private static final Map<UUID, Integer> lastClickTick = new HashMap<>();

    public static void event(final PlayerChangedWorldEvent e) {
        final String wn = "subspace";

        if (e.getPlayer().getWorld().getName().equals(wn)) {
            players_in_customw.add(e.getPlayer().getUniqueId().toString());
        } else {
            players_in_customw.remove(e.getPlayer().getUniqueId().toString());
        }

    }

    public static void event(final PlayerPreLoginEvent e) {

        final String wn = "subspace";

        if (players_in_customw.contains(e.getUniqueId().toString())) {
            new WorldCreator(wn).createWorld();

            Bukkit.getServer().unloadWorld(wn, false);

            final WorldCreator wc = new WorldCreator(wn);

            wc.generator(new SubspaceDimensionChunkGenerator());

            Objects.requireNonNull(Bukkit.createWorld(wc)).setSpawnFlags(false, false);

        }

    }


    public static void event(final PlayerQuitEvent e) {
        try {
            final String wn = "subspace";

            World world = Bukkit.getWorld(wn);

            if(world == null) return;

            if (!(world.getPlayers().isEmpty()))
                return;

            for (Chunk c : world.getLoadedChunks()) {
                c.unload(true);
            }
            Bukkit.getServer().unloadWorld(wn, true);

        } catch (Exception ee) {
            Bukkit.getLogger().info("[OPItems] Exception:");
            ee.printStackTrace();
        }
    }


    public static void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        UUID id = p.getUniqueId();
        int currentTick = Bukkit.getCurrentTick();

        //Anti double click --> automatically triggered when changing cel20.dimensions
        if (lastClickTick.getOrDefault(id, 0) > currentTick - 20) {
            return;
        }

        lastClickTick.put(id, currentTick);

        p.sendMessage(ChatColor.GREEN + "Teleporting...");
        final String wn = "subspace";

        if (!Celutis.doesWorldExist(wn)) {
            final WorldCreator worldCreator = new WorldCreator(wn);
            worldCreator.generator(new SubspaceDimensionChunkGenerator());
            Bukkit.createWorld(worldCreator);
        }

        final World playerWorld = e.getPlayer().getWorld();
        final World targetWorld = Bukkit.getWorld(wn);
        assert targetWorld != null;

        try {
            targetWorld.setSpawnFlags(false, false);
        } catch (Exception ignored) {

        }

        if (targetWorld == null) {

            final WorldCreator worldCreator2 = new WorldCreator(wn);

            worldCreator2.generator(new SubspaceDimensionChunkGenerator());

            Bukkit.createWorld(worldCreator2);

            p.sendMessage(ChatColor.RED + "The World " + wn + " is still initializing.");
            p.sendMessage(ChatColor.RED + "Please try again in 5-10 sec");
            return;
        }
        Location l;
        if (playerWorld != targetWorld) {

            l = new Location(targetWorld, e.getPlayer().getLocation().getX() / 32, targetWorld.getHighestBlockYAt(e.getPlayer().getLocation()) + 1, e.getPlayer().getLocation().getZ() / 32);

        } else {

            l = new Location(Bukkit.getWorld("world"), e.getPlayer().getLocation().getX() * 32, Bukkit.getWorld("world").getHighestBlockYAt(e.getPlayer().getLocation()) + 1, e.getPlayer().getLocation().getZ() * 32);

        }

        e.getPlayer().teleport(l);


    }

    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject((Object) SubspaceDimensionWand.players_in_customw);
            out.close();
        } catch (IOException e) {
            File f = new File(filePath);
            try {
                if (!f.createNewFile()) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {

                e2.printStackTrace();
            }
        }
    }

    public static void loadData(final String filePath) {
        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(filePath)));
            SubspaceDimensionWand.players_in_customw = (List<String>) in.readObject();
            in.close();
        } catch (ClassNotFoundException | IOException ex2) {
            System.out.println("Creating new file for dimensional player data");
            SubspaceDimensionWand.players_in_customw = new ArrayList<>();
            File f = new File(filePath);
            try {
                if (!f.createNewFile()) {
                    ex2.printStackTrace();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}

