package apiImplementation;

import api.OPItemsAPI;
import api.subApis.CraftingAPI;
import api.subApis.EventAPI;
import api.subApis.PluginAPI;
import apiImplementation.subApis.CraftingApiImplementation;
import apiImplementation.subApis.EventAPIImplementation;
import apiImplementation.subApis.PluginAPIImplementation;

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
    public int getAPILevel() {
        return 1;
    }

}
