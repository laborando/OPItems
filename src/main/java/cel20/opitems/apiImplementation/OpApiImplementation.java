package cel20.opitems.apiImplementation;

import cel20.opitems.api.OPItemsAPI;
import cel20.opitems.api.subApis.CraftingAPI;
import cel20.opitems.api.subApis.EventAPI;
import cel20.opitems.api.subApis.ItemsAPI;
import cel20.opitems.api.subApis.PluginAPI;
import cel20.opitems.apiImplementation.subApis.CraftingApiImplementation;
import cel20.opitems.apiImplementation.subApis.EventAPIImplementation;
import cel20.opitems.apiImplementation.subApis.ItemsAPIImplementation;
import cel20.opitems.apiImplementation.subApis.PluginAPIImplementation;
import cel20.opitems.metrics.MetricsHandler;


public class OpApiImplementation implements OPItemsAPI {

    @Override
    public CraftingAPI getCraftingAPI() {
        return new CraftingApiImplementation();
    }

    @Override
    public EventAPI getEventAPI() {
        return new EventAPIImplementation();
    }

    @Override
    public PluginAPI getPluginAPI() {
        return new PluginAPIImplementation();
    }

    @Override
    public ItemsAPI getItemsAPI() {
        return new ItemsAPIImplementation();
    }

    @Override
    public void enable() {
        MetricsHandler.updateAPIState(true);
    }

    @Override
    public int getAPILevel() {
        return 2;
    }

}
