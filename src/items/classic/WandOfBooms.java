package items.classic;

import cel20.op.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WandOfBooms {

    public static void handleAlpha(Main mainRef, Player p){

            double cooldownTime = mainRef.config.getDouble("wand_of_(massive)_boom_cooldown_MilliSeconds");
            if (mainRef.cooldown_wand_boom.containsKey(p.getName())) {
                double secondsLeft = ((double) mainRef.cooldown_wand_boom.get(p.getName()).longValue() / 1000L) + cooldownTime / 1000.0D - (System.currentTimeMillis() / 1000L);
                if (secondsLeft > 0.0D) {
                    p.sendMessage(ChatColor.RED + "" +ChatColor.BOLD + "You cant use this Item for another " + secondsLeft + " seconds!");
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

    public static void handleBeta(Main mainRef, Player p){

        double cooldownTime = mainRef.config.getDouble("wand_of_(massive)_boom_cooldown_MilliSeconds");
        if (mainRef.cooldown_wand_boom.containsKey(p.getName())) {
            double secondsLeft = ((double) mainRef.cooldown_wand_boom.get(p.getName()) / 1000L) + cooldownTime / 1000.0D - ((double) System.currentTimeMillis() / 1000L);
            if (secondsLeft > 0.0D) {
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You cant use this Item for another " + secondsLeft + " seconds!");
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
}
