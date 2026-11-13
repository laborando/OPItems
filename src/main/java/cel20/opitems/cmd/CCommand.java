package cel20.opitems.cmd;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public abstract class CCommand {

    public HashMap<String, CCommand> subCommands;

    public String context = "This command has no set context";
    public boolean isAdmin = true;
    public String command;
    public abstract int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top);

    protected int executeSubcommand(String subCommand, CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if (subCommand == null){
            cs.sendMessage("This command requires an additional subcommand!");
            return -3;
        }

        if (subCommands == null) {
            cs.sendMessage("Subcommand not found! There are no further subcommands at: " + subCommand);
            return -2;
        }

        CCommand subCmd = subCommands.get(subCommand.toLowerCase());

        if(subCmd == null){
            cs.sendMessage("Subcommand not found! This subcommand was not found: " + subCommand);
            return -1;
        }

        return subCmd.execute(cs, args, CSStack, top);

    }

    //SubCmd registeries;
    /**
     * Registers a Subcommand to the list of commands registered
     * <br>
     * This registers a general, high level, subcommand, currently, at their respective class
     */
    public void register(CCommand command) {

        String key = command.command;

        if(key == null || key.isEmpty() || subCommands.containsKey(key))
            Bukkit.getLogger().warning("[OPItems] There was an attempt to register a sub-command, but it was unnamed or was already registered: " + key);

        subCommands.put(key, command);
    }

    /**
     * Unregisters a Subcommand
     * @param key
     * @return True if the command was registered before
     */
    public boolean unregister(String key){
        CCommand r = subCommands.remove(key);

        return r != null;
    }
}
