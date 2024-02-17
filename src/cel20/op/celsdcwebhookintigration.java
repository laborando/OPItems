
package cel20.op;

import java.net.URLConnection;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.io.PrintWriter;
import java.net.URL;

public class celsdcwebhookintigration
{
    private static boolean mc_plugin;
    
    static {
        celsdcwebhookintigration.mc_plugin = true;
    }



    public static void sendMessage(final String message) {
        PrintWriter out = null;
        BufferedReader in = null;
        final StringBuilder result = new StringBuilder();
        {
            try {
                final URL conectto = new URL("https://discord.com/api/webhooks/927322040615194656/reSKew42jlsu0h1cxKaNrTjTRQ_1KDJasVbWwXpniZ-SGsFwu03vA4DCNBp_4VhX7kEY");
                final URLConnection connect = conectto.openConnection();
                connect.setRequestProperty("accept", "/");
                connect.setRequestProperty("connection", "Keep-Alive");
                connect.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
                connect.setDoOutput(true);
                connect.setDoInput(true);
                if (message == "") {
                    if (!celsdcwebhookintigration.mc_plugin) {
                        System.out.println("Fatal Error in: celsdcwebhookintigration");
                        System.out.println("Error: 'Message' cannot be nothing!");
                    }
                    return;
                }
                if (message == null) {
                    if (!celsdcwebhookintigration.mc_plugin) {
                        System.out.println("Fatal Error in: celsdcwebhookintigration");
                        System.out.println("Error: 'Message' cannot be null!");
                    }
                    return;
                }
                out = new PrintWriter(connect.getOutputStream());
                final String postData = String.valueOf(String.valueOf(URLEncoder.encode("content", "UTF-8"))) + "=" + URLEncoder.encode(message);
                out.print(postData);
                out.flush();
                in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            }
            catch (Exception var16) {
                var16.printStackTrace();
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                }
                catch (IOException var17) {
                    var17.printStackTrace();
                }
                
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                }
                catch (IOException var17) {
                    var17.printStackTrace();
                }
            }
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException var17) {
                var17.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException var18) {
                var18.printStackTrace();
            }
        }
    }
    
    public static void URLMessage(final String message, final URL connurl) {
        PrintWriter out = null;
        BufferedReader in = null;
        final StringBuilder result = new StringBuilder();
        
            try {
                final URL conectto = connurl;
                final URLConnection connect = conectto.openConnection();
                connect.setRequestProperty("accept", "/");
                connect.setRequestProperty("connection", "Keep-Alive");
                connect.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
                connect.setDoOutput(true);
                connect.setDoInput(true);
                if (message == "") {
                    System.out.println("Fatal Error in: celsdcwebhookintigration");
                    System.out.println("Error: 'Message' cannot be nothing!");
                    return;
                }
                if (message == null) {
                    System.out.println("Fatal Error in: celsdcwebhookintigration");
                    System.out.println("Error: 'Message' cannot be null!");
                    return;
                }
                out = new PrintWriter(connect.getOutputStream());
                final String postData = String.valueOf(String.valueOf(URLEncoder.encode("content", "UTF-8"))) + "=" + URLEncoder.encode(message);
                out.print(postData);
                out.flush();
                in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            }
            catch (Exception var16) {
                var16.printStackTrace();
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                }
                catch (IOException var17) {
                    var17.printStackTrace();
                }
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                }
                catch (IOException var17) {
                    var17.printStackTrace();
                }
            }
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException var17) {
                var17.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException var18) {
                var18.printStackTrace();
            }
        }
    
    
    public String getVersion() {
        return "1.3MC";
    }
}
