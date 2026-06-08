package items.normal;


import cel20.op.Main;
import items.NameSpaces;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Landmine {

    private static List<Location> lml = new ArrayList<>();

    /**
     * Landmine destroyed
     * @param e
     */
    public static void event(final BlockDropItemEvent e) {
        if (e.getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            if (lml.contains(e.getBlock().getLocation())) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), () -> {
                    if (!(e.getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE)) {

                        lml.remove(e.getBlock().getLocation());
                    }
                });
            }

        }
    }

    /**
     * Stepping on landmine
     * @param e
     */
    public static void event(final BlockPhysicsEvent e) {
        if (e.getChangedType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            if (lml.contains(e.getBlock().getLocation())) {
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), () -> {
                    if (!(e.getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE)) {
                        lml.remove(e.getBlock().getLocation());
                        e.getBlock().getLocation().getWorld().createExplosion(e.getBlock().getLocation(), 1);
                    }
                });
            }

        }

    }

    /**
     * Adds placed Landmines to the List
     * @param e
     */
    public static void event(final BlockPlaceEvent e) {

        Block b = e.getBlock();

        lml.add(b.getLocation());

    }

    /**
     * Physical -> Stepping on Landmine and defusing landmine
     * @param e
     */
    public static void event(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.PHYSICAL)) {
            if (e.getClickedBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                Block b = e.getClickedBlock();
                if (lml.contains(b.getLocation())) {

                    lml.remove(b.getLocation());
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), () -> b.setType(Material.AIR));
                    b.getWorld().createExplosion(b.getLocation().add(0, 1, 0), 4);

                }
            }

        } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            EquipmentSlot es = e.getHand();
            if (es.equals(EquipmentSlot.HAND)) {

                final ItemStack item = p.getInventory().getItemInMainHand();
                if (item.getItemMeta() == null) {
                    return;
                }

                String abl = item.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsAbilities, PersistentDataType.STRING);
                if (abl != null && abl.contains("defuse")) {


                    if (e.getClickedBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                        Block b = e.getClickedBlock();
                        if (lml.contains(b.getLocation())) {
                            lml.remove(b.getLocation());
                            p.sendMessage(ChatColor.RED + "Landmine defused");
                        } else {
                            p.sendMessage(ChatColor.RED + "This is not a landmine");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "This is not a landmine");
                    }

                }
            }
        }
    }

    /**
     * Breaking landmine
     * @param e
     */
    public static void event(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            Block b = e.getBlock();
            if (lml.contains(b.getLocation())) {

                lml.remove(b.getLocation());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), () -> b.setType(Material.AIR));
                b.getWorld().createExplosion(b.getLocation().add(0, 1, 0), 4);

            }
        }

    }


    /**
     * Loads Landmine Data and starts its corresponding schedulers
     */
    public static void load() {


        String fn = Main.getPluginInstance().getDataFolder() + "/landmine_worlds.cel20";

        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(fn)));

            Object o = in.readObject();

            if (o instanceof String) {

                String[] worlds = ((String) o).split(";");
                for (String world : worlds) {
                    try {
                        WorldCreator creator = new WorldCreator(world);
                        creator.createWorld();
                    } catch (Exception e) {
                        if (!world.isEmpty())
                            Bukkit.getLogger().info("The Landmine file for " + world + "was non existent or corrupted");
                    }
                }

            } else {
                Bukkit.getLogger().severe("Your landmine data is corrupted!");
                Bukkit.getLogger().severe("An error could occur ... ");
                lml = (List<Location>) o;
            }

            in.close();
        } catch (ClassNotFoundException | IOException ignored) {
        }

        fn = Main.getPluginInstance().getDataFolder() + "/landmine.cel20";


        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(fn)));

            Object o = in.readObject();


            if (o instanceof List) {
                lml = (List<Location>) o;
            } else {
                Bukkit.getLogger().severe("Your landmine data is corrupted!");
                Bukkit.getLogger().severe("An error could occur ... ");
                lml = (List<Location>) o;
            }

            in.close();
        } catch (ClassNotFoundException | IOException ignored) {
        }

        //Loading finished

        //Landmine particle effects

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPluginInstance(), new Runnable() {
            @Override
            public void run() {
                try {
                    for (Location loc : lml) {
                        if (!(loc.getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE)) {
                            lml.remove(loc);
                        }

                        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 255, 255), 0.5F);

                        if (!Main.landminePerfModeEnabeled) {
                            Location ltmp = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
                            ltmp.add(0.5, 0.2, 0.5);
                            try {
                                loc.getWorld().spawnParticle(Particle.DUST, ltmp, 20, 0.3, 0.2, 0.3, dustOptions);
                            } catch (Exception exception) {
                            }
                        }
                    }
                } catch (ConcurrentModificationException ignored) {
                }
            }
        }, 0L, 20L);


    }

    public static void save() {


        String fn = Main.getPluginInstance().getDataFolder() + "/landmine_worlds.cel20";

        File f = new File(fn);
        try {
            f.createNewFile();
        } catch (IOException important) {
            important.printStackTrace();
        }
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(fn)));

            Set<String> worlds = new HashSet<>();

            lml.forEach(e -> worlds.add(e.getWorld().getName()));

            final String[] wstr = {""};

            worlds.forEach(e -> {
                wstr[0] = wstr[0] + e + ";";
            });

            out.writeObject(wstr[0]);
            out.close();
        } catch (IOException important) {
            important.printStackTrace();
        }

        fn = Main.getPluginInstance().getDataFolder() + "/landmine.cel20";
        f = new File(fn);
        try {
            f.createNewFile();
        } catch (IOException important) {
            important.printStackTrace();
        }
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(fn)));
            out.writeObject(lml);
            out.close();
        } catch (IOException important) {
            important.printStackTrace();
        }

    }

    /**
     * Resets the List of Landmines
     */
    public static void reset() {
        lml = new ArrayList<>();
    }
}
