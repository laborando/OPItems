package items.classic;

import cel20.op.GlobalVars;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TeleportSword {

    static Map<String, Long> cooldown = new HashMap<>();

    @Deprecated
    public static void handleOld(Player p){

        cooldown.computeIfAbsent(p.getName(), k -> (long) -69);

        if(!((System.currentTimeMillis() - cooldown.get(p.getName())) >= GlobalVars.teleportSwordCD)) {
            return;
        }
        cooldown.put(p.getName(), System.currentTimeMillis());


        //Needs rework lol
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
                                        p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
                                    }
                                } else {
                                    p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
                                }
                            } else {
                                p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
                            }
                        } else {
                            p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
                        }
                    } else {
                        p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
                    }
                } else {
                    p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
                }
            } else {
                p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
            }
        } else {
            p.sendMessage(ChatColor.BOLD + "" + ChatColor.BOLD + "There are Blocks in the Way");
        }
    }
}
