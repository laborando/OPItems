
package items.classic;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedLeggings implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerMoveEvent e) {
        final ItemStack i = e.getPlayer().getInventory().getLeggings();
        if (i == null) {
            return;
        }
        final Material a = i.getType();
        if (a == Material.IRON_LEGGINGS && i.containsEnchantment(Enchantment.PUNCH)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3));
        }
    }
}
