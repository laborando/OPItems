

package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.ChatColor;
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
import sun.security.action.GetLongAction;

import java.util.HashMap;
import java.util.Map;


public class hookOfVelectory implements Listener
{

    static Map<String, Long> cooldown = new HashMap<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void onFish(final PlayerFishEvent e) {

        Player p = e.getPlayer();



        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.hookOfVelectoryCD)) {
            return;
        }

        if (e.getState() == PlayerFishEvent.State.FISHING)
            return;

        cooldown.put(p.getName(), System.currentTimeMillis());


        if (e.getState() == PlayerFishEvent.State.REEL_IN) {

            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {



                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }

        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.IN_GROUND) {
            
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.BITE) {
            
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
            
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.FISHING_ROD && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                final Location pl = p.getLocation();
                final Location hl = e.getHook().getLocation();
                final Vector vec = new Vector(hl.getX() - pl.getX(), 1.0, hl.getZ() - pl.getZ());
                p.setVelocity(vec);
            }
        }
        if (e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT) {
            
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
