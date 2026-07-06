package cmd.cmds;

import cel20.op.Main;
import metrics.WorkerLogger;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

//Error report to active Logger
public class Report {

    public static void execute(String label, CommandSender sender, @NonNull @NotNull String[] args){

        WorkerLogger logger = WorkerLogger.activeLogger;

        StringBuilder rep = new StringBuilder("Report from: " + sender + ", Version: " + Main.opitemsVersion + ": ");

        args[0] = " ";

        for (String arg : args) {
            rep.append(arg).append(" ");
        }

        logger.sendLog(rep.toString());

        sender.sendMessage("Your error report was sent.");
    }

}
