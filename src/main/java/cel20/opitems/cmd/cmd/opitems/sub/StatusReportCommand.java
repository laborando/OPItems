package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.utis.Logutis;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class StatusReportCommand extends CCommand {

    public StatusReportCommand() {
        context = "Generates a debug status report and saves it to a file.";
        command = "status";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {
        if (cs.isOp()) {


            Logutis.createReportAndLog();
            cs.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_RED + "Report generated!");


        } else {
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
