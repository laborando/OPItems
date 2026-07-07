package cel20.opitems.items;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

/**
 * Global Namespaces regarding items, stored static
 */
public class NameSpaces {

    public static NamespacedKey opitemsMarker;
    public static NamespacedKey opitemsAbilities;
    public static NamespacedKey opitemsCosmetic;
    public static NamespacedKey opitemsGui;
    public static NamespacedKey opitemsGuiPage;
    public static NamespacedKey opitemsGuiID;
    public static NamespacedKey opitemsGuiFunction;
    public static NamespacedKey itemTypeIDNS;
    public static NamespacedKey itemTypeVL;
    public static NamespacedKey opitemsXPStorageAmount;


    /**
     * Sets up name-spaces
     */
    public static void innitNameSpaces(Plugin p) {

        opitemsMarker = new NamespacedKey(p, "opitemsMarker");
        opitemsAbilities = new NamespacedKey(p, "opitemsAbilities");
        opitemsCosmetic = new NamespacedKey(p, "opitemsCosmetic");
        opitemsGui = new NamespacedKey(p, "opitemsGui");
        opitemsGuiPage = new NamespacedKey(p, "opitemsGuiPage");
        opitemsGuiID = new NamespacedKey(p, "opitemsGuiID");
        opitemsGuiFunction = new NamespacedKey(p, "opitemsGuiFunction");

        itemTypeIDNS = new NamespacedKey(p, "itemTypeID");
        itemTypeVL = new NamespacedKey(p, "itemVersionLevel");

        opitemsXPStorageAmount = new NamespacedKey(p, "opitemsXPStorageAmount");

    }

}
