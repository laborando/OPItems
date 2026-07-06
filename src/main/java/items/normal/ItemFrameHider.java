package items.normal;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class ItemFrameHider {

    public static void event(final PlayerInteractEntityEvent e) {

        Entity rightClicked = e.getRightClicked();
        if(rightClicked.getType() == EntityType.ITEM_FRAME || rightClicked.getType() == EntityType.GLOW_ITEM_FRAME){

           if(rightClicked.isInvisible()){
               rightClicked.setInvisible(false);
           }else{
               rightClicked.setInvisible(true);
           }

           e.setCancelled(true);

        }



    }

}
