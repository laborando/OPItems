package utis;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WorkerLogger {
    private final String workerUrl;

    public WorkerLogger(String workerUrl) {
        this.workerUrl = workerUrl;
    }

    public void sendLog(String logText) {
        try {
            URL url = new URL(workerUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");

            byte[] out = logText.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = con.getOutputStream();
            stream.write(out);

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                //throw new RuntimeException("Fehler beim Senden des Logs: HTTP " + responseCode);
            }
            con.disconnect();
        }catch (Exception ignored){}
    }
}
