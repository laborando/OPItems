
package items.classic;

import cel20.op.GlobalVars;
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
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class AntiFall implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageEvent e) {

        if(!(e.getEntityType() == EntityType.PLAYER))
            return;

        switch (e.getCause()){
            case FALL:
            case FLY_INTO_WALL:

                Player p = (Player) e.getEntity();

                p.getInventory().forEach(item -> {

                    if (item == null || item.getItemMeta() == null) {
                        return;
                    }

                    String abl = item.getItemMeta().getPersistentDataContainer().get(GlobalVars.opitemsAbilities, PersistentDataType.STRING);
                    if (abl != null && abl.contains("nofall")) {

                        e.setCancelled(true);

                    }

                });
        }

    }
}
