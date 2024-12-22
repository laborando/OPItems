package items.normal;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

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

                    try {
                        boolean isNether = p.getLocation().getWorld().getName().contains("_nether");
                        String cWorldString = p.getLocation().getWorld().getName();

                        if (isNether) {
                            String worldResult = "world";
                            p.teleport(new Location(Bukkit.getWorld(worldResult), (p.getLocation().getBlockX() * 8), Bukkit.getWorld("world").getHighestBlockYAt(e.getPlayer().getLocation())+1, (p.getLocation().getBlockZ() * 8)));
                        } else {
                            String worldResult = cWorldString.replace("_the_end", "");
                            p.teleport(new Location(Bukkit.getWorld(worldResult + "_nether"), ((double) p.getLocation().getBlockX() / 8), Math.abs(p.getLocation().getBlockY()), ((double) p.getLocation().getBlockZ() / 8)));
                        }
                    }catch (Exception eig){
                        p.sendMessage(ChatColor.RED + "This is currently not possible!");
                    }

                }
            }
        }

    }
}
