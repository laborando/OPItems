package cel20.opitems.apiImplementation.subApis;

import cel20.opitems.api.subApis.CraftingAPI;
import cel20.opitems.filebased.overrides.RecipeOverride;
import cel20.opitems.filebased.overrides.RecipeOverrides;
import cel20.opitems.items.managers.abracator.TotalItems;
import cel20.opitems.op.Main;

import java.util.List;

public class CraftingApiImplementation implements CraftingAPI {
    @Override
    public void enableCrafting() {
        TotalItems.addAllRecipes();
    }

    @Override
    public void disableCrafting() {
        TotalItems.disableCrafting();
    }

    @Override
    public void disableItem(int id) {
        TotalItems.disable(id);
    }

    @Override
    public void enableItem(int id) {
        TotalItems.enable(id);
    }

    @Override
    public List<RecipeOverride> getRecipeOverrides() {
        return RecipeOverrides.overrides;
    }

    @Override
    public void addRecipeOverride(RecipeOverride recipe) {
        RecipeOverrides.overrides.add(recipe);
    }

    @Override
    public boolean removeRecipeOverride(RecipeOverride recipe) {
        return RecipeOverrides.overrides.remove(recipe);
    }

    @Override
    public void reloadRecipes() {
        TotalItems.disableCrafting();
        TotalItems.addAllRecipes();
        TotalItems.innit(Main.getInstance());
    }

    @Override
    public void saveRecipeState() {
        TotalItems.save();
    }
}
