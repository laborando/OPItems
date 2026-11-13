package cel20.opitems.cmd.cmd.opitems.sub;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.items.managers.upgrade.ItemUpgrader;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UpgradeItemCommand extends CCommand {

    public UpgradeItemCommand() {
        context = "Tries to upgrade the OPItems currently held in the main-hand to a more recent version.";
        command = "upgrade_item";
        isAdmin = false;
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {


        if (cs instanceof Player)
            ItemUpgrader.upgradeItem((Player) cs);
        else
            cs.sendMessage("This command can only be executed by a player!");

        return 0;
    }
}
