
package items.normal;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class TntLayer implements Listener
{
    static HashMap<Location, Block> map;
    
    static {
        TntLayer.map = new HashMap<Location, Block>();
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() != Material.BLAZE_ROD || !p.getItemInHand().containsEnchantment(Enchantment.DEPTH_STRIDER) || !p.getItemInHand().containsEnchantment(Enchantment.FROST_WALKER) || !p.getItemInHand().containsEnchantment(Enchantment.POWER) || !p.getItemInHand().containsEnchantment(Enchantment.INFINITY)) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            final Block b = e.getClickedBlock();
            final BlockFace bf = e.getBlockFace();
            if (b.getType() != Material.TNT) {
                return;
            }
            if (!TntLayer.map.containsValue(b)) {
                TntLayer.map.put(b.getLocation(), b);
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
                for (final Block b : TntLayer.map.values()) {
                    if (b.getType() == Material.TNT) {
                        b.setType(Material.AIR);
                        b.getWorld().spawnEntity(b.getLocation(), EntityType.TNT);
                    }
                }
                TntLayer.map.clear();
            }
        }
    }
}
