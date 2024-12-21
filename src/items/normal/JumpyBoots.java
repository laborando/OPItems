package items.normal;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class JumpyBoots implements Listener {


    private List<String> justJumped = new ArrayList<>();


        @EventHandler(priority = EventPriority.HIGH)
        public void event(final PlayerToggleFlightEvent e) {

        final Player p = (Player) e.getPlayer();
        final ItemStack item = p.getInventory().getItemInMainHand();
        if(item.getItemMeta() == null){
            return;
        }
        if (item.getType() == Material.PLAYER_HEAD && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Jumpy Boots")) {



        }
    }


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();


        if (this.justJumped.contains(player.getName())) {
            Location loc = player.getLocation();
            Block block = loc.add(0.0D, -1.0D, 0.0D).getBlock();
            if (!(block.getType() == Material.AIR)) {
                this.justJumped.remove(player.getName());
            }
        }
    }

}



