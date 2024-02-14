
package items;

import org.bukkit.command.CommandSender;
import org.bukkit.util.io.BukkitObjectInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.bukkit.util.io.BukkitObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.FileOutputStream;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.List;
import org.bukkit.event.Listener;

public class cursed_sword implements Listener
{
    static List<EntityType> list_entity;
    
    static {
        cursed_sword.list_entity = new ArrayList<EntityType>();
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.NETHERITE_SWORD && item.containsEnchantment(Enchantment.OXYGEN) && item.containsEnchantment(Enchantment.ARROW_INFINITE) && item.containsEnchantment(Enchantment.DURABILITY) && item.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
                if (e.getEntity() instanceof Player) {
                    return;
                }
                if (!p.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                	
                	
                    cursed_sword.list_entity.add(e.getEntity().getType());
                    if(e.getEntity() instanceof LivingEntity) {
                    	
                    LivingEntity le = (LivingEntity) e.getEntity();
                    
                    //le.setHealth(0);
                    
                    le.remove();
                    
                    
                    }else {
                    	e.getEntity().remove();
                    }
                }
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerChangedWorldEvent e) {
        if (e.getPlayer().getWorld().getName().equalsIgnoreCase("world_the_end")) {
            e.getPlayer().getWorld().loadChunk(0, 0);
            final Location temploc = new Location((World)null, 0.0, 255.0, 0.0);
            temploc.setWorld(e.getPlayer().getWorld());
            do {
                temploc.setY(temploc.getY() - 1.0);
            } while (temploc.getBlock().getType() == Material.AIR);
            final Location loc = temploc;
            loc.setWorld(e.getPlayer().getWorld());
            cursed_sword.list_entity.forEach(en ->{
            	
            	e.getPlayer().getWorld().spawnEntity(loc, en);
            	
            }
            	
            );
            
            cursed_sword.list_entity.clear();
        }
    }
    
    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream((OutputStream)new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject((Object)cursed_sword.list_entity);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadData(final String filePath) {
        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream((InputStream)new GZIPInputStream(new FileInputStream(filePath)));
            
            Object o = in.readObject();
            
            if(o instanceof List<?>) {
            	cursed_sword.list_entity = (List<EntityType>)o;
                }else {
                	Bukkit.getLogger().severe("Your Wand of Home Data File is Probably corrupted!");
                	Bukkit.getLogger().severe("An Error Could occur!");
                	cursed_sword.list_entity = (List<EntityType>)o;
                }
            
            in.close();
        }
        catch (ClassNotFoundException | IOException ex2) {
            
            System.out.println("Probably first time starting... Creating new File. Do not report the following unless it is happening for more than two times");
            cursed_sword.list_entity = new ArrayList<EntityType>();
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
    
    public static void sendMsgList(final CommandSender p) {
        p.sendMessage(cursed_sword.list_entity.toString());
    }
    
    public static void resetList() {
        cursed_sword.list_entity = new ArrayList<EntityType>();
    }
}
