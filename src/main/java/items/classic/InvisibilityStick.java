
package items.classic;

import items.EventManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvisibilityStick {


    public static void event(final PlayerInteractEvent e) {

        Player p = e.getPlayer();

        p.setInvisible(!p.isInvisible());

    }

    public static void event(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();

        ItemStack dropped = e.getItemDrop().getItemStack();

        String inds = EventManager.getIDNSorNullIfNotOPItems(dropped);
        if (inds == null)
            return;

        if (!inds.equals("opitems_22"))
            return;

        if (p.isInvisible()) {
            p.sendMessage("You are not invisible anymore");
            p.setInvisible(false);
        }

    }

    public static void event(final PlayerRespawnEvent e) {

        final Player p = e.getPlayer();

        p.setInvisible(false);

    }
}
