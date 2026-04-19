package items;

import items.normal.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventManager implements Listener {

    //Maps
    public static Map<String, Consumer<PlayerInteractEvent>> PlayerInteractEventMap = new HashMap<>();
    public static Map<String, Consumer<ProjectileLaunchEvent>> ProjectileLaunchEventMap = new HashMap<>();
    public static Map<String, Consumer<BlockPlaceEvent>> BlockPlaceEventMap = new HashMap<>();



    //Lists
    public static List<Consumer<EntityBlockFormEvent>> EntityBlockFormEventList = new ArrayList<>();
    public static List<Consumer<ProjectileHitEvent>> ProjectileHitEventList = new ArrayList<>();



    public static void innitEventManager(Plugin p) {

        //MainHandPlayerInteractionEvents
        PlayerInteractEventMap.put("opitems_27", TntLayer::event);
        PlayerInteractEventMap.put("opitems_31", WandOfHome::event);
        PlayerInteractEventMap.put("opitems_33", WandOfBlocks::event);
        PlayerInteractEventMap.put("opitems_35", SkullImitator::event);

        //BlockPlaceEvent
        BlockPlaceEventMap.put("opitems_35", SkullImitator::event);

        //ProjectileLaunchEvent
        ProjectileLaunchEventMap.put("opitems_32", TntBow::onProjectileLaunch);

        //ProjectileHitEvent
        ProjectileHitEventList.add(TntBow::onProjectileHit);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {

        ItemStack item = e.getItem();
        if (item == null) return;

        if (e.getAction().isLeftClick()) return;

        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<PlayerInteractEvent> eventer = PlayerInteractEventMap.get(idns);

        if(eventer == null) return;

        eventer.accept(e);

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockPlaceEvent e) {

        Player p = e.getPlayer();

        final ItemStack item = p.getInventory().getItemInMainHand();

        if (item.getItemMeta() == null) {
            return;
        }

        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<BlockPlaceEvent> eventer = BlockPlaceEventMap.get(idns);

        if(eventer == null) return;

        eventer.accept(e);

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final ProjectileLaunchEvent e) {

        if(!(e.getEntity().getShooter() instanceof Player shooter)) return;

        ItemStack item = shooter.getInventory().getItemInMainHand();

        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<ProjectileLaunchEvent> eventer = ProjectileLaunchEventMap.get(idns);

        if(eventer == null) return;

        eventer.accept(e);

    }



    @EventHandler(priority = EventPriority.HIGH)
    public void event(final ProjectileHitEvent e) {
        ProjectileHitEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }


    public static String getIDNSorNullIfNotOPItems(ItemStack item){
        PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();

        if(!(pdc.has(NameSpaces.opitemsMarker) || pdc.has(NameSpaces.itemTypeIDNS))) return null;

        if (!pdc.get(NameSpaces.opitemsMarker, PersistentDataType.STRING).equals("true")) return null;

        return pdc.get(NameSpaces.itemTypeIDNS, PersistentDataType.STRING);
    }

}
