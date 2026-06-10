package utis.uiutis;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;

public class CooldownSubtitle {

    /**
     * Shows a generic cooldown subtitle
     * @param p Target
     */
    public static void showCooldown(Player p){


        p.sendActionBar(

                Component.text()
                        .append(Component.text("Cooldown...", NamedTextColor.RED))

        );


    }

}
