package cel20.op.load;

import cel20.op.Main;
import cmd.CmdExe;
import cmd.TabComp;

public class Commands {
    
    public static void setAllexecutors(Main m){

        m.getCommand("opitems").setExecutor(new CmdExe());
        m.getCommand("items").setExecutor(new CmdExe());
        m.getCommand("opitemsversion").setExecutor(new CmdExe());
        m.getCommand("opitemshelp").setExecutor(new CmdExe());
        m.getCommand("opitems").setTabCompleter(new TabComp());
        m.getCommand("items").setTabCompleter(new TabComp());
    }
    
}
