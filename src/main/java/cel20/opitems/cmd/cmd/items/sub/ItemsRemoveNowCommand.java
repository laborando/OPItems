package cel20.opitems.cmd.cmd.items.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.manage.Items;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ItemsRemoveNowCommand extends CCommand {

    public ItemsRemoveNowCommand(){
        context = "Removes all loaded item entities now.";
        command = "remove_now";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if(cs.isOp()){

            final Items items = new Items();
            items.removeItems();
            cs.sendMessage("All loaded items were removed.");

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
