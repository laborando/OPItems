package cel20.opitems.apiImplementation.subApis;

import cel20.opitems.api.subApis.PluginAPI;
import cel20.opitems.op.Main;

public class PluginAPIImplementation implements PluginAPI {
    @Override
    public String getOPItemsVersion() {
        return Main.opitemsVersion;
    }
}
