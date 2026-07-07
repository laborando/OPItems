package cel20.opitems.apiImplementation.subApis;

import cel20.opitems.api.subApis.EventAPI;
import cel20.opitems.items.EventManager;
import cel20.opitems.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class EventAPIImplementation implements EventAPI {
    @Override
    public void disableEvents() {
        EventManager.enabled = false;
    }

    @Override
    public void enableEvent() {
        EventManager.enabled = true;
    }

    @Override
    public boolean eventsEnabled() {
        return EventManager.enabled;
    }

}
