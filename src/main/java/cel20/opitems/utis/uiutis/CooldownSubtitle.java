package cel20.opitems.utis.uiutis;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

public class CooldownSubtitle {

    /**
     * Shows a generic cooldown subtitle
     *
     * @param p Target
     */
    public static void showCooldown(Player p) {


        p.sendActionBar(

                Component.text()
                        .append(Component.text("Cooldown...", NamedTextColor.RED))

        );


    }

}
