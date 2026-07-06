package cel20.opitems.items.normal;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullImitator {

    public static void event(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();

        if (!(p.isSneaking())) {

            p.sendMessage(ChatColor.RED + "Do you really want to place this head and lock its texture?");
            p.sendMessage(ChatColor.RED + "If yes: Sneak + Place");
            e.setCancelled(true);
        }


    }


    public static void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();


        final ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getItemMeta() == null) {
            return;
        }
        if (item.getType() == Material.PLAYER_HEAD) {


            if (e.getAction() == Action.RIGHT_CLICK_AIR) {

                SkullMeta sm = (SkullMeta) item.getItemMeta();
                try {
                    sm.setOwner(p.getPlayer().getName());
                    item.setItemMeta(sm);
                } catch (NullPointerException ignored1) {
                }
            }


        }


    }
}
