package items.normal;

import cel20.op.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import utis.Celutis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WandOfBlocks {

    //33

    static Map<String, List<FallingBlock>> PlayersBlocks;
    static Map<String, Long> Cooldown;

    static {
        WandOfBlocks.PlayersBlocks = new HashMap<>();
        WandOfBlocks.Cooldown = new HashMap<>();
    }

    public static void event(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();

        if (!e.getPlayer().isSneaking()) {

            for (Block b2 : Celutis.getRandomBlocks(e.getPlayer().getLocation(), 5)) {


                FallingBlock fallingBlock = b2.getWorld().spawn(b2.getLocation(), FallingBlock.class);

                fallingBlock.setBlockData(b2.getBlockData());

                fallingBlock.setCancelDrop(true);
                fallingBlock.setDropItem(true);
                fallingBlock.setGravity(false);
                fallingBlock.setHurtEntities(true);

                fallingBlock.setVelocity(new Vector(0, 0.1, 0));
                b2.setType(Material.AIR);
                Celutis.addValueToMultiMapStringXFallingBlock(PlayersBlocks, p.getName(), fallingBlock);
            }

        } else {

            Block bt = p.getTargetBlockExact(300, FluidCollisionMode.NEVER);

            if (bt == null) {
                return;
            }

            Cooldown.computeIfAbsent(p.getName(), k -> (long) -20000);

            if (!((System.currentTimeMillis() - Cooldown.get(p.getName().toString())) >= 5000)) {

                p.sendMessage(String.valueOf(ChatColor.GRAY) + ChatColor.ITALIC + "Still on cooldown...");

            } else {


                Cooldown.put(p.getName(), System.currentTimeMillis());
                String keyToIterate = p.getName();

                List<FallingBlock> valuesForKey = PlayersBlocks.get(keyToIterate);

                if (valuesForKey != null) {
                    for (FallingBlock v : valuesForKey) {
                        Location lt2 = v.getLocation();
                        lt2.setY(v.getWorld().getHighestBlockYAt(lt2) + 2);

                        v.teleport(lt2);
                        v.setVelocity(Celutis.getVectorBetweenLocations(v.getLocation(), bt.getLocation()));

                    }



                    BukkitRunnable colChecker = new BukkitRunnable() {



                        int var = 5;
                        boolean executed = false;

                        @Override
                        public void run() {

                            var--;
                            if (var <= 0) {
                                makeBoom(p, bt.getLocation());

                                executed = true;
                            }

                            if (executed) {

                                this.cancel();

                            }

                        }
                    };

                    colChecker.runTaskTimer(Main.getInstance(), 0, 1);

                }
            }

        }


    }


    public static boolean makeBoom(Player p, Location blockTarget) {

        String kti = p.getName().toString();
        List<FallingBlock> vfk = WandOfBlocks.PlayersBlocks.get(kti);

        if (vfk == null) {
            return false;
        }

        Bukkit.getServer().getScheduler().runTaskLater(Main.getPluginInstance(), () -> {

            Random random = new Random();


            double dist = p.getLocation().distance(blockTarget);

            for (FallingBlock v : vfk) {

                if (v == null)
                    break;

                Location rl = blockTarget;
                rl.setX(blockTarget.getX() + (random.nextDouble()-0.5) * 0.1 * vfk.size());
                rl.setZ(blockTarget.getZ() + (random.nextDouble() - 0.5) * 0.1 * vfk.size());
                rl.setY(blockTarget.getY());

                if (random.nextBoolean()) {
                    rl.setX(blockTarget.getX());
                    rl.setZ(blockTarget.getZ());
                }

                v.teleport(rl);

                v.getWorld().createExplosion(rl, 4);

                v.setTicksLived(599);

            }

            WandOfBlocks.PlayersBlocks.remove(p.getName().toString());

        }, 5);


        return true;

    }
}
