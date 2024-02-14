package items;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class portal2go implements Listener {

    /*
    itemMeta.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Portal2Go");
        itemMeta.addEnchant(Enchantment.SILK_TOUCH, 75, true);
        itemMeta.addEnchant(Enchantment.THORNS, 75, true);
     */

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {
        if (e.getPlayer() instanceof Player) {
            final Player p = (Player) e.getPlayer();



            final ItemStack item = p.getInventory().getItemInMainHand();
            if(item.getItemMeta() == null){
                return;
            }



            if (item.getType() == Material.STICK && item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Portal2Go")) {



                if (e.getAction() == Action.RIGHT_CLICK_AIR) {

                    boolean isNether = p.getLocation().getWorld().getName().contains("_nether");
                    String cWorldString = p.getLocation().getWorld().getName();

                    if (isNether) {
                        String worldResult = cWorldString.replace("_nether", "");
                        p.teleport(new Location(Bukkit.getWorld(worldResult), (p.getLocation().getBlockX() * 8), p.getLocation().getBlockY(), (p.getLocation().getBlockZ() * 8)));
                    } else {
                        String worldResult = cWorldString.replace("_the_end", "");
                        p.teleport(new Location(Bukkit.getWorld(worldResult + "_nether"), ((double)p.getLocation().getBlockX() / 8), p.getLocation().getBlockY(), ((double) p.getLocation().getBlockZ() / 8)));
                    }


                }
            }
        }

    }
}
