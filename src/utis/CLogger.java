package utis;

import cel20.op.Main;
import org.bukkit.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CLogger {

    static int secDel = 300;
    static boolean enabled = false;
    static List<String> collected = new CopyOnWriteArrayList<>();
    static String loc = "";

    public static void startAsync(String s, int secDelNew){

        secDel = secDelNew;
        loc = s + "/logs/log_" + System.currentTimeMillis() + ".cel20";
        File tf = new File(s + "/logs");
        tf.mkdirs();
        log("CLogger Started ASYNCED " + System.currentTimeMillis());
        Thread t = new Thread(new Runnable() {
            public void run() {

                try {
                    Thread.sleep(secDel* 1000L);
                } catch (InterruptedException e) {
                    log("Automated Error Report: " + e.getMessage());
                }

                flushNow();

            }
        });
        t.start();

        enabled = true;

    }

    public static void startSynced(String s, int secDelNew){
        secDel = secDelNew;
        loc = s + "/logs/log_" + System.currentTimeMillis() + ".cel20";
        System.out.println(loc);
        File tf = new File(s + "/logs");
        tf.mkdirs();
        log("CLogger Started SYNCED " + System.currentTimeMillis());
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPluginInstance(), new Runnable() {
            @Override
            public void run() {
                flushNow();
            }
        }, 0L, secDel*20L);

        enabled = true;
    }

    public static void flushNow(){
        if(enabled) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(loc));

                collected.forEach(s -> {
                    try {
                        writer.write(s);
                        writer.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                writer.close();
                collected.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String s){
        if(enabled){
            collected.add(s);
        }

    }

    public static void logAndFlush(String s){
        if(enabled){
            collected.add(s);
            flushNow();
        }


    }

    public static boolean isEnabled(){
        return enabled;
    }

}
