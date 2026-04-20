package items.normal.ws;

import cel20.op.GlobalVars;
import items.NameSpaces;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class Workstation {

    public static void event(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        e.setCancelled(true);
        openWSMenu(p);

    }

    private static void openWSMenu(Player p) {

        WsGUICreator.showWSMenu(p);

    }
}
