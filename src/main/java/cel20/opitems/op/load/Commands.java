package cel20.opitems.op.load;

import cel20.opitems.op.Main;
import cel20.opitems.cmd.CommandCatchers.ItemsCmdCC;
import cel20.opitems.cmd.CommandCatchers.OpitemsCC;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

public class Commands {

    public static void setAllExecutors(Main m) {

        m.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register("opitems", new OpitemsCC());
            commands.registrar().register("items", new ItemsCmdCC());
        });

    }

}
