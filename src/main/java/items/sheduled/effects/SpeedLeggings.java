
package items.sheduled.effects;

import items.NameSpaces;
import items.sheduled.BasicSchedule;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedLeggings extends BasicSchedule
{
    public void execute(){

        Bukkit.getOnlinePlayers().forEach(p -> {

            final ItemStack item = p.getInventory().getLeggings();
            if (item == null || item.getItemMeta() == null) {
                return;
            }

            String abl = item.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsAbilities, PersistentDataType.STRING);
            if (abl != null && abl.contains("speed_effect")) {

                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30, 4, false, false, false));
            }
        });
    }
}
