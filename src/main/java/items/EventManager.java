package items;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import gui.itemEnableUI.EnableClickHandler;
import gui.recipiesUI.RUIClickHandler;
import items.classic.*;
import items.classic.Sponges.SuperSpongeStarter;
import items.managers.NoCrafting;
import items.newer.WandOfWarden;
import items.normal.*;
import items.normal.ws.Workstation;
import items.normal.ws.WsGUIHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import utis.update.UpdateNotify;

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
    public static Map<String, Consumer<PlayerBucketEmptyEvent>> PlayerBucketEmptyEventMap = new HashMap<>();
    public static Map<String, Consumer<PlayerFishEvent>> PlayerFishEventMap = new HashMap<>();
    public static Map<String, Consumer<PlayerItemConsumeEvent>> PlayerItemConsumeEventMap = new HashMap<>();
    public static Map<String, Consumer<PlayerElytraBoostEvent>> PlayerElytraBoostEventMap = new HashMap<>();



    //Lists
    public static List<Consumer<EntityBlockFormEvent>> EntityBlockFormEventList = new ArrayList<>();
    public static List<Consumer<ProjectileHitEvent>> ProjectileHitEventList = new ArrayList<>();
    public static List<Consumer<BlockDropItemEvent>> BlockDropItemEventList = new ArrayList<>();
    public static List<Consumer<BlockPhysicsEvent>> BlockPhysicsEventList = new ArrayList<>();
    public static List<Consumer<PlayerInteractEvent>> PlayerInteractEventList = new ArrayList<>();
    public static List<Consumer<BlockBreakEvent>> BlockBreakEventList = new ArrayList<>();
    public static List<Consumer<PlayerChangedWorldEvent>> PlayerChangedWorldEventList = new ArrayList<>();
    public static List<Consumer<PlayerPreLoginEvent>> PlayerPreLoginEventList = new ArrayList<>();
    public static List<Consumer<PlayerQuitEvent>> PlayerQuitEventList = new ArrayList<>();
    public static List<Consumer<EntityDamageByEntityEvent>> EntityDamageByEntityEventList = new ArrayList<>();
    public static List<Consumer<EntityDamageEvent>> EntityDamageEventList = new ArrayList<>();
    public static List<Consumer<PlayerDropItemEvent>> PlayerDropItemEventList = new ArrayList<>();
    public static List<Consumer<PlayerRespawnEvent>> PlayerRespawnEventList = new ArrayList<>();
    public static List<Consumer<InventoryClickEvent>> InventoryClickEventList = new ArrayList<>();
    public static List<Consumer<CraftItemEvent>> CraftItemEventList = new ArrayList<>();
    public static List<Consumer<PlayerJoinEvent>> PlayerJoinEventList = new ArrayList<>();




    public static void innitEventManager(Plugin p) {

        //MainHandPlayerInteractionEvents
        PlayerInteractEventMap.put("opitems_4", Bower::handle);
        PlayerInteractEventMap.put("opitems_5", Blazer::event);
        PlayerInteractEventMap.put("opitems_6", Boomer::event);
        PlayerInteractEventMap.put("opitems_8", PigCannon::handle);
        PlayerInteractEventMap.put("opitems_10", TeleportSword::event);
        PlayerInteractEventMap.put("opitems_12", Crafter::event);
        PlayerInteractEventMap.put("opitems_13", FlyingStick::event);
        PlayerInteractEventMap.put("opitems_11", Blitzer::handle);
        PlayerInteractEventMap.put("opitems_20", WandOfBoom::event);
        PlayerInteractEventMap.put("opitems_21", WandOfMassiveBoom::event);
        PlayerInteractEventMap.put("opitems_22", InvisibilityStick::event);
        PlayerInteractEventMap.put("opitems_26", EnderpearlSword::handle);
        PlayerInteractEventMap.put("opitems_27", TntLayer::event);
        PlayerInteractEventMap.put("opitems_29", DimensionWand::event);
        PlayerInteractEventMap.put("opitems_31", WandOfHome::event);
        PlayerInteractEventMap.put("opitems_33", WandOfBlocks::event);
        PlayerInteractEventMap.put("opitems_34", Portal2go::event);
        PlayerInteractEventMap.put("opitems_35", SkullImitator::event);
        PlayerInteractEventMap.put("opitems_41", WandOfWarden::event);
        PlayerInteractEventMap.put("opitems_42", InfRocket::event);
        PlayerInteractEventMap.put("opitems_44", Workstation::event);

        //PlayerElytraBoostEvent
        PlayerElytraBoostEventMap.put("opitems_42", InfRocket::event);

        //BlockPlaceEvent
        BlockPlaceEventMap.put("opitems_24", SuperSpongeStarter::waterEvent);
        BlockPlaceEventMap.put("opitems_25", SuperSpongeStarter::lavaEvent);
        BlockPlaceEventMap.put("opitems_35", SkullImitator::event);
        BlockPlaceEventMap.put("opitems_36", Landmine::event);

        //ProjectileLaunchEvent
        ProjectileLaunchEventMap.put("opitems_32", TntBow::onProjectileLaunch);
        ProjectileLaunchEventMap.put("opitems_43", Piercer::onProjectileLaunch);

        //PlayerBucketEmptyEvent
        PlayerBucketEmptyEventMap.put("opitems_38", InfWaterBucket::event);

        //PlayerFishEventMap
        PlayerFishEventMap.put("opitems_15", HookOfVelectory::onFish);

        //PlayerItemConsumeEvent
        PlayerItemConsumeEventMap.put("opitems_40" , EternalSteak::event);
        PlayerItemConsumeEventMap.put("opitems_45" , RandomBottle::event);

        //ProjectileHitEvent
        ProjectileHitEventList.add(TntBow::onProjectileHit);
        ProjectileHitEventList.add(Piercer::onProjectileHit);

        //BlockDropItemEvent
        BlockDropItemEventList.add(Landmine::event);

        //BlockPhysicsEvent
        BlockPhysicsEventList.add(Landmine::event);

        //PlayerInteractEventList
        PlayerInteractEventList.add(Landmine::event);

        //BlockBreakEvent
        BlockBreakEventList.add(Landmine::event);

        //PlayerChangedWorldEvent
        PlayerChangedWorldEventList.add(DimensionWand::event);
        PlayerChangedWorldEventList.add(CursedSword::event);


        //PlayerPreLoginEvent
        PlayerPreLoginEventList.add(DimensionWand::event);

        //PlayerQuitEvent
        PlayerQuitEventList.add(DimensionWand::event);

        //EntityDamageByEntityEvent
        EntityDamageByEntityEventList.add(CursedSword::event);

        //EntityDamageEvent
        EntityDamageEventList.add(AntiFall::event);

        //PlayerDropItemEvent
        PlayerDropItemEventList.add(InvisibilityStick::event);
        PlayerDropItemEventList.add(FlyingStick::event);

        //PlayerRespawnEvent
        PlayerRespawnEventList.add(InvisibilityStick::event);
        PlayerRespawnEventList.add(FlyingStick::event);

        //InventoryClickEvent
        InventoryClickEventList.add(WsGUIHandler::onInventoryClick);
        InventoryClickEventList.add(RUIClickHandler::onInventoryClick);
        InventoryClickEventList.add(EnableClickHandler::onInventoryClick);


        //CraftItemEvent
        CraftItemEventList.add(NoCrafting::event);

        //PlayerJoinEvent
        PlayerJoinEventList.add(UpdateNotify::event);
    }



    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerInteractEvent e) {

        //List

        PlayerInteractEventList.forEach(consumer -> {
            consumer.accept(e);
        });

        //Map

        ItemStack item = e.getItem();
        if (item == null) return;

        if (e.getAction().isLeftClick()) return;



        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<PlayerInteractEvent> eventer;


        eventer = PlayerInteractEventMap.get(idns);

        if (eventer == null) return;

        eventer.accept(e);

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerElytraBoostEvent e) {
        //Map

        ItemStack item = e.getFirework().getItem();

        if (item == null) return;

        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<PlayerElytraBoostEvent> eventer;


        eventer = PlayerElytraBoostEventMap.get(idns);

        if (eventer == null) return;

        eventer.accept(e);

    }


    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerBucketEmptyEvent e) {

        ItemStack item = e.getPlayer().getInventory().getItemInMainHand();

        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<PlayerBucketEmptyEvent> eventer;


        eventer = PlayerBucketEmptyEventMap.get(idns);

        if (eventer == null) return;

        eventer.accept(e);
    }


    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerItemConsumeEvent e) {

        ItemStack item = e.getItem();

        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<PlayerItemConsumeEvent> eventer;

        eventer = PlayerItemConsumeEventMap.get(idns);

        if (eventer == null) return;

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
    public void event(final PlayerFishEvent e) {

        ItemStack item = e.getPlayer().getInventory().getItemInMainHand();

        String idns = getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        Consumer<PlayerFishEvent> eventer = PlayerFishEventMap.get(idns);

        if(eventer == null) return;

        eventer.accept(e);

    }



    @EventHandler(priority = EventPriority.HIGH)
    public void event(final ProjectileHitEvent e) {
        ProjectileHitEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockDropItemEvent e) {
        BlockDropItemEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockPhysicsEvent e) {
        BlockPhysicsEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final BlockBreakEvent e) {
        BlockBreakEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerChangedWorldEvent e) {
        PlayerChangedWorldEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerPreLoginEvent e) {
        PlayerPreLoginEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerQuitEvent e) {
        PlayerQuitEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageByEntityEvent e) {
        EntityDamageByEntityEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageEvent e) {
        EntityDamageEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerDropItemEvent e) {
        PlayerDropItemEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerRespawnEvent e) {
        PlayerRespawnEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final InventoryClickEvent e) {
        InventoryClickEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final CraftItemEvent e) {
        CraftItemEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerJoinEvent e) {
        PlayerJoinEventList.forEach(consumer -> {
            consumer.accept(e);
        });
    }


    public static String getIDNSorNullIfNotOPItems(ItemStack item){
        if(item == null) return null;

        PersistentDataContainer pdc = item.getItemMeta().getPersistentDataContainer();

        if(!(pdc.has(NameSpaces.opitemsMarker) || pdc.has(NameSpaces.itemTypeIDNS))) return null;

        if (!pdc.get(NameSpaces.opitemsMarker, PersistentDataType.STRING).equals("true")) return null;

        return pdc.get(NameSpaces.itemTypeIDNS, PersistentDataType.STRING);
    }

}
