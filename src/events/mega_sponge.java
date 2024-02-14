
package events;

import org.bukkit.block.BlockFace;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Material;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bukkit.block.Block;

public class mega_sponge
{
    public static void run_sponge(final Block block) {
        final List<Block> b = new CopyOnWriteArrayList<Block>();
        b.add(block);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        for (final Block bb : b) {
            if (bb.getType() == Material.WATER) {
                bb.setType(Material.AIR);
            }
        }
    }
    
    public static void run_sponge_lava(final Block block) {
        final List<Block> b = new CopyOnWriteArrayList<Block>();
        b.add(block);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        get_face_block(b);
        for (final Block bb : b) {
            if (bb.getType() == Material.LAVA) {
                bb.setType(Material.AIR);
            }
        }
    }
    
    public static List<Block> get_face_block(final List<Block> b) {
        for (final Block bb : b) {
            if (!b.contains(bb.getRelative(BlockFace.DOWN, 1))) {
                b.add(bb.getRelative(BlockFace.DOWN, 1));
            }
            if (!b.contains(bb.getRelative(BlockFace.UP, 1))) {
                b.add(bb.getRelative(BlockFace.UP, 1));
            }
            if (!b.contains(bb.getRelative(BlockFace.EAST, 1))) {
                b.add(bb.getRelative(BlockFace.EAST, 1));
            }
            if (!b.contains(bb.getRelative(BlockFace.NORTH, 1))) {
                b.add(bb.getRelative(BlockFace.NORTH, 1));
            }
            if (!b.contains(bb.getRelative(BlockFace.SOUTH, 1))) {
                b.add(bb.getRelative(BlockFace.SOUTH, 1));
            }
            if (!b.contains(bb.getRelative(BlockFace.WEST, 1))) {
                b.add(bb.getRelative(BlockFace.WEST, 1));
            }
        }
        return b;
    }
}
