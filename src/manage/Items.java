
package manage;

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import org.bukkit.Chunk;
import java.util.Iterator;
import java.util.Map;
import org.bukkit.entity.Item;
import org.bukkit.World;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class Items
{
    public void removeItems() {
        final Map<Player, Integer> itemCounts = new HashMap<Player, Integer>();
        for (final Player player : Bukkit.getOnlinePlayers()) {
            itemCounts.put(player, 0);
        }
        for (final World world : Bukkit.getWorlds()) {
            Chunk[] loadedChunks;
            for (int length = (loadedChunks = world.getLoadedChunks()).length, i = 0; i < length; ++i) {
                final Chunk chunk = loadedChunks[i];
                Entity[] entities;
                for (int length2 = (entities = chunk.getEntities()).length, j = 0; j < length2; ++j) {
                    final Entity entity = entities[j];
                    if (entity instanceof Item) {
                        final Item item = (Item)entity;
                        final Player closestPlayer = getClosestPlayer(item.getLocation().toVector(), itemCounts.keySet());
                        if (closestPlayer != null) {
                            final int currentCount = itemCounts.getOrDefault(closestPlayer, 0);
                            itemCounts.put(closestPlayer, currentCount + 1);
                        }
                    }
                }
            }
        }
        for (final Map.Entry<Player, Integer> entry : itemCounts.entrySet()) {
            final Player player2 = entry.getKey();
            final int itemCount = entry.getValue();
            Bukkit.broadcastMessage("Loaded Items by " + player2.getName() + ": " + itemCount);
        }
        for (final World world : Bukkit.getWorlds()) {
            Chunk[] loadedChunks2;
            for (int length3 = (loadedChunks2 = world.getLoadedChunks()).length, k = 0; k < length3; ++k) {
                final Chunk chunk = loadedChunks2[k];
                Entity[] entities2;
                for (int length4 = (entities2 = chunk.getEntities()).length, l = 0; l < length4; ++l) {
                    final Entity entity = entities2[l];
                    if (entity instanceof Item) {
                        entity.remove();
                    }
                }
            }
        }
    }
    
    public void ItemsPlayerHeap() {
        final Map<Player, Integer> itemCounts = new HashMap<Player, Integer>();
        for (final Player player : Bukkit.getOnlinePlayers()) {
            itemCounts.put(player, 0);
        }
        for (final World world : Bukkit.getWorlds()) {
            Chunk[] loadedChunks;
            for (int length = (loadedChunks = world.getLoadedChunks()).length, i = 0; i < length; ++i) {
                final Chunk chunk = loadedChunks[i];
                Entity[] entities;
                for (int length2 = (entities = chunk.getEntities()).length, j = 0; j < length2; ++j) {
                    final Entity entity = entities[j];
                    if (entity instanceof Item) {
                        final Item item = (Item)entity;
                        final Player closestPlayer = getClosestPlayer(item.getLocation().toVector(), itemCounts.keySet());
                        if (closestPlayer != null) {
                            final int currentCount = itemCounts.getOrDefault(closestPlayer, 0);
                            itemCounts.put(closestPlayer, currentCount + 1);
                        }
                    }
                }
            }
        }
        for (final Map.Entry<Player, Integer> entry : itemCounts.entrySet()) {
            final Player player2 = entry.getKey();
            final int itemCount = entry.getValue();
            Bukkit.broadcastMessage("Loaded Items by " + player2.getName() + ": " + itemCount);
        }
    }
    
    private static Player getClosestPlayer(final Vector location, final Iterable<Player> players) {
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
    
    
}
