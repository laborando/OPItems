package items.normal.ws;

import cel20.op.GlobalVars;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class Workstation implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void event(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        Action action = e.getAction();


        if (!(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
            return;


        final ItemStack item = p.getInventory().getItemInMainHand();
        if (item == null || item.getItemMeta() == null) {
            return;
        }

        String abl = item.getItemMeta().getPersistentDataContainer().get(GlobalVars.opitemsAbilities, PersistentDataType.STRING);
        if (abl != null && abl.contains("workstation")) {

            e.setCancelled(true);
            openWSMenu(p);

        }
    }

    private void openWSMenu(Player p) {

        WsGUICreator.showWSMenu(p);

    }
}
