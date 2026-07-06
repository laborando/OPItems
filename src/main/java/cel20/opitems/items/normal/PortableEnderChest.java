package cel20.opitems.items.normal;

import org.bukkit.event.player.PlayerInteractEvent;

public class PortableEnderChest {

    public static void event(final PlayerInteractEvent e) {

        e.getPlayer().openInventory(e.getPlayer().getEnderChest());

        e.setCancelled(true);

    }

}
