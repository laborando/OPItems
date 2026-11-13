package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.items.normal.Landmine;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class UnloadWorldCommand extends CCommand {

    public UnloadWorldCommand() {
        context = "Unloads a world \n Usage: /opitems unload_world <target_world>";
        command = "unload_world";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {
        if (cs.isOp()) {

            String target = null;
            try {
                target = args[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                cs.sendMessage(ChatColor.GOLD + "Missing argument: Target world!");
                return -1;
            }

            Bukkit.getServer().unloadWorld(target, false);
            cs.sendMessage(ChatColor.GOLD + "Operation Executed!");


        } else {
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }


        return 0;
    }
}
