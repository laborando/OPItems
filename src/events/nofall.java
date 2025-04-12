
package events;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.Listener;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class nofall implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageEvent e) {

        if(!(e.getEntityType() == EntityType.PLAYER))
            return;

        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            final Player p = (Player)e.getEntity();
            final ItemStack i = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = i.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RED + " - As long as this is in your inventory, you will be immune to fall-damage");
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            i.setItemMeta(itemMeta);
            if (p.getInventory().contains(i)) {
                e.setCancelled(true);
                return;
            }
        }else if (e.getCause() == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
            final Player p = (Player) e.getEntity();
            final ItemStack i = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = i.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RED + " - As long as this is in your inventory, you will be immune to fall-damage");
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            i.setItemMeta(itemMeta);
            if (p.getInventory().contains(i)) {
                e.setCancelled(true);
                return;
            }
        }

        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            final Player p = (Player)e.getEntity();
            final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });

            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RED + " - As long as this is in your inventory, you will be immune to fall-damage");
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            itemStack.setItemMeta(itemMeta);
            if (p.getInventory().contains(itemStack)) {
                e.setCancelled(true);
                return;
            }


        }else if (e.getCause() == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
            final Player p = (Player)e.getEntity();
            final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RED + " - As long as this is in your inventory, you will be immune to fall-damage");
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            itemStack.setItemMeta(itemMeta);
            if (p.getInventory().contains(itemStack)) {
                e.setCancelled(true);
                return;
            }
        }

        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            final Player p = (Player)e.getEntity();
            final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });

            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RED + " - As long as this is in your inventory, you will be immune to fall damage");
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            itemStack.setItemMeta(itemMeta);
            if (p.getInventory().contains(itemStack)) {
                e.setCancelled(true);
                return;
            }


        }else if (e.getCause() == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
            final Player p = (Player)e.getEntity();
            final ItemStack itemStack = new ItemStack(Material.FEATHER, 1);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(ChatColor.BOLD + "AntiFall");
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RED + " - As long as this is in your inventory, you will be immune to fall damage");
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(true);
            itemMeta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
            itemStack.setItemMeta(itemMeta);
            if (p.getInventory().contains(itemStack)) {
                e.setCancelled(true);
                return;
            }
        }
    }
}
