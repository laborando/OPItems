package items;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

import java.lang.reflect.Field;


public class Riptider implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final ProjectileLaunchEvent e) {
        Bukkit.broadcastMessage("f");

        if (e.getEntity().getType() != EntityType.TRIDENT) return;

        Bukkit.broadcastMessage("m");

        ProjectileSource p = e.getEntity().getShooter();

        if(!(p instanceof Player)) return;




    }
}
