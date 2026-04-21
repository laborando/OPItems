
package items.classic.Sponges;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class SuperSpongeStarter
{


    public static void lavaEvent(final BlockPlaceEvent e) {

        final Block block = e.getBlock();

        SuperSponge.runSpongeLava(block);

    }

    public static void waterEvent(final BlockPlaceEvent e) {

        final Block block = e.getBlock();

        SuperSponge.runSponge(block);

    }

}
