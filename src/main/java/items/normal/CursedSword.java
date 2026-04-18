
package items.normal;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CursedSword implements Listener
{
    static List<EntityType> list_entity;
    
    static {
        CursedSword.list_entity = new ArrayList<>();
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.NETHERITE_SWORD && item.containsEnchantment(Enchantment.RESPIRATION) && item.containsEnchantment(Enchantment.INFINITY) && item.containsEnchantment(Enchantment.UNBREAKING) && item.containsEnchantment(Enchantment.POWER)) {
                if (e.getEntity() instanceof Player) {
                    return;
                }
                if (!p.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                	
                	
                    CursedSword.list_entity.add(e.getEntity().getType());
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
            CursedSword.list_entity.forEach(en -> e.getPlayer().getWorld().spawnEntity(loc, en)
            	
            );
            
            CursedSword.list_entity.clear();
        }
    }
    
    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject((Object) CursedSword.list_entity);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("This could be resolved after a restart! Please try again!");
        }
    }
    
    public static void loadData(final String filePath) {
        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(filePath)));
            
            Object o = in.readObject();
            
            if(o instanceof List<?>) {
            	CursedSword.list_entity = (List<EntityType>)o;
                }else {
                	Bukkit.getLogger().severe("Your Wand of Home Data File is Probably corrupted!");
                	Bukkit.getLogger().severe("An Error Could occur!");
                	CursedSword.list_entity = (List<EntityType>)o;
                }
            
            in.close();
        }
        catch (ClassNotFoundException | IOException ex2) {
            
            System.out.println("Probably first time starting... Creating new File. Do not report the following unless it is happening for more than two times");
            CursedSword.list_entity = new ArrayList<>();
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
        p.sendMessage(CursedSword.list_entity.toString());
    }
    
    public static void resetList() {
        CursedSword.list_entity = new ArrayList<>();
    }
}
