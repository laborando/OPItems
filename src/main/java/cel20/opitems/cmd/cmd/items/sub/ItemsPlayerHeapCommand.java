package cel20.opitems.cmd.cmd.items.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.manage.Items;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ItemsPlayerHeapCommand extends CCommand {

    public ItemsPlayerHeapCommand(){
        context = "Displays the amount of items loaded by each player.";
        command = "player_heap";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if(cs.isOp()){

            cs.sendMessage("Per-player item count:");
            final Items items = new Items();
            items.ItemsPlayerHeap(cs);

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }

        return 0;
    }
}
