package cel20.opitems.items.normal;

import cel20.opitems.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class WandOfHome {

    //31

    static HashMap<String, Location> map_home;

    static {
        WandOfHome.map_home = new HashMap<>();
    }

    public static void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        if (!e.getPlayer().isSneaking()) {
            p.sendMessage(String.valueOf(ChatColor.GRAY) + ChatColor.ITALIC + "Teleporting Home...");
            if (map_home.containsKey(p.getUniqueId().toString())) {
                Location tl = p.getLocation();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (tl.getX() == p.getLocation().getX() && tl.getY() == p.getLocation().getY()) {
                            p.teleport(map_home.get(p.getUniqueId().toString()));
                        } else {
                            p.sendMessage(ChatColor.RED + "The teleport has not been executed. You must stand still to teleport.");
                        }
                    }
                }.runTaskLater(Main.getPluginInstance(), 30);


            } else {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "No Home set!");
            }

        } else {
            Location l = p.getLocation();
            l.setY(p.getLocation().getY() + 1);
            new BukkitRunnable() {
                @Override
                public void run() {
                    Location tl = p.getLocation();
                    if (tl.getX() == p.getLocation().getX() && tl.getY() == p.getLocation().getY()) {
                        map_home.put(p.getUniqueId().toString(), l);
                    } else {
                        p.sendMessage(ChatColor.RED + "The Home has not been set. You must stand still to set it.");
                    }
                }
            }.runTaskLater(Main.getPluginInstance(), 20);


            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Home set!");

        }


    }

    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject(WandOfHome.map_home);
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
            Object o = in.readObject();

            if (o instanceof HashMap<?, ?>) {
                WandOfHome.map_home = (HashMap<String, Location>) o;
            } else {
                Bukkit.getLogger().severe("The Wand of Home Data seems corrupted!");
                Bukkit.getLogger().severe("An Error might occur ...");
                WandOfHome.map_home = (HashMap<String, Location>) o;
            }

            in.close();
        } catch (ClassNotFoundException | IOException ex2) {
            WandOfHome.map_home = new HashMap<>();
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
