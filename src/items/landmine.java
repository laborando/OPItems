package items;


import cel20.op.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class landmine implements Listener {

    private static List<Location> lml = new ArrayList<>();
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockPhysicsEvent e) {
        if(e.getChangedType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE){
            if(lml.contains(e.getBlock().getLocation())){
                e.setCancelled(true);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), () -> {
                    if(!(e.getBlock().getType()==Material.HEAVY_WEIGHTED_PRESSURE_PLATE)){
                        lml.remove(e.getBlock().getLocation());
                    }
                });
            }

        }

    }
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final ItemStack item = p.getInventory().getItemInMainHand();
        if(item.getItemMeta() == null){
            return;
        }
        if (item.getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Landmine")) {

            Block b = e.getBlock();
            lml.add(b.getLocation());

        }
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void event(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.PHYSICAL)) {
            if (e.getClickedBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                Block b = e.getClickedBlock();
                if(lml.contains(b.getLocation())){

                    lml.remove(b.getLocation());
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), () -> b.setType(Material.AIR));
                    b.getWorld().createExplosion(b.getLocation().add(0, 1, 0), 4);

                }
            }

        }
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void event(BlockBreakEvent e) {
            if (e.getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                Block b = e.getBlock();
                if(lml.contains(b.getLocation())){

                    lml.remove(b.getLocation());
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPluginInstance(), () -> b.setType(Material.AIR));
                    b.getWorld().createExplosion(b.getLocation().add(0, 1, 0), 4);

                }
            }

        }


    public static void load() {
        String fn = Main.getPluginInstance().getDataFolder() + "/landmine.cel20";


            try {
                final BukkitObjectInputStream in = new BukkitObjectInputStream((InputStream) new GZIPInputStream(new FileInputStream(fn)));

                Object o = in.readObject();


                if (o instanceof List) {
                    lml = (List<Location>) o;
                } else {
                    Bukkit.getLogger().severe("Your Landmines Data File is probably corrupted!");
                    Bukkit.getLogger().severe("An Error Could occur!");
                    lml = (List<Location>) o;
                }

                in.close();
            } catch (ClassNotFoundException | IOException ignored) {}

            //LOAD ENDE, INNIT TASKS

            if(!Main.landminePerfModeEnabeled){
                Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPluginInstance(), new Runnable() {
                    @Override
                    public void run() {
                        for (Location loc : lml) {
                            Location ltmp = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
                            ltmp.add(0.5, 0.2, 0.5);
                            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 255, 255), 0.5F);
                            loc.getWorld().spawnParticle(Particle.REDSTONE, ltmp, 20, 0.3, 0.2 ,0.3, dustOptions);
                        }
                    }
                }, 0L, 20L);
            }

    }

    public static void save(){
        String fn = Main.getPluginInstance().getDataFolder() + "/landmine.cel20";
        File f = new File(fn);
        try {
            f.createNewFile();
        }catch (IOException important){important.printStackTrace();}
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(fn)));
            out.writeObject(lml);
            out.close();
        }
        catch (IOException important) {
            important.printStackTrace();
        }

    }

    public static void reset(){
        lml=new ArrayList<>();
    }

}
