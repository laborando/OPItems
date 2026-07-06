package metrics;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WorkerLogger {
    public static WorkerLogger activeLogger;

    private final String workerUrl;

    public WorkerLogger(String workerUrl) {
        this.workerUrl = workerUrl;
    }

    /**
     * Sends a message to a remote worker instance
     *
     * @param logText
     */
    public void sendLog(String logText) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(workerUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");

            byte[] out = logText.getBytes(StandardCharsets.UTF_8);
            con.setRequestProperty("Content-Length", String.valueOf(out.length));

            try (OutputStream os = con.getOutputStream()) {
                os.write(out);
                os.flush();
            }

            int responseCode = con.getResponseCode();

            // Response
            try (InputStream is = con.getInputStream()) {
                is.read(); // Increasing propability of proper closure of stream
            }

            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("Error sending  log Logs: HTTP " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

}
