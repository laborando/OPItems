package cel20.opitems.cmd.cmd.general;

import cel20.opitems.cmd.CCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

@SuppressWarnings("SpellCheckingInspection")
public class CommandOperatorQuestionmark extends CCommand {

    public CommandOperatorQuestionmark(){
        command = "?";
    }

    @Override
    public int execute(CommandSender cs, String[] args, CommandSourceStack CSStack, CCommand top) {

        if(args.length > 1){

            for (int i = 1; i < args.length; i++) {

                String target = args[i];
                HashMap<String, CCommand> subs = top.subCommands;

                if(subs == null){
                    cs.sendMessage(top.command + " has no subcommands!");
                    return -5;
                }

                CCommand cCommand = subs.get(target);

                if(cCommand == null)
                    cs.sendMessage(target  + " was not found.");
                else
                    top = cCommand;
            }


        }

        cs.sendMessage("Command structure of " + top.command + ":");

        if(cs.isOp())
            cs.sendMessage("Including admin commands.");
        else
            cs.sendMessage("Excluding admin and debug commands.");


        writeCmdStructure(top, 0, cs);


        cs.sendMessage("X");
        cs.sendMessage("");
        cs.sendMessage("Context information of the command: ");
        cs.sendMessage(top.context);
        cs.sendMessage("");
        cs.sendMessage("Run </command ? subcommand ... > to view help for subcommands");

        return 0;
    }

    public void writeCmdStructure(CCommand current, int depth, CommandSender cs){

        StringBuilder left = new StringBuilder();
        left.repeat("|    ", Math.max(0, depth));
        left.append("|-");

        cs.sendMessage(left + current.command);

        if(current.subCommands == null)
            return;

        current.subCommands.forEach( (key, command) -> {
            if(!command.isAdmin || cs.isOp())
                writeCmdStructure(command, depth+1, cs);
        });

        cs.sendMessage(left.subSequence(0, left.length()-1).toString());
    }

}
