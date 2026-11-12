package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.cmd.cmd.opitems.sub.routines.GetOPID;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

public class GetIDCommand extends CCommand {

    public GetIDCommand() {
        command = "get_id";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        GetOPID.displayOPID(cs);

        return 0;
    }
}
