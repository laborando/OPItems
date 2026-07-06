package cel20.opitems.apiImplementation.subApis;

import cel20.opitems.api.subApis.CraftingAPI;
import cel20.opitems.items.abracator.TotalItems;

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
