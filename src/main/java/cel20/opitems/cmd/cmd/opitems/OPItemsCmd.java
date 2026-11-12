package cel20.opitems.cmd.cmd.opitems;

import cel20.opitems.cmd.CCommand;
import cel20.opitems.cmd.cmd.general.CommandOperatorQuestionmark;
import cel20.opitems.cmd.cmd.opitems.sub.*;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class OPItemsCmd extends CCommand {

    public OPItemsCmd(){
        isAdmin = false;
        this.command = "opitems";

        this.subCommands = new HashMap<>();

        register(new CommandOperatorQuestionmark());
        register(new ExecuteCurrentTestCommand());
        register(new OpenConfigCommand());
        register(new GiveItemsCommand());
        register(new OpenChangelogCommand());
        register(new UpdateNotifyCommand());
        register(new UpgradeItemCommand());
        register(new CancelAutoItemRemoval());
        register(new SkullCommand());
        register(new HelpCommand());
        register(new GetIDCommand());
        register(new UpdateCommand());
        register(new VersionCommand());
        register(new ResetCursedSwordCommand());
        register(new DisplayListCursedSwordCommand());
        register(new ResetLandminesCommand());
        register(new UnloadWorldCommand());
        register(new StatusReportCommand());
        register(new RecipeCommand());
        register(new RemoveRecipesCommand());

    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        String sub = args.length == 0 ? null : args[0];

        executeSubcommand(sub, cs, args, CSStack, top);

        return 0;
    }
}
