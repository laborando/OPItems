package utis.update;

import org.bukkit.Bukkit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import utis.Updater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.logging.Level;

/*
CUpdater for MC plugins via the Modrinth API
 */
public class CUpdater
{
    public CVersion[] versions;
    private String slug = "opitems";

    public CUpdater(){
        checkVersion();
    }

    private void checkVersion() {

        URL verList;

        try {
             verList = new URL("https://api.modrinth.com/v2/project/opitems/version");
        } catch (MalformedURLException e) {
            System.out.println("There was an error checking for updates: " + e.getMessage());
            throw new RuntimeException(e);
        }

        //Retrieve Ver Information
        try {
            final URLConnection conn = verList.openConnection();
            conn.setConnectTimeout(5000);

            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);

            final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final String response = reader.readLine();

            final JSONArray array = (JSONArray)JSONValue.parse(response);

            versions = new CVersion[array.size()];

            for(int current = 0; current < array.size(); current++){
                JSONObject version = (JSONObject)array.get(current);
                parseVersion(version, current);
            }

            for(int current = 0; current < array.size(); current++){
                Bukkit.getConsoleSender().sendMessage(versions[current].toString());
            }
        }
        catch (IOException e) {
            System.out.println("There was an error checking for updates: " + e.getMessage());
        }
    }

    private void parseVersion(JSONObject version, int current){

        CVersion ver = new CVersion();

        ver.authorID = (String)version.get("author_id");
        ver.id = (String)version.get("id");
        ver.changelog = (String)version.get("changelog");
        ver.verName = (String)version.get("name");

        StringBuilder loader = new StringBuilder();
        Iterator lA = ((JSONArray) version.get("loaders")).iterator();

        while(lA.hasNext()){
            loader.append(lA.next());
        }

        ver.loaders = loader.toString();

        ver.downloads = (long)version.get("downloads");
        ver.date =  (String)version.get("date_published");
        ver.version =  (String)version.get("version_number");
        ver.type = CVersion.UpdateType.valueOf((String) version.get("version_type"));

        JSONArray files =  (JSONArray)version.get("files");
        JSONObject file = (JSONObject)files.get(0);

        ver.fileSize = (long)file.get("size");
        ver.fileURL = (String)file.get("url");

        //Real username:
        URL userURL;
        try {
            userURL = new URL("https://api.modrinth.com/v2/user/" + ver.authorID);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            final URLConnection conn = userURL.openConnection();
            conn.setConnectTimeout(5000);

            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);

            final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final String response = reader.readLine();

            final JSONObject user = (JSONObject)JSONValue.parse(response);

            ver.author = (String) user.get("username");

        }
        catch (IOException e) {
            System.out.println("There was an error checking for updates: " + e.getMessage());
        }


        versions[current] = ver;
    }

}
