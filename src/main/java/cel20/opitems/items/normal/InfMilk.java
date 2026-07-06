package cel20.opitems.items.normal;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;

public class InfMilk {


    public static void event(final PlayerItemConsumeEvent e) {

        for (PotionEffect activePotionEffect : e.getPlayer().getActivePotionEffects()) {

            e.getPlayer().removePotionEffect(activePotionEffect.getType());

        }

        e.setCancelled(true);

    }

}
