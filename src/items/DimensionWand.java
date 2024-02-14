
package items;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import dimensions.ChunkGen;
import io.netty.handler.codec.http.HttpContentEncoder.Result;

import org.bukkit.WorldCreator;
import celutis.celutis;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;

import cel20.op.Main;
import org.bukkit.event.block.Action;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.Listener;

public class DimensionWand implements Listener
{
	
static List<String> players_in_customw;
    
    static {
        DimensionWand.players_in_customw = new ArrayList<String>();
    }
	
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerChangedWorldEvent  e) {
    	final String wn = "pocket-world-" + e.getPlayer().getUniqueId();
    	
    	if(e.getPlayer().getWorld().getName().equals(wn)) {
    		players_in_customw.add(e.getPlayer().getUniqueId().toString());
    	}else {
    		if(players_in_customw.contains(e.getPlayer().getUniqueId().toString())) {
    			players_in_customw.remove(e.getPlayer().getUniqueId().toString());
    		}
    	}
    	
    }
    
	@EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerPreLoginEvent e) {
		final String wn = "pocket-world-" + e.getUniqueId();
		Bukkit.getLogger().info(wn);
		World world = Bukkit.getWorld(wn);
		
		if(players_in_customw.contains(e.getUniqueId().toString())) {
		new WorldCreator(wn).createWorld();
		world = Bukkit.getWorld(wn);
        if (world == null) {
        	String message = ChatColor.RED + "" + ChatColor.BOLD + "The World is still loading!\n"
                    + "Try Joining in ~7 seconds\n"
                    + "Debug: World: " + wn + " Timestamp: " + System.currentTimeMillis();
        	e.disallow(null,message);
        	
        	/*new BukkitRunnable() {
                @Override
                public void run() {
                		if(Bukkit.getWorld(wn) == null) {
                			e.disallow(null, ChatColor.RED + "" + ChatColor.BOLD + "The World you're spawning in is not loaded yet! /n t");
                		}
                    }
            }.runTaskLater(Main.getPluginInstance(), 60); */
        }
		}
        	
        }
        
        
        @EventHandler(priority = EventPriority.HIGH)
        public void event(final PlayerQuitEvent e) {
        	try {
        	final String wn = "pocket-world-" + e.getPlayer().getUniqueId();
        	World world = Bukkit.getWorld(wn);

        	
            
            if (world != null) {
            	for(Chunk c : world.getLoadedChunks()){
            		c.unload(true);
            	};
            	Bukkit.getLogger().info("Pocket World for " + e.getPlayer().getName() + " unloaded.");
            }else {
            	
            }
        	
        	
        	}catch (Exception ee) {
				Bukkit.getLogger().info("Exception:");
				ee.printStackTrace();
			}
        }
        
	
	
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() != Material.BLAZE_ROD || !p.getItemInHand().containsEnchantment(Enchantment.DEPTH_STRIDER) || !p.getItemInHand().containsEnchantment(Enchantment.ARROW_INFINITE) || !p.getItemInHand().containsEnchantment(Enchantment.FROST_WALKER) || !p.getItemInHand().containsEnchantment(Enchantment.PROTECTION_FALL)) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (!Main.isprivatedimenableled) {
                p.sendMessage(ChatColor.RED + "This Item is disabled in the Config.");
                p.sendMessage(ChatColor.RED + "If you think this is an error, contact an administrator.");
                return;
            }
            p.sendMessage(ChatColor.GREEN + "Teleporting...");
            p.sendMessage(ChatColor.RED + "This could take up to 7 sec");
            final String wn = "pocket-world-" + e.getPlayer().getUniqueId();
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Pocket World started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new ChunkGen());
                Bukkit.createWorld(worldCreator);
            }
            final World playerWorld = e.getPlayer().getWorld();
            final World targetWorld = Bukkit.getWorld(wn);

            if (targetWorld == null) {

                final WorldCreator worldCreator2 = new WorldCreator(wn);

                worldCreator2.generator((ChunkGenerator)new ChunkGen());

                Bukkit.createWorld(worldCreator2);

                p.sendMessage(ChatColor.RED + "The World is still initializing...");
                p.sendMessage(ChatColor.RED + "Debug: " + wn);
                p.sendMessage(ChatColor.RED + "The Teleport has been canceled. Please try again in 5-10 sec");
                return;
            }
            Location l;
            if (playerWorld != targetWorld) {
                l = celutis.getHighestNonAirBlockLocation(targetWorld, e.getPlayer().getLocation().getBlockX(), e.getPlayer().getLocation().getBlockZ());
            }
            else {
                l = celutis.getHighestNonAirBlockLocation(Bukkit.getWorld("world"), e.getPlayer().getLocation().getBlockX(), e.getPlayer().getLocation().getBlockZ());
            }
            if (l != null) {
                e.getPlayer().teleport(l);
            }
        }
    }
    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream((OutputStream)new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject((Object)DimensionWand.players_in_customw);
            out.close();
        }
        catch (IOException e) {
        	File f = new File(filePath);
            try {
				if(!f.createNewFile()) {
					e.printStackTrace();
				}
			} catch (IOException e2) {
				
				e2.printStackTrace();
			}
        }
    }
    
    public static void loadData(final String filePath) {
        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream((InputStream)new GZIPInputStream(new FileInputStream(filePath)));
            DimensionWand.players_in_customw = (List<String>)in.readObject();
            in.close();
        }
        catch (ClassNotFoundException | IOException ex2) {
        	System.out.println("Probably first time starting... Creating new File. Do not report the following unless it is happening for more than two times");
        	DimensionWand.players_in_customw = new ArrayList<String>();
        	File f = new File(filePath);
            try {
				if(!f.createNewFile()) {
					ex2.printStackTrace();
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        }
    }
    
    }

