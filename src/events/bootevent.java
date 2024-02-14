
package events;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.Effect;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;

public class bootevent implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final ItemStack b = p.getInventory().getBoots();
        if (b == null) {
            return;
        }
        final Material bm = b.getType();
        if (bm == Material.LEATHER_BOOTS && b.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
            p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
        }
    }
}
