package items.normal;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class RandomBottle {

    public static void event(final PlayerItemConsumeEvent e) {


        Random r = new Random();

        PotionEffectType value = PotionEffectType.values()[r.nextInt(PotionEffectType.values().length)];

        PotionEffect effect = new PotionEffect(value, r.nextInt(50) * 20 + 200, r.nextInt(5) + 1);

        e.getPlayer().addPotionEffect(effect);

        e.setCancelled(true);

    }

}
