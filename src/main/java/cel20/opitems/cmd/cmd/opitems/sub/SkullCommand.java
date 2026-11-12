package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.utis.Celutis;
import cel20.opitems.utis.update.UpdateNotify;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkullCommand extends CCommand {

    public SkullCommand() {
        command = "skull";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if (cs.isOp()) {

            String target = "";
            try {
                target = args[1];
            } catch (Exception ignored) {}

            if (!(cs instanceof Player p)) {
                cs.sendMessage("This command can only be executed by a player!");
            } else if (target.trim().isEmpty()) {
                cs.sendMessage(ChatColor.RED + "Usage: /opitems skull <player_name>");
            } else {
                p.getInventory().addItem(Celutis.getSkullByName(target));
            }

        }else{
            cs.sendMessage(ChatColor.RED + "You lack the permissions to execute this command!");
        }

        return 0;
    }
}
