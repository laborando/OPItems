package cel20.opitems.cmd.CommandCatchers;

import cel20.opitems.cmd.CommandExecutor;
import cel20.opitems.cmd.TabComp;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.List;

/**
 * ItemCommandCommandCatcher
 * <br>
 * Wrapper for cel20.items-cel20.cmd to brigadier-cel20.api
 */
public class ItemsCmdCC implements BasicCommand {
    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, @NonNull @NotNull String[] args) {

        CommandExecutor.execute("items", commandSourceStack, args);

    }

    @Override
    public @NotNull Collection<String> suggest(@NotNull CommandSourceStack commandSourceStack, @NonNull @NotNull String[] args) {

        List<String> comps = TabComp.onTabComplete(commandSourceStack.getSender(), "items", args);

        assert comps != null;
        return comps;

    }
}
