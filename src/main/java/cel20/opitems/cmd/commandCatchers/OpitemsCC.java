package cel20.opitems.cmd.commandCatchers;

import cel20.opitems.cmd.Commands;
import cel20.opitems.cmd.TabComp;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.List;

/**
 * OPItemsCommandCommandCatcher
 * <br>
 * Wrapper for opitems-cel20.cmd to brigadier-cel20.api
 */
public class OpitemsCC implements BasicCommand {
    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, @NonNull @NotNull String[] args) {


        Commands.execute("opitems", commandSourceStack, args);

    }

    @Override
    public @NotNull Collection<String> suggest(@NotNull CommandSourceStack commandSourceStack, @NonNull @NotNull String[] args) {

        List<String> comps = TabComp.onTabComplete(commandSourceStack.getSender(), "opitems", args);

        return comps;

    }
}
