package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.manage.AutoItems;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CancelAutoItemRemoval extends CCommand {

    public CancelAutoItemRemoval() {
        context = "Cancel the automated periodical removal of dropped items if activated in the config.";
        command = "cancel_automated_item_removal";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if (cs.isOp()) {
            AutoItems.cancelAutomatedItemRemoval();
            cs.sendMessage("Automated item removal cancelled until server restart!");
        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }

        return 0;
    }
}
