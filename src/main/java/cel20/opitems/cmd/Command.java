package cel20.opitems.cmd;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

public abstract class Command {

    String command, subCommand;
    public abstract void execute(CommandSender cs, String[] args, CommandSourceStack CSStack);

}
