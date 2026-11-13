package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.items.normal.Landmine;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ResetLandminesCommand extends CCommand {

    public ResetLandminesCommand() {
        context = "Clears all landmines.";
        command = "reset_landmines";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {
        if (cs.isOp()) {

            Landmine.reset();
            cs.sendMessage("All landmines have been removed.");

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
