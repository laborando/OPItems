package items.normal;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InfRocket {

    public static void event(final PlayerElytraBoostEvent e) {


        e.setShouldConsume(false);


    }

    public static void event(PlayerInteractEvent e) {

        if (!(e.getAction() == Action.RIGHT_CLICK_AIR))
            e.setUseItemInHand(Event.Result.DENY);

    }
}
