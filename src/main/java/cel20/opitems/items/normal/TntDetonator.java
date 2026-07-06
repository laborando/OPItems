package cel20.opitems.items.normal;

import cel20.opitems.items.normal.utClasses.LocationPlayerAssociator;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class TntDetonator {
    //Not restart-save
    static List<LocationPlayerAssociator> blocks = new ArrayList<>();


    public static void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            final Block b = e.getClickedBlock();

            if (b.getType() != Material.TNT) {
                return;
            }

            Location bLoc = b.getLocation();

            if (contains(bLoc)) {
                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("This block is already connected to an TNT Detonator").toString());
            } else {
                blocks.add(new LocationPlayerAssociator(p.getName(), bLoc));
                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("TNT connected").toString());
            }
        }
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {

            //Require Confirmation
            if (!e.getPlayer().isSneaking()) {
                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Sneak + Right-click to confirm activation").toString());
            }

            //Detonate
            else {


                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Activating TNT-Blocks!").toString());

                detonate(p.getName());

            }
        }


    }

    /**
     * Detonates all TNT Blocks associated to the given Playername
     *
     * @param forName
     */
    static void detonate(String forName) {

        List<LocationPlayerAssociator> toRemove = new ArrayList<>();

        for (LocationPlayerAssociator block : blocks) {

            if (block.getName().equalsIgnoreCase(forName)) {

                toRemove.add(block);

                Location bLocation = block.getLocation();

                Block target = bLocation.getBlock();

                if (target.getType() == Material.TNT) {
                    target.setType(Material.AIR);

                    bLocation.getWorld().spawnEntity(bLocation, EntityType.TNT);
                }
            }

        }

        blocks.removeAll(toRemove);

    }

    /**
     * Returns true if location is already in the List
     *
     * @param location
     * @return
     */
    static boolean contains(Location location) {

        for (LocationPlayerAssociator block : blocks) {

            Location tLoc = block.getLocation();

            if (
                    tLoc.x() == location.x() &&
                            tLoc.y() == location.y() &&
                            tLoc.z() == location.z()
            ) {
                return true;
            }


        }

        return false;
    }

}
