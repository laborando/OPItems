package cel20.opitems.api;

import cel20.opitems.api.subApis.CraftingAPI;
import cel20.opitems.api.subApis.EventAPI;
import cel20.opitems.api.subApis.ItemsAPI;
import cel20.opitems.api.subApis.PluginAPI;

/**
 * Simple API for OPItems <br>
 * If more control is needed, access internal code directly or write issue on GitHub as a feature request
 */
public interface OPItemsAPI {

    //SubAPIs
    CraftingAPI getCraftingAPI();
    EventAPI getEventAPI();
    PluginAPI getPluginAPI();
    ItemsAPI getItemsAPI();
    void enable();

    //Basic Information
    /**
     * @return Integer-Level of API implementation
     */
    int getAPILevel();
}