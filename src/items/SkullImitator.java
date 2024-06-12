package items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullImitator implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockPlaceEvent e) {
        final Player p = (Player) e.getPlayer();
        final ItemStack item = p.getInventory().getItemInMainHand();
        if(item.getItemMeta() == null){
            return;
        }
        if (item.getType() == Material.PLAYER_HEAD && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Skull Imitator")) {
            if(!(p.isSneaking())) {

                p.sendMessage(ChatColor.RED + "Do you really want to place this head and lock its texture?");
                p.sendMessage(ChatColor.RED + "If yes: Sneak + Place");
                e.setCancelled(true);
            }
        }
    }


    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {
        if (e.getPlayer() instanceof Player) {
            final Player p = (Player) e.getPlayer();



            final ItemStack item = p.getInventory().getItemInMainHand();
            if(item.getItemMeta() == null){
                return;
            }



            if (item.getType() == Material.PLAYER_HEAD && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Skull Imitator")) {



                if (e.getAction() == Action.RIGHT_CLICK_AIR) {

                    SkullMeta sm = (SkullMeta) item.getItemMeta();
                    try {
                        sm.setOwner(p.getPlayer().getName());
                        item.setItemMeta(sm);
                    }catch (NullPointerException ignored1){}
                }


            }
        }

    }
}
