
package events;

import utis.Updater;
import cel20.op.Main;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.Listener;

public class flystick implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        final ItemStack nv = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta iM = nv.getItemMeta();
        iM.addEnchant(Enchantment.CHANNELING, 10, true);
        iM.setDisplayName(ChatColor.BOLD + "Wand of Boom");
        nv.setItemMeta(iM);
        final ItemStack i = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = i.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "FlyFeather");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        i.setItemMeta(itemMeta);
        if (!p.getInventory().contains(i)) {
        	if(!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) {
            p.setFlying(false);
            p.setAllowFlight(false);
        	}
        }
        if (!p.getInventory().contains(nv) && p.isInvisible()) {
            p.sendMessage("You are not invisible anymore");
            p.setInvisible(false);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        final ItemStack nv = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta iM = nv.getItemMeta();
        iM.addEnchant(Enchantment.CHANNELING, 10, true);
        iM.setDisplayName(ChatColor.BOLD + "Wand of Boom");
        nv.setItemMeta(iM);
        final ItemStack i = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = i.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "FlyFeather");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        i.setItemMeta(itemMeta);
        if (p.getGameMode() != GameMode.CREATIVE && !p.getInventory().contains(i)) {
            p.setFlying(false);
            p.setAllowFlight(false);
        }
        if (!p.getInventory().contains(nv) && p.isInvisible()) {
            p.sendMessage("You are not invisible anymore");
            p.setInvisible(false);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        final ItemStack nv = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta iM = nv.getItemMeta();
        iM.addEnchant(Enchantment.CHANNELING, 10, true);
        iM.setDisplayName(ChatColor.BOLD + "Wand of Boom");
        nv.setItemMeta(iM);
        final ItemStack i = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = i.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "FlyFeather");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        i.setItemMeta(itemMeta);
        if (!p.getInventory().contains(i)) {
        	if(!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) {
            p.setFlying(false);
            p.setAllowFlight(false);
        	}
        }
        if (!p.getInventory().contains(nv) && p.isInvisible()) {
            p.sendMessage("You are not invisible anymore");
            p.setInvisible(false);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    
    public void event(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if (Main.update == 1 && p.isOp()) {
            if (Main.update_type == Updater.ReleaseType.RELEASE) {
                p.sendMessage(ChatColor.GREEN + "A new Update is available for OPItems update with /opitems update or /updateopitems");
            }
            if (Main.update_type == Updater.ReleaseType.BETA) {
                p.sendMessage(ChatColor.GREEN + "A new Update is available for OPItems update with /opitems update or /updateopitems");
            }
        }
    }
}
