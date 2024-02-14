
package items;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.ChatColor;
import org.bukkit.event.block.Action;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Block;
import org.bukkit.Location;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class tntlayer implements Listener
{
    static HashMap<Location, Block> map;
    
    static {
        tntlayer.map = new HashMap<Location, Block>();
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() != Material.BLAZE_ROD || !p.getItemInHand().containsEnchantment(Enchantment.DEPTH_STRIDER) || !p.getItemInHand().containsEnchantment(Enchantment.FROST_WALKER) || !p.getItemInHand().containsEnchantment(Enchantment.ARROW_DAMAGE) || !p.getItemInHand().containsEnchantment(Enchantment.ARROW_INFINITE)) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            final Block b = e.getClickedBlock();
            final BlockFace bf = e.getBlockFace();
            if (b.getType() != Material.TNT) {
                return;
            }
            if (!tntlayer.map.containsValue(b)) {
                tntlayer.map.put(b.getLocation(), b);
                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("TNT added").toString());
            }
        }
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (!e.getPlayer().isSneaking()) {
                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Do You really want to activate the TNT Blocks?").toString());
                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("If Yes: Sneak + Right Click in the Air").toString());
            }
            else {
                p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Activating TNT-Blocks!").toString());
                for (final Block b : tntlayer.map.values()) {
                    if (b.getType() == Material.TNT) {
                        b.setType(Material.AIR);
                        b.getWorld().spawnEntity(b.getLocation(), EntityType.PRIMED_TNT);
                    }
                }
                tntlayer.map.clear();
            }
        }
    }
}
