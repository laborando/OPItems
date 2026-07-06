package api;

import api.subApis.CraftingAPI;
import api.subApis.EventAPI;
import api.subApis.PluginAPI;

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