package utis;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.*;

public class Celutis {

    //v0.5 MC

    public static boolean isPaper() {
        try {
            Class.forName("com.destroystokyo.paper.PaperConfig");
            return true;
        } catch (ClassNotFoundException e) {
            try {
                Class.forName("io.papermc.paper.configuration.Configuration");
                return true;
            } catch (ClassNotFoundException ex) {
                return false;
            }
        }
    }

    /**
     * Simple clean method for generating an int between given max & min
     *
     * @param min
     * @param max
     * @return
     */
    public static int simpleRandom(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max is not greater than Min.");
        }
        final Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    /**
     * Simple clean method for generating a double between given max & min
     *
     * @param min
     * @param max
     * @return
     */
    public static double simpleRandom(final double min, final double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min!");
        }
        final Random r = new Random();
        return (r.nextDouble() * (max - min)) + min;
    }

    public static boolean doesWorldExist(final String worldName) {
        final File worldFolder = new File(Bukkit.getServer().getWorldContainer(), worldName);
        return worldFolder.exists();
    }


    /**
     * Gets random topmost blocks from the center <br>
     * Even though it is called radius the blocks are chosen from a rect
     *
     * @param center
     * @param radius
     * @param count
     * @return
     */
    public static List<Block> getRandomBlocksSurface(Location center, int radius, int count) {
        List<Block> randomBlocks = new ArrayList<>();
        World world = center.getWorld();

        for (int i = 0; i < count; i++) {
            int xOffset = simpleRandom(-radius, radius);
            int zOffset = simpleRandom(-radius, radius);


            Location randomLocation = center.clone().add(xOffset, 0, zOffset);
            randomLocation.setY(randomLocation.getWorld().getHighestBlockYAt(randomLocation));
            Block block = world.getBlockAt(randomLocation);

            if (block.getType() != Material.AIR) {
                randomBlocks.add(block);
            }
        }

        return randomBlocks;
    }

    public static Vector getVectorBetweenLocations(Location from, Location to) {

        double x = (to.getX() - from.getX());
        double y = (to.getY() - from.getY());
        double z = (to.getZ() - from.getZ());

        return new Vector(x, y, z);
    }

    ArrayList<Color> colors = (ArrayList<Color>) Arrays.asList(
            Color.WHITE,
            Color.LIME,
            Color.SILVER,
            Color.RED,
            Color.AQUA,
            Color.BLUE,
            Color.FUCHSIA,
            Color.GRAY,
            Color.MAROON,
            Color.BLACK,
            Color.YELLOW,
            Color.TEAL,
            Color.ORANGE,
            Color.OLIVE,
            Color.NAVY,
            Color.GREEN,
            Color.PURPLE
    );

    public Color getRandomColor() {

        int size = colors.size();
        Random ran = new Random();

        return colors.get(ran.nextInt(size));

    }

    public static ItemStack getSkullByName(String name) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        if (name == null || name.isEmpty()) {
            return head;
        }
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        headMeta.setDisplayName(ChatColor.DARK_RED + "Imitation of " + name + "'s Skull");
        headMeta.setOwner(name);
        head.setItemMeta(headMeta);
        return head;
    }

    /**
     * Gets locations in a Query representing a circle
     *
     * @param center
     * @param radius
     * @param amount
     * @return
     */
    public static Queue<Location> getCircleLocationsQue(Location center, double radius, int amount) {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        Queue<Location> locations = new ArrayDeque<>();
        for (int i = 0; i < amount; i++) {
            double angle = i * increment;
            double x = center.getX() + (radius * Math.cos(angle));
            double z = center.getZ() + (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }

    public static boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        return (path.delete());
    }

    public boolean isChunkInSpawnRadius(final int chunkX, final int chunkZ) {
        final int spawnRadius = Bukkit.getServer().getSpawnRadius();
        return Math.abs(chunkX) <= spawnRadius && Math.abs(chunkZ) <= spawnRadius;
    }
}

