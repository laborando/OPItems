package cel20.opitems.apiImplementation.subApis;

import cel20.opitems.api.subApis.ItemsAPI;
import cel20.opitems.items.managers.RawItemsGenerator;
import org.bukkit.inventory.ItemStack;

public class ItemsAPIImplementation implements ItemsAPI {
    @Override
    public ItemStack getOPItem(int id) {
        return RawItemsGenerator.getItem(id);
    }

    @Override
    public ItemStack getOPItem(int id, int... lvl) {
        return RawItemsGenerator.getItem(id, lvl);
    }
}
