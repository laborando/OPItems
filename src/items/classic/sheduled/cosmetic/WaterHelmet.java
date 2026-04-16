
package items.classic.sheduled.cosmetic;

import cel20.op.GlobalVars;
import items.classic.sheduled.BasicSchedule;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WaterHelmet extends BasicSchedule {
    public void execute(){

        Bukkit.getOnlinePlayers().forEach(p -> {

            final ItemStack item = p.getInventory().getHelmet();
            if (item == null || item.getItemMeta() == null) {
                return;
            }

            String abl = item.getItemMeta().getPersistentDataContainer().get(GlobalVars.opitemsAbilities, PersistentDataType.STRING);
            if (abl != null && abl.contains("water_breathing")) {

                p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 30, 1, false, false, false));
            }
        });
    }
}
