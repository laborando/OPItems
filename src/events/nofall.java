
package events;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.Listener;

public class nofall implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageEvent e) {
        if (e.getEntityType() == EntityType.PLAYER && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            final Player p = (Player)e.getEntity();
            final ItemStack i = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = i.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            i.setItemMeta(itemMeta);
            if (p.getInventory().contains(i)) {
                e.setCancelled(true);
            }
        }
        
        if (e.getEntityType() == EntityType.PLAYER && e.getCause() == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
            final Player p = (Player)e.getEntity();
            final ItemStack i = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = i.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            i.setItemMeta(itemMeta);
            if (p.getInventory().contains(i)) {
                e.setCancelled(true);
            }
        }
    }
}
