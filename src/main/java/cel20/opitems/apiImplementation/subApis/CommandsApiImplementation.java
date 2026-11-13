package cel20.opitems.apiImplementation.subApis;

import cel20.opitems.api.subApis.CommandsAPI;
import cel20.opitems.cmd.CRegister;
import cel20.opitems.cmd.Commands;

public class CommandsApiImplementation implements CommandsAPI {

    @SuppressWarnings("InstantiationOfUtilityClass")
    @Override
    public Commands getReference() {
        return new Commands();
    }

    @Override
    public void removeAllCommands() {
        Commands.commands.forEach((s, c) -> Commands.unregister(s));
    }

    @Override
    public void addDefaultCommands(int id) {
        CRegister.registerCommands();
    }
}
