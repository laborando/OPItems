package cel20.opitems.api.subApis;

import cel20.opitems.filebased.overrides.RecipeOverride;

import java.util.List;

/**
 * OPItems recipes are primarily directly built into OPItems <br>
 * They can be disabled if they are listed in the disabled File (Saved State) / disabled List (Runtime) <br>
 * OPItems recipes can be overwritten via RecipeOverrides through files (see <serverDirectory>/plugins/OPItems/overrides/recipe/readme.txt) or this interface
 */
public interface CraftingAPI {

    /**
     * Re-enables crafting as configured
     */
    void enableCrafting();

    /**
     * Disables Crafting
     */
    void disableCrafting();

    /**
     * Disables specific OPItem <br>
     * Does not override config
     */
    void disableItem(int id);

    /**
     * Enables specific OPItems <br>
     * Does not override config
     */
    void enableItem(int id);

    /**
     * Gets the list storing the parsed recipe overrides
     */
    List<RecipeOverride> getRecipeOverrides();

    /**
     * Adds a recipe override - execute reloadRecipes() after!
     */
    void addRecipeOverride(RecipeOverride recipe);

    /**
     * Removes a recipe override - execute reloadRecipes() after!
     * @return true if this list contained the specified element
     */
    boolean removeRecipeOverride(RecipeOverride recipe);

    /**
     * Reloads recipes from disk! Disabled items will be reset as at server start or when saveRecipeState() was last called <br>
     * Overrides will be not reloaded from disk
     */
    void reloadRecipes();

    void saveRecipeState();
}
