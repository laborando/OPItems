package cel20.opitems.cmd.superCmds;

import cel20.opitems.cmd.CmdExe;
import cel20.opitems.cmd.TabComp;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.List;

/**
 * Wrapper for opitems-cel20.cmd to brigadier-cel20.api
 */
public class Opitems implements BasicCommand {
    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, @NonNull @NotNull String[] args) {

        CmdExe.execute("opitems", commandSourceStack, args);

    }

    @Override
    public @NotNull Collection<String> suggest(@NotNull CommandSourceStack commandSourceStack, @NonNull @NotNull String[] args) {

        List<String> comps = TabComp.onTabComplete(commandSourceStack.getSender(), "opitems", args);

        assert comps != null;
        return comps;

    }
}
