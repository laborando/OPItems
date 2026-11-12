package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.cmd.cmd.opitems.sub.routines.GetChangelog;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

public class OpenChangelogCommand extends CCommand {

    public OpenChangelogCommand() {
        command = "changelog";
        isAdmin = false;
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        GetChangelog.displayChangelog(cs);

        return 0;
    }
}
