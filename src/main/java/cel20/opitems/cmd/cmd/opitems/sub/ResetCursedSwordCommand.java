package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.items.normal.CursedSword;
import cel20.opitems.op.Main;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ResetCursedSwordCommand extends CCommand {

    public ResetCursedSwordCommand() {
        command = "reset_cursed_sword_list";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {
        if (cs.isOp()) {

            CursedSword.resetList();
            cs.sendMessage("The List is now cleared.");

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
