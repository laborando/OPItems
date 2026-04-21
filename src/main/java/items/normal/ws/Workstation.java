package items.normal.ws;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

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
