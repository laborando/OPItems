package items.normal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import cel20.op.Main;
import utis.celutis;

public class WandOfBlocks implements Listener {
	
static Map<String, List<FallingBlock>> PlayersBlocks;
static Map<String, Long> Cooldown;

public boolean executed = false;

    static {
        WandOfBlocks.PlayersBlocks = new HashMap<>();
        WandOfBlocks.Cooldown = new HashMap<>();
    }
	
    @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGH)
	public void event(final PlayerInteractEvent e) {
        if (e.getPlayer() instanceof Player) {
            final Player p = (Player)e.getPlayer();
            final ItemStack item = p.getInventory().getItemInMainHand();
            if (item.getType() == Material.BLAZE_ROD && item.containsEnchantment(Enchantment.SILK_TOUCH) && item.containsEnchantment(Enchantment.THORNS)) {
                
            	
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ) {
                	final Block b = e.getClickedBlock();
                    if (!e.getPlayer().isSneaking()) {
                    
                    	for(Block b2 : celutis.getRandomBlocks(e.getPlayer().getLocation(), 5)) {
                    	
                    	
                    	FallingBlock fallingBlock = b2.getWorld().spawnFallingBlock(b2.getLocation(), b2.getType().createBlockData());
                        fallingBlock.setDropItem(false);
                        fallingBlock.setGravity(false);
                        fallingBlock.setHurtEntities(true);
                        
                        fallingBlock.setVelocity(new Vector(0, 0.1, 0));
                        b2.setType(Material.AIR);
                        celutis.addValueToMultiMapStringXFallingBlock(PlayersBlocks, p.getName().toString(), fallingBlock);
                    	}
                        
                    	p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("To Charge: Shift-Right Click at your Target Block (Must be in a loaded Chunk).").toString());
                    }else {
                    	
                    	Block bt = p.getTargetBlockExact(300, FluidCollisionMode.NEVER);
                    	
                    	if(bt == null) {return;}
                    	
                    	if(this.Cooldown.get(p.getName().toString()) == null) {
                    		this.Cooldown.put(p.getName().toString(), (long) -20000);
                    	}
                    	
                    	if(!((System.currentTimeMillis() - this.Cooldown.get(p.getName().toString())) >= 5000)) {
                    		p.sendMessage(new StringBuilder().append(ChatColor.GRAY).append(ChatColor.ITALIC).append("Still on cooldown...").toString());
                            
                    	}else {
                    	
                    	
                    	this.Cooldown.put(p.getName().toString(), System.currentTimeMillis());
                    	String keyToIterate = p.getName().toString();
                        List<FallingBlock> valuesForKey = this.PlayersBlocks.get(keyToIterate);
                        if (valuesForKey != null) {
                            for (FallingBlock v : valuesForKey) {
                                Location lt2 = v.getLocation();
                            	lt2.setY(v.getWorld().getHighestBlockYAt(lt2)+2);
                                
                            	v.teleport(lt2);
                            	v.setVelocity(celutis.getVectorBetweenLocations(v.getLocation(), bt.getLocation()));
                                
                            }
                            
                            
                            executed = false;
                            Bukkit.getServer().getScheduler().runTaskTimer(Main.getPluginInstance(), new Runnable() {
                                @Override
                                public void run() {
                                     
                                     
                                     for (FallingBlock v : valuesForKey) {
                                    	 if(v.getLocation().distance(bt.getLocation()) < 5 && executed == false) {
                                    		 executed = true;
                                    		 makeBoom(p, bt.getLocation());
                                    		 
                                    	 }
                                     }
                                		
                                		
                                	
                                    if (executed) {
                                    	
                                    	Thread.currentThread().interrupt();
                                    	
                                    }
                                }
                            }, 0, 1);
                            
                        }
                    	}
                    	
                    }
                    
                    
                }
            }
        }
    }
    
    
    
    
    
    
    
	
	
	public void makeBoom(Player p, Location btl) {
		
		Bukkit.getServer().getScheduler().runTaskLater(Main.getPluginInstance(), new Runnable() {
            @Override
            public void run() {
		
		String kti = p.getName().toString();
		List<FallingBlock> vfk = WandOfBlocks.PlayersBlocks.get(kti);
		
		double dist = p.getLocation().distance(btl);
		
		for (FallingBlock v : vfk) {
			
			Location rl = btl;
			rl.setX(btl.getX()+(celutis.randomRangeDouble(-dist, dist)/4));
			rl.setZ(btl.getZ()+(celutis.randomRangeDouble(-dist, dist)/4));
			rl.setY(btl.getWorld().getHighestBlockYAt(rl));
			
			v.teleport(rl);
			
			v.getWorld().createExplosion(v.getLocation(), 9);
			
			v.setTicksLived(599);
		
		}
		
		WandOfBlocks.PlayersBlocks.remove(p.getName().toString());
		
	}
		}, 5);
	
}
}
