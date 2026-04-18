package cmd.superCmds;

import cmd.CmdExe;
import cmd.TabComp;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.List;

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
