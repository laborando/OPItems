
package items.classic;

import items.NameSpaces;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.persistence.PersistentDataType;

public class AntiFall
{
    public static void event(final EntityDamageEvent e) {

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

                    String abl = item.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsAbilities, PersistentDataType.STRING);
                    if (abl != null && abl.contains("nofall")) {

                        e.setCancelled(true);

                    }

                });
        }

    }
}
