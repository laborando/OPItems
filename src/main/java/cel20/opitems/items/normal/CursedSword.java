package cel20.opitems.items.normal;

import cel20.opitems.items.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CursedSword {
    static List<EntityType> list_entity = new ArrayList<>();

    public static void event(final EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player p))
            return;

        final ItemStack item = p.getInventory().getItemInMainHand();

        if (item == null) return;
        if (item.isEmpty()) return;

        String inds = EventManager.getIDNSorNullIfNotOPItems(item);
        if (inds == null)
            return;

        if (!inds.equals("opitems_28"))
            return;

        if (!p.getWorld().getName().equalsIgnoreCase("world_the_end")) {


            CursedSword.list_entity.add(e.getEntity().getType());
            if (e.getEntity() instanceof LivingEntity) {

                LivingEntity le = (LivingEntity) e.getEntity();

                if (e instanceof Player)
                    return;

                le.setHealth(0);


            }
        }
    }


    /**
     * Releases all mobs killed by the cursed sword when entering the end
     */
    public static void event(final PlayerChangedWorldEvent e) {
        if (e.getPlayer().getWorld().getName().equalsIgnoreCase("world_the_end")) {
            e.getPlayer().getWorld().loadChunk(0, 0);

            final Location temploc = new Location(null, 0.0, 255.0, 0.0);

            temploc.setWorld(e.getPlayer().getWorld());

            do {
                temploc.setY(temploc.getY() - 1.0);
            } while (temploc.getBlock().getType() == Material.AIR);
            final Location loc = temploc;
            loc.setWorld(e.getPlayer().getWorld());

            CursedSword.list_entity.forEach(en ->
                    e.getPlayer().getWorld().spawnEntity(loc, en)
            );

            CursedSword.list_entity.clear();
        }
    }

    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject((Object) CursedSword.list_entity);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("This could be resolved after a restart! Please try again!");
        }
    }

    public static void loadData(final String filePath) {
        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(filePath)));

            Object o = in.readObject();

            if (o instanceof List<?>) {
                CursedSword.list_entity = (List<EntityType>) o;
            } else {
                Bukkit.getLogger().severe("Your Cursed Sword Data File probably corrupted!");
                Bukkit.getLogger().severe("An Error could occur ...");
                CursedSword.list_entity = (List<EntityType>) o;
            }

            in.close();
        } catch (ClassNotFoundException | IOException ex2) {

            System.out.println("Creating new File for cursed sword data.");
            CursedSword.list_entity = new ArrayList<>();
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

    public static void sendMsgList(final CommandSender p) {
        p.sendMessage(CursedSword.list_entity.toString());
    }

    public static void resetList() {
        CursedSword.list_entity = new ArrayList<>();
    }
}
