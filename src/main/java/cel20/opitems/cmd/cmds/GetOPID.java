package cel20.opitems.cmd.cmds;

import cel20.opitems.utis.OPItemAdjectiv;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetOPID {
    public static void execute(CommandSender sender) {

        if(sender instanceof Player p){

            ItemStack target = p.getInventory().getItemInMainHand();

            String idns = OPItemAdjectiv.getIDNSorNullIfNotOPItems(target);

            if(idns == null){
                sender.sendMessage("The item does not have an ID-attribute set. It is not an OPItems, too old or something has gone wrong.");
            }else{
                sender.sendMessage("The IDNS of the item is: " + idns);
            }

        }else{
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
        }

    }
}
