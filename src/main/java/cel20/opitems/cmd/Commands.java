package cel20.opitems.cmd;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.HashMap;

public class Commands {

    public static HashMap<String, CCommand> commands;

    /**
     * Executes the command if registered
     * @param cmd
     * @param CSStack
     * @param args
     */
    public static void execute(String cmd, CommandSourceStack CSStack, String[] args) {

        CCommand toExecute = commands.get(cmd.toLowerCase());

        if (toExecute == null) {
            CSStack.getSender().sendMessage(ChatColor.RED + "[OPItems] There was an error finding that command at level 0.");
            return;
        }

        toExecute.execute(CSStack.getSender(), args, CSStack, toExecute);
    }

    /**
     * Registers a Command to the list of commands registered
     * <br>
     * This registers a general, high level, command for subcommands, register at their respective class
     */
    public static void register(CCommand command) {

        String key = command.command;

        if(key == null || key.isEmpty() || commands.containsKey(key))
            Bukkit.getLogger().warning("[OPItems] There was an attempt to register a command, but it was unnamed or was already registered: " + key);

        commands.put(key, command);
    }

    /**
     * Unregisters a command
     * @param key
     * @return True if the command was registered before
     */
    public static boolean unregister(String key){
        CCommand r = commands.remove(key);

        return r != null;
    }

    public static void innit(){
        commands = new HashMap<>();
    }


}
