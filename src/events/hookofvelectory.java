

package events;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.Listener;

public class hookofvelectory implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void onFish(final PlayerFishEvent e) {
        if (e.getState() == PlayerFishEvent.State.REEL_IN) {
            final Player p = e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            final Player p = e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.IN_GROUND) {
            final Player p = e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.BITE) {
            final Player p = e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
            final Player p = e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT) {
            final Player p = e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.FISHING) {
            final Player p = e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
    }
}
