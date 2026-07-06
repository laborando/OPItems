package items.newer;

import items.EventManager;
import items.NameSpaces;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class ExpStorage {

    //Item-Lore Updater


    private static void updateLore(ItemMeta iMeta, int stored) {

        ArrayList<Component> lore = new ArrayList<>();

        lore.add(Component.text(""));
        lore.add(Component.text("Current exp stored: " + stored).color(TextColor.color(170, 0, 170)));
        lore.add(Component.text(""));
        lore.add(Component.text("OPItems").color(TextColor.color(85,85,85)).decoration(TextDecoration.ITALIC, false));

        iMeta.lore(lore);

    }

    //Store Event

    public static void event(final PlayerInteractEvent e) {


        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR))
            return;

        final Player p = e.getPlayer();

        if(p.isSneaking())
            return;

        e.setCancelled(true);

        int pxp = p.calculateTotalExperiencePoints();

        //For non-illegal amounts
        float hxp = pxp / 2.0f;
        int toStore = (int) hxp;

        ItemStack bottle = e.getItem();
        assert bottle != null;

        ItemMeta iMeta = bottle.getItemMeta();
        PersistentDataContainer pdc = iMeta.getPersistentDataContainer();

        int stored = pdc.get(NameSpaces.opitemsXPStorageAmount, PersistentDataType.INTEGER);

        p.giveExp(-toStore, false);
        stored += toStore;

        pdc.set(NameSpaces.opitemsXPStorageAmount, PersistentDataType.INTEGER, stored);

        updateLore(iMeta, stored);

        bottle.setItemMeta(iMeta);

    }


    //Throw bottle event
    //When thrown normally, XP-Bottles release on average 7 XP

    public static void event(final ExpBottleEvent e){

        ItemStack item = e.getEntity().getItem();

        String idns = EventManager.getIDNSorNullIfNotOPItems(item);
        if (idns == null) return;

        if(!idns.equalsIgnoreCase("opitems_49")){
            return;
        }

        e.setExperience(item.getItemMeta().getPersistentDataContainer().get(NameSpaces.opitemsXPStorageAmount, PersistentDataType.INTEGER));



    }


}
