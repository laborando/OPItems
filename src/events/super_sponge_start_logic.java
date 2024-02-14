
package events;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.Listener;

public class super_sponge_start_logic implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (p.getPlayer().getItemInHand().containsEnchantment(Enchantment.ARROW_DAMAGE)) {
            final Block block = e.getBlock();
            mega_sponge.run_sponge(block);
        }
        if (p.getPlayer().getItemInHand().containsEnchantment(Enchantment.ARROW_FIRE)) {
            final Block block = e.getBlock();
            mega_sponge.run_sponge_lava(block);
        }
    }
}
