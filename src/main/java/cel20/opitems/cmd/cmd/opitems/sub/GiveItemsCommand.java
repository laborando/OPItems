package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.cmd.cmd.opitems.sub.routines.GiveLogic;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class GiveItemsCommand extends CCommand {

    public GiveItemsCommand() {
        command = "give";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if(cs.isOp()){

            String[] cleanedArgs = new String[4];

            for (int i = 0; i < 4; i++) {
                cleanedArgs[i] = args.length > i+1 ? args[i+1] : null;
            }

            GiveLogic.executeGive(cs, cleanedArgs[0], cleanedArgs[1], cleanedArgs[2], cleanedArgs[3]);

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }

        return 0;
    }
}
