
package events;

import org.bukkit.inventory.ItemFlag;
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

public class flystick implements Listener {

    private ItemStack fs;
    private ItemStack wob;

    public flystick(){
        final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BOLD + "FlyFeather");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        itemStack.setItemMeta(itemMeta);

        fs = itemStack;

        final ItemStack itemStackII = new ItemStack(Material.BLAZE_ROD, 1);
        final ItemMeta itemMetaII = itemStackII.getItemMeta();
        itemMetaII.setDisplayName(ChatColor.BOLD + "Wand of Invisibility");
        itemMetaII.setUnbreakable(true);
        itemMetaII.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMetaII.addEnchant(Enchantment.DIG_SPEED, 10, true);
        itemStackII.setItemMeta(itemMetaII);

        wob = itemStackII;

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE && !p.getInventory().contains(fs)) {
            p.setFlying(false);
            p.setAllowFlight(false);
        }
        if (!p.getInventory().contains(wob) && p.isInvisible()) {
            p.sendMessage("You are not invisible anymore");
            p.setInvisible(false);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (!p.getInventory().contains(fs)) {
            if (!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) {
                p.setFlying(false);
                p.setAllowFlight(false);
            }
        }
        if (!p.getInventory().contains(wob) && p.isInvisible()) {
            p.sendMessage("You are not invisible anymore");
            p.setInvisible(false);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();

        if (!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) {
            p.setFlying(false);
            p.setAllowFlight(false);
        }

        p.setInvisible(false);
    }
}
