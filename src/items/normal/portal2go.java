package items.normal;

import org.bukkit.*;
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
            final Player p = e.getPlayer();



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
                            World overworld = Bukkit.getWorld(worldResult);

                            int x = p.getLocation().getBlockX() * 8;
                            int z = p.getLocation().getBlockZ() * 8;

                            int y = overworld.getHighestBlockYAt(x, z) + 1;

                            Location safeLoc = new Location(overworld, x + 0.5, y, z + 0.5);
                            p.teleport(safeLoc);

                        } else {
                            String worldResult = cWorldString.replace("_the_end", "");

                            World nether = Bukkit.getWorld(worldResult + "_nether");

                            int x = p.getLocation().getBlockX() / 8;
                            int z = p.getLocation().getBlockZ() / 8;

                            int startY = 115;

                            Location safeLoc = null;

                            for (int y = startY; y > 10; y--) {
                                Location check = new Location(nether, x + 0.5, y, z + 0.5);
                                if (check.getBlock().getType().isSolid()) {
                                    Location above = check.clone().add(0, 1, 0);
                                    Location above2 = check.clone().add(0, 2, 0);

                                    if (above.getBlock().isEmpty() && above2.getBlock().isEmpty()) {
                                        safeLoc = above;
                                        break;
                                    }
                                }
                            }

                            if (safeLoc == null) {
                                p.sendMessage("There was no safe location to teleport to. Please move a bit!");
                                return;
                            }

                            p.teleport(safeLoc);

                        }
                    }catch (Exception eig){
                        p.sendMessage(ChatColor.RED + "This is currently not possible!");
                    }

                }
            }
        }

    }
}
