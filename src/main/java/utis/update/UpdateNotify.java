package utis.update;

import cel20.op.Main;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class UpdateNotify {

    static File noNotifyFile;
    static List<String> noNotify = new ArrayList<>();




    public static void innit(Plugin p) {

        noNotifyFile = new File(p.getDataFolder(), "noNotify");

        boolean isNew = false;

        try {
            isNew = noNotifyFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(isNew)
            return;

        load();
    }

    public static void save(){
        try {

            BufferedWriter writer = Files.newBufferedWriter(noNotifyFile.toPath(), StandardOpenOption.APPEND);

            StringBuilder toWrite = new StringBuilder();

            for (String player : noNotify) {
                toWrite.append(player).append(";");
            }

            writer.write(toWrite.toString());

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(){
        try {

            if(!noNotifyFile.exists()){
                System.out.println(noNotifyFile.getAbsolutePath() + " doesn't exist?!");
            }

            String blocked = Files.readString(noNotifyFile.toPath());

            String[] players =  blocked.split(";");

            noNotify.clear();
            noNotify.addAll(List.of(players));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void event(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();

        if (!p.isOp()) return;

        if(noNotify.contains(e.getPlayer().getName())) return;

        if(!Main.cUpdater.shouldUpdate)
            return;

        p.sendMessage("An update for OPItems has been found: v" + Main.opitemsVersion + " -> v" + Main.cUpdater.highestVersion.version);
        p.sendMessage("Update: /opitems update | Hide this message: /opitems um");
    }

    public static void toggle(CommandSender sender) {

        if(!(sender instanceof Player)){
            sender.sendMessage(NamedTextColor.RED + "Only players can execute this command");
            return;
        }

        Player p = (Player) sender;

        String name = p.getName();

        if(noNotify.contains(name)){

            p.sendMessage(ChatColor.BLUE + "You will receive OPItems update messages again.");

            //Mehrere nennungen möglich
            while (noNotify.contains(name)) {
                noNotify.remove(name);
            }

        }else{

            p.sendMessage(ChatColor.BLUE + "You wont receive any OPItems update messages anymore.");
            noNotify.add(name);

        }

    }
}
