package cel20.opitems.op.load;

import cel20.opitems.cmd.commandCatchers.ItemsCmdCC;
import cel20.opitems.cmd.commandCatchers.OpitemsCC;
import cel20.opitems.op.Main;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

public class Commands {

    public static void setAllExecutors(Main m) {

        m.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            //noinspection SpellCheckingInspection
            commands.registrar().register("opitems", new OpitemsCC());
            commands.registrar().register("items", new ItemsCmdCC());
        });

    }

}
