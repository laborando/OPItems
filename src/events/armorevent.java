
package events;

import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;

public class armorevent implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final ItemStack nv = new ItemStack(Material.IRON_HELMET, 1);
        final ItemStack i = p.getInventory().getHelmet();
        if (i == null) {
            return;
        }
        final Material a = i.getType();
        if (a == Material.IRON_HELMET && i.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000, 255));
        }
        if (a == Material.IRON_HELMET && i.containsEnchantment(Enchantment.ARROW_FIRE)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 900, 250));
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        try {
        if (p.getInventory().getHelmet().getType() == Material.NETHERITE_HELMET && p.getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS) == 75) {
            e.setDamage(0.0);
        }
        }catch (NullPointerException e2) {
        	
        }
    }
}
