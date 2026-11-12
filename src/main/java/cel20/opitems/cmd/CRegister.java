package cel20.opitems.cmd;

import cel20.opitems.cmd.cmd.items.ItemsCmd;
import cel20.opitems.cmd.cmd.opitems.OPItemsCmd;

public class CRegister {

    public static void registerCommands(){
        Commands.innit();

        OPItemsCmd opItemsCmd = new OPItemsCmd();
        Commands.register(opItemsCmd);

        ItemsCmd itemsCmd = new ItemsCmd();
        Commands.register(itemsCmd);


    }

}
