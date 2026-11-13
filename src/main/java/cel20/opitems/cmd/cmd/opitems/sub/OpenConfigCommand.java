package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.cmd.cmd.opitems.sub.routines.OpenConfig;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

public class OpenConfigCommand extends CCommand {

    public OpenConfigCommand() {
        context = "Opens the config window for OPItems.";
        command = "config";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        //Checks for permissions inside
        OpenConfig.openConfig(cs);

        return 0;
    }
}
