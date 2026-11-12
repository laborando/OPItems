package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.manage.Items;
import cel20.opitems.op.Test;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExecuteCurrentTestCommand extends CCommand {

    public ExecuteCurrentTestCommand(){
        command = "run_test";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if(cs.isOp()){

            cs.sendMessage("Running current debug-test.");
            Test.runCurrentTest((Player) cs);

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
