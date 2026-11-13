package cel20.opitems.api.subApis;

import cel20.opitems.cmd.Commands;

/**
 * OPItems recipes are primarily directly built into OPItems <br>
 * They can be disabled if they are listed in the disabled File (Saved State) / disabled List (Runtime) <br>
 * OPItems recipes can be overwritten via RecipeOverrides through files (see <serverDirectory>/plugins/OPItems/overrides/recipe/readme.txt) or this interface
 */
public interface CommandsAPI {

    /**
     * Returns a new Commands Object as reference to the in-use static Commands Class
     */
    Commands getReference();

    /**
     * Removes all OPItem commands
     */
    void removeAllCommands();

    /**
     * Adds all default commands (To the commands object). Will log errors if they have not been removed beforehand
     */
    void addDefaultCommands(int id);
}
