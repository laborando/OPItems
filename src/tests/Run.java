package tests;

import org.bukkit.Bukkit;
import utis.WorkerLogger;

import java.security.SecureRandom;
import java.util.Base64;

public class Run {

    public static void main(String[] args) {

        System.out.println("Running debug-Main class");

        byte[] randomBytes = new byte[99];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);

        String base64Text = Base64.getEncoder().encodeToString(randomBytes);
        System.out.println(base64Text + ";");

        main(args);

        /*
        WorkerLogger logger = new WorkerLogger("https://plugins.opitems.workers.dev/");
        logger.sendLog("Testnachricht");
        System.out.println("Log gesendet");
        */


    }


}