package cel20.opitems.cmd.cmd.items;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.cmd.cmd.general.CommandOperatorQuestionmark;
import cel20.opitems.cmd.cmd.items.sub.ItemsPlayerHeapCommand;
import cel20.opitems.cmd.cmd.items.sub.ItemsRemoveNowCommand;
import cel20.opitems.cmd.cmd.items.sub.ItemsRemoverCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class ItemsCmd extends CCommand {

    public ItemsCmd() {
        this.command = "items";

        this.subCommands = new HashMap<>();

        //Add subcommands
        register(new CommandOperatorQuestionmark());
        register(new ItemsRemoverCommand());
        register(new ItemsRemoveNowCommand());
        register(new ItemsPlayerHeapCommand());
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        String sub = args.length == 0 ? null : args[0];

        executeSubcommand(sub, cs, args, CSStack, top);

        return 0;
    }
}
