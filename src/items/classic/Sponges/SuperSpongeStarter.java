
package items.classic.Sponges;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class SuperSpongeStarter implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (p.getPlayer().getItemInHand().containsEnchantment(Enchantment.ARROW_DAMAGE)) {

            ItemStack item = p.getInventory().getItemInMainHand();

            if (item.getType() != Material.AIR) {
                int newAmount = item.getAmount() - 1;

                if (newAmount <= 0) {
                    p.getInventory().setItemInMainHand(null);
                } else {
                    item.setAmount(newAmount);
                }
            }

            final Block block = e.getBlock();

            Runnable r = () -> e.getBlock().setType(Material.SPONGE, false);

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), r, 1L);

            SuperSponge.run_sponge(block);

            e.setCancelled(true);

        }
        if (p.getPlayer().getItemInHand().containsEnchantment(Enchantment.ARROW_FIRE)) {
            final Block block = e.getBlock();
            SuperSponge.run_sponge_lava(block);
        }
    }
}
