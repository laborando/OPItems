package items.classic.Sponges;

import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;

public class SuperSpongeStarter {


    public static void lavaEvent(final BlockPlaceEvent e) {

        final Block block = e.getBlock();

        SuperSponge.runSpongeLava(block);

    }

    public static void waterEvent(final BlockPlaceEvent e) {

        final Block block = e.getBlock();

        SuperSponge.runSponge(block);

    }

}
