

package celutis;

import com.mojang.authlib.GameProfile;
import org.bukkit.*;

import java.io.File;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Block;

import java.lang.reflect.Field;
import java.util.*;

import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;

public class celutis
{
	
	//v0.5 MC
	
    private static int randomrange(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min!");
        }
        final Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
    
    public static Player getClosestPlayer(final Vector location, final Iterable<Player> players) {
        Player closestPlayer = null;
        double closestDistanceSquared = Double.MAX_VALUE;
        for (final Player player : players) {
            final Location playerLocation = player.getLocation();
            final Vector playerVector = playerLocation.toVector();
            final double distanceSquared = playerVector.distanceSquared(location);
            if (distanceSquared < closestDistanceSquared) {
                closestPlayer = player;
                closestDistanceSquared = distanceSquared;
            }
        }
        return closestPlayer;
    }
    
    public boolean isChunkInSpawnRadius(final int chunkX, final int chunkZ) {
        final int spawnRadius = Bukkit.getServer().getSpawnRadius();
        return Math.abs(chunkX) <= spawnRadius && Math.abs(chunkZ) <= spawnRadius;
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
    
    public static boolean doesWorldExist(final String worldName) {
        final File worldFolder = new File(Bukkit.getServer().getWorldContainer(), worldName);
        return worldFolder.exists();
    }
    
    public static Location getHighestNonAirBlockLocation(final World world, final int x, final int y) {
        for (int currentY = 0; currentY >= world.getMinHeight(); --currentY) {
            final Block block = world.getBlockAt(x, currentY, y);
            if (block.getType() != Material.AIR) {
                return block.getLocation();
            }
        }
        return new Location(world, (double)x, (double)world.getMaxHeight(), (double)y);
    }
    
    public static double randomRangeDouble(final double min, final double max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min!");
        }
        final Random r = new Random();
        return (r.nextDouble() * (max - min)) + min;
    }
    
    public static List<Block> getRandomBlocks(Location center, int count) {
        List<Block> randomBlocks = new ArrayList<>();
        World world = center.getWorld();
        int radius = 10;


        for (int i = 0; i < count; i++) {
            int xOffset = randomrange(-radius, radius);
            int zOffset = randomrange(-radius, radius);
            

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
        double x = (to.getX() - from.getX())/10 ;
        double y = (to.getY() - from.getY())/10 ;
        double z = (to.getZ() - from.getZ())/10 ;
        
        return new Vector(x, y, z);
    }
    
    public static void addValueToMultiMapStringXFallingBlock(Map<String, List<FallingBlock>> map, String key, FallingBlock value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    public Color getRandomColor() {
        ArrayList<Color> colors = new ArrayList<>();
        colors.addAll(Arrays.asList(new Color[] {
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
                Color.PURPLE, }));
        int size = colors.size();
        Random ran = new Random();
        Color cr = colors.get(ran.nextInt(size));
        return cr;
    }

    public static ItemStack getSkullbyName(String name) {

        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        if (name == null || name.isEmpty()){
            return head;
        }
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        headMeta.setDisplayName(ChatColor.DARK_RED + "Imitation of " + name + "'s Skull");
        headMeta.setOwner(name);
        head.setItemMeta(headMeta);
        return head;
    }
    public static boolean deleteDirectory(File path) {
        if( path.exists() ) {
            File files[] = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                }
                else {
                    files[i].delete();
                } //end else
            }
        }
        return( path.delete() );
    }
    
}
