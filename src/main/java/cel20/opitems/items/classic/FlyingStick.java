package cel20.opitems.items.classic;

import cel20.opitems.items.EventManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class FlyingStick {

    public static void event(final PlayerInteractEvent e) {

        Player p = e.getPlayer();

        p.setAllowFlight(!p.getAllowFlight());

    }

    public static void event(final PlayerDropItemEvent e) {

        final Player p = e.getPlayer();

        ItemStack dropped = e.getItemDrop().getItemStack();

        String inds = EventManager.getIDNSorNullIfNotOPItems(dropped);
        if (inds == null)
            return;

        if (!inds.equals("opitems_13"))
            return;

        if (p.getGameMode() != GameMode.CREATIVE) {
            p.setFlying(false);
            p.setAllowFlight(false);
        }

    }

    public static void event(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();

        if (!(p.getGameMode().equals(GameMode.CREATIVE) || p.getGameMode().equals(GameMode.SPECTATOR))) {
            p.setFlying(false);
            p.setAllowFlight(false);
        }

    }

}
