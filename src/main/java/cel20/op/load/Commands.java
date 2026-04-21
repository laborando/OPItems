package cel20.op.load;

import cel20.op.Main;
import cmd.superCmds.ItemsCmd;
import cmd.superCmds.Opitems;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

public class Commands {
    
    public static void setAllexecutors(Main m){



        m.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            commands.registrar().register("opitems", new Opitems());
            commands.registrar().register("items", new ItemsCmd());
        });

    }
    
}
