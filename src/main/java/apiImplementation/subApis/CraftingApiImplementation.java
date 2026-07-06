package apiImplementation.subApis;

import api.subApis.CraftingAPI;
import items.abracator.TotalItems;

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
}
