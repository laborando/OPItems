package cel20.opitems.api;

import cel20.opitems.api.subApis.CraftingAPI;
import cel20.opitems.api.subApis.EventAPI;
import cel20.opitems.api.subApis.ItemsAPI;
import cel20.opitems.api.subApis.PluginAPI;

/**
 * Simple API for OPItems <br>
 * If more control is needed, access internal code directly or write issue on github as a feature request
 */
public interface OPItemsAPI {

    //SubAPIs
    public CraftingAPI getCraftingAPI();
    public EventAPI getEventAPI();
    public PluginAPI getPluginAPI();
    public ItemsAPI getItemsAPI();
    public void enable();

    //Basic Information
    /**
     * @return Integer-Level of API implementation
     */
    public int getAPILevel();
}