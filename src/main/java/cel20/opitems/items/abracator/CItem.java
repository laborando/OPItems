package cel20.opitems.items.abracator;

import cel20.opitems.filebased.overrides.RecipeOverride;
import cel20.opitems.op.Main;
import cel20.opitems.items.managers.RawItemsGenerator;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 * CItem holds the ID, Recipe, Result, Key and more metadata of an opitems
 */
public class CItem {

    public int id;
    public ShapedRecipe recipe;
    public ItemStack result;
    public boolean finished;
    public boolean enabled = true;
    public Material[] materials = new Material[9];
    public NamespacedKey key;
    public String name;
    boolean shouldAddToTotalItems = true;

    /***
     * Creates CItem and adds itself to Total Items
     * @param id
     * @param recipe
     * @param result
     */
    public CItem(int id, ShapedRecipe recipe, ItemStack result) {

        this.id = id;
        this.recipe = recipe;
        this.result = result;

        finishCreation();

    }

    /**
     * Generates dangling {@link CItem} from a source {@link RecipeOverride} object with the result being retrieved from {@link RawItemsGenerator} <br>
     * CItems generated via this constructor will NOT be added to Total Items!
     * @param source
     */
    public CItem(RecipeOverride source){
        id = source.id;
        setResultFromOPItemsID(id);

        for (int i = 0; i < 9; i++) {
            setMaterialAt(source.materials[i], i);
        }

        shouldAddToTotalItems = false;
    }

    /**
     * Instanced this item, Result must still be set and Recipe must be set
     * <br>
     * Then finishCreation must be called to add to the recipes
     *
     * @param id
     */
    public CItem(int id) {
        this.id = id;
    }

    /***
     * Gets new, empty buidler
     * @param id
     * @return
     */
    public static CItem getBuilder(int id) {
        return new CItem(id);
    }

    /**
     * Gets new builder with no recipe but preloaded OPItem from id
     *
     * @param id
     * @return
     */
    public static CItem getOPBuilder(int id) {
        return new CItem(id).setResultFromOPItemsID(id);
    }

    //------------------------------------

    /**
     * Sets the Material at the respective Coords
     *
     * @param material Material to set to
     * @param targets  The ints which corresponds to the slots in the 3x3 crafting grids to set the material
     */
    public CItem setMaterialAt(Material material, int... targets) {

        for (int target : targets) {
            if (target > 8) {
                Main.getInstance().getLogger().warning("[OPItems] Err: Cannot set Material: int target to big for grid: " + id);
            }
            materials[target] = material;
        }

        return this;
    }

    //-----------------------------------

    public CItem setId(int id) {
        if (finished) {
            Main.getInstance().getLogger().warning("[OPItems] Err: Cannot set ItemID: Item has already been created: " + id);
            return this;
        }

        this.id = id;
        return this;
    }


    //----------------------------------

    public CItem setResult(ItemStack result) {
        if (finished) {
            Main.getInstance().getLogger().warning("[OPItems] Err: Cannot set ItemResult: Item has already been created: " + id);

            return this;
        }
        this.result = result;
        return this;
    }

    /**
     * Sets the result to an preconfigured OPItems if defined int the class RawItemsgenerator
     *
     * @param id
     * @return
     */
    public CItem setResultFromOPItemsID(int id) {

        if (finished) {
            Main.getInstance().getLogger().warning("[OPItems] Err: Cannot set ItemResult: Item has already been created: " + id);

            return this;
        }

        result = RawItemsGenerator.getItem(id, -5, -5);

        return this;
    }

    //----------------------------

    /**
     * Finishes and adds to Total Recipes
     */
    public void finishCreation() {

        if (finished) {
            Main.getInstance().getLogger().warning("[OPItems] Err: Item has already been created: " + id);
            return;
        }

        if (result == null) {
            Main.getInstance().getLogger().warning("[OPItems] Err: ItemResult is Null: " + id);
            return;
        }


        key = new NamespacedKey(Main.getInstance(), "opitems_" + id);

        recipe = new ShapedRecipe(key, result);

        recipe.shape("abc", "def", "ghi");

        if (materials[0] != null)
            recipe.setIngredient('a', materials[0]);
        if (materials[1] != null)
            recipe.setIngredient('b', materials[1]);
        if (materials[2] != null)
            recipe.setIngredient('c', materials[2]);
        if (materials[3] != null)
            recipe.setIngredient('d', materials[3]);
        if (materials[4] != null)
            recipe.setIngredient('e', materials[4]);
        if (materials[5] != null)
            recipe.setIngredient('f', materials[5]);
        if (materials[6] != null)
            recipe.setIngredient('g', materials[6]);
        if (materials[7] != null)
            recipe.setIngredient('h', materials[7]);
        if (materials[8] != null)
            recipe.setIngredient('i', materials[8]);

        name = PlainTextComponentSerializer.plainText().serialize(result.displayName()).replaceAll("\\[", "").replace("]", "");


        if(shouldAddToTotalItems)
            TotalItems.items.add(this);

        finished = true;


    }

    /**
     * Finishes the Build
     * <br>
     * Build pattern
     */
    public void build() {
        finishCreation();
    }

    /**
     * Finishes the Build
     * <br>
     * Returns itself
     */
    public CItem finish() {
        build();
        return this;
    }

}
