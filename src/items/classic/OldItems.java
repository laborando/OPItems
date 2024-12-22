package items.classic;

import cel20.op.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OldItems implements Listener {

    public static Main mainRef = Main.getInstance();
    
    


    @EventHandler(priority = EventPriority.HIGH)
    public void event(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;
        ItemStack item = p.getInventory().getItemInMainHand();
        if (item == null)
            return;
        Material a = item.getType();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (a == Material.NETHERITE_SWORD &&
                    item.getItemMeta().getDisplayName().contains(ChatColor.BOLD + "Enderpearler")) {
                EnderPearl ep = (EnderPearl)e.getPlayer().launchProjectile( EnderPearl.class);
                ep.setBounce(true);
                ep.eject();
            }
            if (a == Material.FLINT &&
                    item.containsEnchantment(Enchantment.ARROW_DAMAGE))
                if (e.getClickedBlock().getY() == p.getLocation().getY()) {
                    double bx = e.getClickedBlock().getX();
                    double by = e.getClickedBlock().getY();
                    double px = p.getLocation().getX();
                    double py = p.getLocation().getY();
                    double y = by - py;
                    double x = bx - px;
                    Location b = e.getClickedBlock().getLocation();
                    if (x < 0.0D) {
                        Location tp = null;
                        tp.setX(b.getX() - 1.0D);
                        tp.setY(b.getY());
                        tp.setZ(b.getZ());
                        p.teleport(tp);
                    }
                } else {
                    p.sendMessage(ChatColor.DARK_RED + "The Block you are clicking, has to be on the same Height as you.");
                }
        }




        if (a == Material.FEATHER &&
                item.containsEnchantment(Enchantment.ARROW_DAMAGE))
            if (mainRef.config.getBoolean("AllowFlyFeather")) {
                if (p.getGameMode() == GameMode.CREATIVE) {
                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "This item is not made for Creative");
                } else if (p.getAllowFlight()) {
                    p.setFlying(false);
                    p.setAllowFlight(false);
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GREEN + "You can fly now");
                    p.sendMessage("You can only fly with the fly feather in the inventory");
                    p.sendMessage("If you can't fly now, try again in 30 sek.");
                }
            } else {
                p.sendMessage(ChatColor.RED + "This feature is currently disabled");
            }
        if (a == Material.FEATHER &&
                item.containsEnchantment(Enchantment.SOUL_SPEED)) {
            double cooldownTime = mainRef.config.getDouble("launcher_cooldown_MilliSeconds");
            if (mainRef.Launcher_Cooldown.containsKey(p.getName())) {
                double secondsLeft = ((double) mainRef.Launcher_Cooldown.get(p.getName()) / 1000L) + cooldownTime / 1000.0D - ((double) System.currentTimeMillis() / 1000L);
                if (secondsLeft > 0.0D) {
                    p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "You cant use mainRef Item for another " + secondsLeft + " seconds!");
                    return;
                }
            }
            Player player = e.getPlayer();
            Location loctemp123412347860 = player.getLocation();
            org.bukkit.util.Vector vec = new org.bukkit.util.Vector(0.0D, loctemp123412347860.getY() + 50.0D, 0.0D);

            //0.0D, loctemp123412347860.getY() + 50.0D, 0.0D
            player.setVelocity(vec);
            mainRef.Launcher_Cooldown.put(p.getName(), System.currentTimeMillis());
        }
        if (a == Material.BLAZE_ROD &&
                item.containsEnchantment(Enchantment.FIRE_ASPECT))
            if (mainRef.config.getBoolean("AllowBlazer")) {
                Fireball f = (Fireball)e.getPlayer().launchProjectile(Fireball.class);
                f.setIsIncendiary(true);
                f.setYield(10.0F);
                p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.0F, 1.0F);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.ARROW &&
                item.containsEnchantment(Enchantment.FROST_WALKER))
            if (mainRef.config.getBoolean("AllowBower")) {
                Arrow f = e.getPlayer().launchProjectile(Arrow.class);
                f.setFireTicks(1000000);
                f.setVelocity(f.getVelocity().multiply(5));
                f.setShotFromCrossbow(true);
                f.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                f.setPierceLevel(100);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.BLAZE_POWDER &&
                item.containsEnchantment(Enchantment.FROST_WALKER))
            if (mainRef.config.getBoolean("AllowBoomer")) {
                Fireball f = (Fireball)e.getPlayer().launchProjectile(Fireball.class);
                f.setYield(0.0F);
                f.setVelocity(f.getVelocity().multiply(3));
                f.addPassenger(p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT));
                p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.0F, 1.0F);
            } else {
                p.sendMessage(ChatColor.RED +
                        "This Feature is currently disabled");
            }
        if (a == Material.PIG_SPAWN_EGG &&
                item.containsEnchantment(Enchantment.FIRE_ASPECT))
            e.setCancelled(true);
        if (a == Material.COOKED_PORKCHOP &&
                item.containsEnchantment(Enchantment.FIRE_ASPECT)) {
            e.setCancelled(true);
            if (mainRef.config.getBoolean("AllowPigCannon")) {
                Arrow f = (Arrow)e.getPlayer().launchProjectile(Arrow.class);
                f.setFireTicks(0);
                f.setVelocity(f.getVelocity().multiply(0.5D));
                f.setDamage(0.0D);
                f.setPickupStatus(Arrow.PickupStatus.DISALLOWED);
                f.setPierceLevel(0);
                f.addPassenger(p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.PIG));
                p.playSound(p.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 1.0F);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        }
        if (a == Material.BLAZE_ROD &&
                item.containsEnchantment(Enchantment.CHANNELING)) {
            double cooldownTime = mainRef.config.getDouble("wand_of_(massive)_boom_cooldown_MiliSeconds");
            if (mainRef.cooldown_wand_boom.containsKey(p.getName())) {
                double secondsLeft = ((double) mainRef.cooldown_wand_boom.get(p.getName()) / 1000L) + cooldownTime / 1000.0D - ((double) System.currentTimeMillis() / 1000L);
                if (secondsLeft > 0.0D) {
                    p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "You cant use mainRef Item for another " + secondsLeft + " seconds!");
                    return;
                }
            }
            Block prel = p.getTargetBlockExact(150);
            if (prel != null) {
                Location loc2345 = prel.getLocation();
                p.getWorld().createExplosion(loc2345, mainRef.config.getInt("Wand_of_Boom_Explosion_Strength"));
                mainRef.cooldown_wand_boom.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
            }
        }
        if (a == Material.BLAZE_ROD &&
                item.containsEnchantment(Enchantment.DIG_SPEED))
            if (p.isInvisible()) {
                p.setInvisible(false);
            } else {
                p.setInvisible(true);
            }
        if (a == Material.BLAZE_ROD &&
                item.containsEnchantment(Enchantment.LUCK)) {
            double cooldownTime = mainRef.config.getDouble("wand_of_(massive)_boom_cooldown_MilliSeconds");
            if (mainRef.cooldown_wand_boom.containsKey(p.getName())) {
                double secondsLeft = ((double) mainRef.cooldown_wand_boom.get(p.getName()).longValue() / 1000L) + cooldownTime / 1000.0D - (System.currentTimeMillis() / 1000L);
                if (secondsLeft > 0.0D) {
                    p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "You cant use mainRef Item for another " + secondsLeft + " seconds!");
                    return;
                }
            }
            Block prel = p.getTargetBlockExact(150);
            if (prel != null) {
                Location loc2345 = prel.getLocation();
                p.getWorld().createExplosion(loc2345, mainRef.config.getInt("Wand_of_Massive_Boom_Explosion_Strength"));
                mainRef.cooldown_wand_boom.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
            }
        }
        if (a == Material.NETHERITE_SWORD &&
                item.containsEnchantment(Enchantment.ARROW_DAMAGE))
            if (mainRef.config.getBoolean("AllowEndsword")) {
                Location location = p.getLocation().clone();
                Location location2 = p.getLocation().clone();
                Location location3 = p.getLocation().clone();
                Location location4 = p.getLocation().clone();
                Location location5 = p.getLocation().clone();
                Location location6 = p.getLocation().clone();
                Location location7 = p.getLocation().clone();
                Location location1 = p.getLocation().clone();
                location.add(p.getEyeLocation().getDirection().multiply(8));
                location2.add(p.getEyeLocation().getDirection().multiply(2));
                location3.add(p.getEyeLocation().getDirection().multiply(3));
                location4.add(p.getEyeLocation().getDirection().multiply(4));
                location5.add(p.getEyeLocation().getDirection().multiply(5));
                location6.add(p.getEyeLocation().getDirection().multiply(6));
                location7.add(p.getEyeLocation().getDirection().multiply(7));
                location1.add(p.getEyeLocation().getDirection().multiply(1));
                Block block = location.getBlock();
                Block block2 = location.getBlock();
                Block block3 = location.getBlock();
                Block block4 = location.getBlock();
                Block block5 = location.getBlock();
                Block block6 = location.getBlock();
                Block block7 = location.getBlock();
                Block block1 = location.getBlock();
                if (block1.isPassable()) {
                    if (block2.isPassable()) {
                        if (block3.isPassable()) {
                            if (block4.isPassable()) {
                                if (block5.isPassable()) {
                                    if (block6.isPassable()) {
                                        if (block7.isPassable()) {
                                            if (block.isPassable()) {
                                                p.teleport(location);
                                                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                                            } else {
                                                p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                                            }
                                        } else {
                                            p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                                        }
                                    } else {
                                        p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                                    }
                                } else {
                                    p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                                }
                            } else {
                                p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                            }
                        } else {
                            p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                        }
                    } else {
                        p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                    }
                } else {
                    p.sendMessage(ChatColor.BOLD + "" +ChatColor.BOLD + "There are Blocks in the Way");
                }
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.PRISMARINE_SHARD &&
                item.containsEnchantment(Enchantment.OXYGEN))
            if (mainRef.config.getBoolean("AllowBlitzer")) {
                Block prel = p.getTargetBlockExact(150);
                if (prel != null) {
                    Location l = prel.getLocation();
                    p.getWorld().strikeLightning(l);
                    p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0F, 1.0F);
                }
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.CRAFTING_TABLE &&
                item.containsEnchantment(Enchantment.PIERCING)) {
            e.setCancelled(true);
            if (mainRef.config.getBoolean("AllowCrafter")) {
                Player pl = e.getPlayer();
                Location l = pl.getLocation();
                pl.openWorkbench(null, true);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        }
    }

}
