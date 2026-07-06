package cel20.opitems.items.sheduled.cosmetic;

import cel20.opitems.items.NameSpaces;
import cel20.opitems.items.sheduled.BasicSchedule;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class FireShoe extends BasicSchedule {
    public void execute() {

        Bukkit.getOnlinePlayers().forEach(p -> {

            final ItemStack item = p.getInventory().getBoots();
            if (item == null || item.getItemMeta() == null) {
                return;
            }

            String abl = item.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsCosmetic, PersistentDataType.STRING);
            if (abl != null && abl.contains("fire_norm")) {

                p.getLocation().getWorld().spawnParticle(Particle.FLAME, p.getLocation(), 30, 0.3, 0.8, 0.3, 0.05);

            }
        });
    }
}
