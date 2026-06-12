package items.classic.Sponges;

import cel20.op.GlobalVars;
import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class SuperSponge {
    public static void runSponge(final Block block) {
        final List<Block> b = new ArrayList<>();
        Queue<Block> q = new ArrayDeque<Block>();
        b.add(block);
        q.add(block);

        recursiveSpongeRunner(0, b, q);
    }

    public static void recursiveSpongeRunner(int cStep, List<Block> b, Queue<Block> q) {

        if (cStep == GlobalVars.spongeClearRange) {
            recursiveWaterRemoval(0, b);
            return;
        }


        for (int i = 0; i < 500; i++) {
            addFace(b, q);
        }

        Runnable r = () -> SuperSponge.recursiveSpongeRunner(cStep + 1, b, q);
        Bukkit.getScheduler().runTaskLater(Main.getPluginInstance(), r, 1L);

    }

    private static void addFace(List<Block> b, Queue<Block> q) {

        Block block = q.poll();

        if (!b.contains(block.getRelative(BlockFace.DOWN, 1))) {
            b.add(block.getRelative(BlockFace.DOWN, 1));
            q.add(block.getRelative(BlockFace.DOWN, 1));
        }
        if (!b.contains(block.getRelative(BlockFace.UP, 1))) {
            b.add(block.getRelative(BlockFace.UP, 1));
            q.add(block.getRelative(BlockFace.UP, 1));
        }
        if (!b.contains(block.getRelative(BlockFace.EAST, 1))) {
            b.add(block.getRelative(BlockFace.EAST, 1));
            q.add(block.getRelative(BlockFace.EAST, 1));
        }
        if (!b.contains(block.getRelative(BlockFace.NORTH, 1))) {
            b.add(block.getRelative(BlockFace.NORTH, 1));
            q.add(block.getRelative(BlockFace.NORTH, 1));
        }
        if (!b.contains(block.getRelative(BlockFace.SOUTH, 1))) {
            b.add(block.getRelative(BlockFace.SOUTH, 1));
            q.add(block.getRelative(BlockFace.SOUTH, 1));
        }
        if (!b.contains(block.getRelative(BlockFace.WEST, 1))) {
            b.add(block.getRelative(BlockFace.WEST, 1));
            q.add(block.getRelative(BlockFace.WEST, 1));
        }


    }

    public static void recursiveWaterRemoval(int cStep, List<Block> b) {

        if (!b.isEmpty()) {
            Block block = b.get(0);

            if (block.getType() == Material.WATER || block.getType() == Material.KELP_PLANT || block.getType() == Material.TALL_SEAGRASS || block.getType() == Material.SEAGRASS) {
                block.setType(Material.AIR, false);
            }

            b.remove(0);

            if (cStep < 50) {
                recursiveWaterRemoval(cStep + 1, b);
            } else {
                Runnable r = () -> SuperSponge.recursiveWaterRemoval(0, b);
                Bukkit.getScheduler().runTaskLater(Main.getPluginInstance(), r, 1L);
            }

        }

    }


    public static void runSpongeLava(final Block block) {
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
