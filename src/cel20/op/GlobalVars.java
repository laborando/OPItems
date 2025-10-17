package cel20.op;

import org.bukkit.NamespacedKey;

public class GlobalVars {

    public static String uuid = ";";

    public static boolean newerFeaturesEnabled = false;

    public static long hookOfVelectoryCD = 100L;

    public static long blitzerCD = 100L;

    public static long bowerCD = 100L;

    public static long pigCanonCD = 100L;
    public static long teleportSwordCD = 100L;
    public static long enderPearlSwordCD = 100L;

    public static boolean craftingDisabled = false;

    public static int piercerDamageLevel;
    public static int piercerKnockbackLevel;
    public static String itemVersionLevel = "1.0";
    public static int spongeClearRange = 1;

    public static NamespacedKey opitemsMarker = new NamespacedKey(Main.getPluginInstance(), "opitemsMarker");
    public static NamespacedKey opitemsAbilities = new NamespacedKey(Main.getPluginInstance(), "opitemsAbilities");
    public static NamespacedKey opitemsCosmetic = new NamespacedKey(Main.getPluginInstance(), "opitemsCosmetic");
    public static NamespacedKey opitemsGui = new NamespacedKey(Main.getPluginInstance(), "opitemsGui");
}
