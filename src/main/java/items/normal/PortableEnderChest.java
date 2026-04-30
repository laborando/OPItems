package items.normal;

import items.classic.Sponges.SuperSponge;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PortableEnderChest {

    public static void event(final PlayerInteractEvent e) {

        e.getPlayer().openInventory(e.getPlayer().getEnderChest());

        e.setCancelled(true);

    }

}
