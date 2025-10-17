package items.classic;

import cel20.op.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class OldItems implements Listener {

    public static Main mainRef = Main.getInstance();


    @EventHandler(priority = EventPriority.HIGH)
    public void event(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        Action action = e.getAction();

        if (e.getHand() != EquipmentSlot.HAND)
            return;

        if (!(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
            return;


        ItemStack item = p.getInventory().getItemInMainHand();
        if (item == null)
            return;
        Material a = item.getType();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (a == Material.NETHERITE_SWORD &&
                    item.getItemMeta().getDisplayName().contains(ChatColor.BOLD + "Enderpearler")) {
                EnderpearlSword.handle(p);
            }
        }


        if (a == Material.FEATHER &&
                item.containsEnchantment(Enchantment.ARROW_DAMAGE))
            if (mainRef.config.getBoolean("AllowFlyFeather")) {
                if (p.getGameMode() == GameMode.CREATIVE) {
                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "This item is not usable in creative mode");
                } else if (p.getAllowFlight()) {
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.RED + "Flying disabled");
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GREEN + "Flying enabled");
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
                    p.sendMessage(ChatColor.RED + "You cant use this Item for another " + secondsLeft + " seconds!");
                    return;
                }
            }
            Player player = e.getPlayer();
            Location loctemp123412347860 = player.getLocation();
            org.bukkit.util.Vector vec = new org.bukkit.util.Vector(0.0D, loctemp123412347860.getY() + 50, 0.0D);

            //0.0D, loctemp123412347860.getY() + 50.0D, 0.0D
            player.setVelocity(vec);
            mainRef.Launcher_Cooldown.put(p.getName(), System.currentTimeMillis());
        }
        if (a == Material.BLAZE_ROD &&
                item.containsEnchantment(Enchantment.FIRE_ASPECT))
            if (mainRef.config.getBoolean("AllowBlazer")) {
                Fireball f = e.getPlayer().launchProjectile(Fireball.class);
                f.setIsIncendiary(true);
                f.setYield(10.0F);
                p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.0F, 1.0F);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.ARROW &&
                item.containsEnchantment(Enchantment.FROST_WALKER))
            if (mainRef.config.getBoolean("AllowBower")) {
                Bower.handle(p);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.BLAZE_POWDER &&
                item.containsEnchantment(Enchantment.FROST_WALKER))
            if (mainRef.config.getBoolean("AllowBoomer")) {
                Fireball f = (Fireball) e.getPlayer().launchProjectile(Fireball.class);
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
                PigCannon.handle(p);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        }
        if (a == Material.BLAZE_ROD &&
                item.containsEnchantment(Enchantment.CHANNELING)) {
            WandOfBooms.handleBeta(mainRef, p);
        }

        if (a == Material.BLAZE_ROD &&
                item.containsEnchantment(Enchantment.DIG_SPEED))
            if (p.isInvisible()) {
                p.setInvisible(false);
            } else {
                p.setInvisible(true);
            }
        if (a == Material.BLAZE_ROD && item.containsEnchantment(Enchantment.LUCK)) {
            WandOfBooms.handleAlpha(mainRef, p);
        }
        if (a == Material.NETHERITE_SWORD &&
                item.containsEnchantment(Enchantment.ARROW_DAMAGE))
            if (mainRef.config.getBoolean("AllowEndsword")) {

                TeleportSword.handleOld(p);

            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.PRISMARINE_SHARD &&
                item.containsEnchantment(Enchantment.OXYGEN))
            if (mainRef.config.getBoolean("AllowBlitzer")) {
               Blitzer.handle(p);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        if (a == Material.CRAFTING_TABLE &&
                item.containsEnchantment(Enchantment.PIERCING)) {
            e.setCancelled(true);
            if (mainRef.config.getBoolean("AllowCrafter")) {
                Player pl = e.getPlayer();
                pl.openWorkbench(null, true);
            } else {
                p.sendMessage(ChatColor.RED + "This Feature is currently disabled");
            }
        }
    }

}
