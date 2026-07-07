package cel20.opitems.utis.uiutis;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;

/**
 * Utilities for showing action-bars
 */
public class SubtitleUtis {

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

    /**
     * Shows a custom subtitle in <p style="color: red;">red</p>
     *
     * @param p Target
     */
    public static void showSubtitle(Player p, String message) {


        p.sendActionBar(

                Component.text()
                        .append(Component.text(message, NamedTextColor.RED))

        );
    }


}
