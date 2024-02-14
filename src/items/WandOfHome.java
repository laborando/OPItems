package items;

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
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import cel20.op.Main;

public class WandOfHome implements Listener {

static HashMap<String, Location> map_home;
    
    static {
        WandOfHome.map_home = new HashMap<String, Location>();
    }
	
	@EventHandler(priority = EventPriority.HIGH)
	public void event(final PlayerInteractEvent e) {
        if (e.getPlayer() instanceof Player) {
            final Player p = (Player)e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.BLAZE_ROD && item.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS) && item.containsEnchantment(Enchantment.PROTECTION_FIRE)) {
                
            	
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ) {
                	final Block b = e.getClickedBlock();
                    if (!e.getPlayer().isSneaking()) {
                        p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Teleporting Home...").toString());
                        p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("You can set your home by Shift + Rightclicking in the air.").toString());
                        if(map_home.containsKey(p.getUniqueId().toString())) {
                        	Location tl = p.getLocation();
                        	new BukkitRunnable() {
                                @Override
                                public void run() {
                                		if(tl.getX() == p.getLocation().getX() && tl.getY() == p.getLocation().getY()) {
                                			p.teleport(map_home.get(p.getUniqueId().toString()));
                                		}else {
                                			p.sendMessage(ChatColor.RED + "The teleport has not been executed. You must stand still to teleport.");
                                		}
                                    }
                            }.runTaskLater(Main.getPluginInstance(), 40);
                        	
                        	
                        }else {
                        	p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "No Home set!");
                        	p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("You can set your home by Shift + Rightclicking in the air.").toString());
                        }
                    
                    }else{
                    	Location l = p.getLocation();
                    	l.setY(p.getLocation().getY() + 1);
                    	new BukkitRunnable() {
                            @Override
                            public void run() {
                            	Location tl = p.getLocation();
                            		if(tl.getX() == p.getLocation().getX() && tl.getY() == p.getLocation().getY()) {
                            			map_home.put(p.getUniqueId().toString(), l);
                            		}else {
                            			p.sendMessage(ChatColor.RED + "The Home has not been set. You must stand still to set it.");
                            		}
                                }
                        }.runTaskLater(Main.getPluginInstance(), 40);
                        
                        
                    	p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Home set!");
                    }
                }
                
            }
        }
    }
	
    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream((OutputStream)new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject((Object)WandOfHome.map_home);
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
            Object o = in.readObject();
            
            if(o instanceof HashMap<?, ?>) {
            WandOfHome.map_home = (HashMap<String, Location>)o;
            }else {
            	Bukkit.getLogger().severe("Your Wand of Home Data File is Probably corrupted!");
            	Bukkit.getLogger().severe("An Error Could occur!");
            	WandOfHome.map_home = (HashMap<String, Location>)o;
            }
            
            in.close();
        }
        catch (ClassNotFoundException | IOException ex2) {
        	System.out.println("Probably first time starting... Creating new File. Do not report the following unless it is happening for more than two times");
        	WandOfHome.map_home = new HashMap<String, Location>();
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
