package cel20.opitems.api;

import cel20.opitems.api.subApis.CraftingAPI;
import cel20.opitems.api.subApis.EventAPI;
import cel20.opitems.api.subApis.PluginAPI;

public interface OPItemsAPI {

    //SubAPIs
    public CraftingAPI getCraftingAPI();
    public EventAPI getEventAPI();
    public PluginAPI getPluginAPI();


    //Basic Information
    /**
     * @return Integer-Level of API implementation
     */
    public int getAPILevel();
}