package items.abracator;

import cel20.op.Main;
import items.managers.RawItemsGenerator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.io.BufferedWriter;

public class CItem {

    public int id;
    public ShapedRecipe recipe;
    public ItemStack result;
    public boolean finished;
    public boolean enabled = true;
    public Material[] materials = new Material[9];
    public NamespacedKey key;

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
     * Instanced this item, Result must still be set and Recipe must be set
     * <br>
     * Then finishCreation must be called to add to the recipes
     *
     * @param id
     */
    public CItem(int id) {
        this.id = id;
    }

    public static CItem getBuilder(int id){
        return new CItem(id);
    }

    public static CItem getOPBuilder(int id){
        return new CItem(id).setResultFromOPItemsID(id);
    }

    //------------------------------------

    /**
     * Sets the Material at the Coords
     *
     * @param material Material to set to
     * @param targets The ints which corresponds to the slots in the 3x3 crafting grids to set the material
     */
    public CItem setMaterialAt(Material material, int... targets) {

        for (int target : targets) {
            if(target > 8){
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

    public CItem setResultFromOPItemsID(int id) {
        if (finished) {
            Main.getInstance().getLogger().warning("[OPItems] Err: Cannot set ItemResult: Item has already been created: " + id);

            return this;
        }

        result = RawItemsGenerator.getItem(id, -5, -5);

        return this;
    }

    //----------------------------

    /***
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

        if(materials[0] != null)
            recipe.setIngredient('a', materials[0]);
        if(materials[1] != null)
            recipe.setIngredient('b', materials[1]);
        if(materials[2] != null)
            recipe.setIngredient('c', materials[2]);
        if(materials[3] != null)
            recipe.setIngredient('d', materials[3]);
        if(materials[4] != null)
            recipe.setIngredient('e', materials[4]);
        if(materials[5] != null)
            recipe.setIngredient('f', materials[5]);
        if(materials[6] != null)
            recipe.setIngredient('g', materials[6]);
        if(materials[7] != null)
            recipe.setIngredient('h', materials[7]);
        if(materials[8] != null)
            recipe.setIngredient('i', materials[8]);

        TotalItems.items.add(this);
        finished = true;
    }

    /**
     * Finishes the Build
     * <br>
     * Build pattern
     */
    public void build()
    {
        finishCreation();
    }

}
