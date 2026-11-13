package cel20.opitems.cmd.cmd.items.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.manage.Items;
import cel20.opitems.op.Main;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ItemsRemoverCommand extends CCommand {

    public ItemsRemoverCommand(){
        context = "Removes all loaded item entities after a warning and a delay of 30 seconds.";
        command = "remove";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if(cs.isOp()){

            final Items items = new Items();
            Bukkit.broadcastMessage(new StringBuilder().append(ChatColor.RED).append("All dropped items will be removed in 30 seconds!").toString());
            Bukkit.getScheduler().runTaskLater(Main.getPluginInstance(), items::removeItems, 600L);

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
