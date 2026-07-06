package cel20.opitems.utis;

import cel20.opitems.op.Main;
import org.bukkit.Bukkit;

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

    /**
     * Starts the CLogger service asynchronously using an independent thread <br>
     *
     * @param folder
     * @param saveInterval
     */
    public static void startAsync(String folder, int saveInterval) {

        secDel = saveInterval;
        loc = folder + "/logs/log_" + System.currentTimeMillis() + ".cel20";
        File tf = new File(folder + "/logs");
        tf.mkdirs();
        log("CLogger started as asynchronously" + System.currentTimeMillis());
        Thread t = new Thread(() -> {

            try {
                Thread.sleep(secDel * 1000L);
            } catch (InterruptedException e) {
                log("CLogger Exception: " + e.getMessage());
            }

            flushNow();

        });

        t.start();

        enabled = true;

    }


    /**
     * Starts the CLogger service synchronously using the bukkit scheduler <br>
     *
     * @param folder
     * @param saveInterval
     */
    public static void startSynced(String folder, int saveInterval) {
        secDel = saveInterval;
        loc = folder + "/logs/log_" + System.currentTimeMillis() + ".cel20";
        System.out.println(loc);
        File tf = new File(folder + "/logs");
        tf.mkdirs();
        log("CLogger started synchronously " + System.currentTimeMillis());
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPluginInstance(), CLogger::flushNow, 0L, secDel * 20L);

        enabled = true;
    }

    /**
     * Flushes the Buffer of collected Messages to a previously set file
     *
     */
    public static void flushNow() {
        if (enabled) {
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

    /**
     * Logs a Message to the Buffer <br>
     * If CLogger is not enabled, starts it synchronized
     *
     * @param s
     */
    public static void log(String s) {
        if (enabled) {
            collected.add(s);
        } else {
            startAsync(Main.getInstance().getDataFolder().toString(), 20);
            log(s);
        }

    }

    /**
     * Logs a Message to the Buffer and flushes it<br>
     * If CLogger is not enabled, starts it synchronized
     *
     * @param s
     */
    public static void logAndFlush(String s) {
        if (enabled) {
            collected.add(s);
            flushNow();
        } else {
            startAsync(Main.getInstance().getDataFolder().toString(), 20);
            logAndFlush(s);
        }


    }

    public static boolean isEnabled() {
        return enabled;
    }

}
