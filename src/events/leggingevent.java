
package events;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;

public class leggingevent implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerMoveEvent e) {
        final ItemStack i = e.getPlayer().getInventory().getLeggings();
        if (i == null) {
            return;
        }
        final Material a = i.getType();
        if (a == Material.IRON_LEGGINGS && i.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3));
        }
    }
}
