package apiImplementation.subApis;

import api.subApis.PluginAPI;
import cel20.op.Main;

public class PluginAPIImplementation implements PluginAPI {
    @Override
    public String getOPItemsVersion() {
        return Main.opitemsVersion;
    }
}
