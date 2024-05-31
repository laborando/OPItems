
package cel20.op;

import org.bukkit.scheduler.BukkitRunnable;
import java.net.URLConnection;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.io.BufferedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import org.bukkit.configuration.file.YamlConfiguration;
import java.net.URL;
import java.io.File;
import org.bukkit.plugin.Plugin;

public class Updater
{
    private static final String TITLE_VALUE = "name";
    private static final String LINK_VALUE = "downloadUrl";
    private static final String TYPE_VALUE = "releaseType";
    private static final String VERSION_VALUE = "gameVersion";
    private static final String QUERY = "/servermods/files?projectIds=";
    private static final String HOST = "https://api.curseforge.com";
    private static final String USER_AGENT = "Updater (by Gravity)";
    private static final String DELIMETER = "^v|[\\s_-]v";
    private static final String[] NO_UPDATE_TAG;
    private static final int BYTE_SIZE = 1024;
    private static final String API_KEY_CONFIG_KEY = "api-key";
    private static final String DISABLE_CONFIG_KEY = "disable";
    private static final String API_KEY_DEFAULT = "PUT_API_KEY_HERE";
    private static final boolean DISABLE_DEFAULT = false;
    private final Plugin plugin;
    private final UpdateType type;
    private final boolean announce;
    private final File file;
    private final File updateFolder;
    private final UpdateCallback callback;
    private int id;
    private String apiKey;
    private String versionName;
    private String versionLink;
    private String versionType;
    private String versionGameVersion;
    private URL url;
    private Thread thread;
    private UpdateResult result;
    
    static {
        NO_UPDATE_TAG = new String[] { "-DEV", "-PRE", "-SNAPSHOT" };
    }
    
    public Updater(final Plugin plugin, final int id, final File file, final UpdateType type, final boolean announce) {
        this(plugin, id, file, type, null, announce);
    }
    
    public Updater(final Plugin plugin, final int id, final File file, final UpdateType type, final UpdateCallback callback) {
        this(plugin, id, file, type, callback, false);
    }
    
    public Updater(final Plugin plugin, final int id, final File file, final UpdateType type, final UpdateCallback callback, final boolean announce) {
        this.apiKey = null;
        this.result = UpdateResult.SUCCESS;
        this.plugin = plugin;
        this.type = type;
        this.announce = announce;
        this.file = file;
        this.id = id;
        this.updateFolder = this.plugin.getServer().getUpdateFolderFile();
        this.callback = callback;
        try {
            this.url = new URL("https://api.curseforge.com/servermods/files?projectIds=" + this.id);
        }
        catch (MalformedURLException e2) {
            this.plugin.getLogger().log(Level.SEVERE, "The project ID provided for updating OPItems, " + this.id + " is invalid.", e2);
            this.result = UpdateResult.FAIL_BADID;
        }
        if (this.result != UpdateResult.FAIL_BADID) {
            (this.thread = new Thread(new UpdateRunnable())).start();
        }
        else {
            this.runUpdater();
        }
    }
    
    public UpdateResult getResult() {
        this.waitForThread();
        return this.result;
    }
    
    public ReleaseType getLatestType() {
        this.waitForThread();
        if (this.versionType != null) {
            final ReleaseType[] arrayOfReleaseType;
            final int i = (arrayOfReleaseType = ReleaseType.values()).length;
            for (byte b = 0; b < i; ++b) {
                final ReleaseType type = arrayOfReleaseType[b];
                if (this.versionType.equalsIgnoreCase(type.name())) {
                    return type;
                }
            }
        }
        return null;
    }
    
    public String getLatestGameVersion() {
        this.waitForThread();
        return this.versionGameVersion;
    }
    
    public String getLatestName() {
        this.waitForThread();
        return this.versionName;
    }
    
    public String getLatestFileLink() {
        this.waitForThread();
        return this.versionLink;
    }
    
    private void waitForThread() {
        if (this.thread != null && this.thread.isAlive()) {
            try {
                this.thread.join();
            }
            catch (InterruptedException e) {
                this.plugin.getLogger().log(Level.SEVERE, null, e);
            }
        }
    }
    
    private void saveFile(final String file) {
        final File folder = this.updateFolder;
        this.deleteOldFiles();
        if (!folder.exists()) {
            this.fileIOOrError(folder, folder.mkdir(), true);
        }
        this.downloadFile();
        final File dFile = new File(folder.getAbsolutePath(), file);
        if (dFile.getName().endsWith(".zip")) {
            this.unzip(dFile.getAbsolutePath());
        }
        if (this.announce) {
            this.plugin.getLogger().info("Finished updating.");
        }
    }
    
    private void downloadFile() {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            final URL fileUrl = this.followRedirects(this.versionLink);
            final int fileLength = fileUrl.openConnection().getContentLength();
            in = new BufferedInputStream(fileUrl.openStream());
            fout = new FileOutputStream(new File(this.updateFolder, this.file.getName()));
            final byte[] data = new byte[1024];
            if (this.announce) {
                this.plugin.getLogger().info("About to download a new update: " + this.versionName);
            }
            long downloaded = 0L;
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                downloaded += count;
                fout.write(data, 0, count);
                final int percent = (int)(downloaded * 100L / fileLength);
                if (this.announce && percent % 10 == 0) {
                    this.plugin.getLogger().info("Downloading update: " + percent + "% of " + fileLength + " bytes.");
                }
            }
        }
        catch (Exception ex) {
            this.plugin.getLogger().log(Level.WARNING, "The auto-updater tried to download a new update, but was unsuccessful.", ex);
            this.result = UpdateResult.FAIL_DOWNLOAD;
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex2) {
                this.plugin.getLogger().log(Level.SEVERE, null, ex2);
            }
            try {
                if (fout != null) {
                    fout.close();
                }
            }
            catch (IOException ex2) {
                this.plugin.getLogger().log(Level.SEVERE, null, ex2);
            }
            return;
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (IOException ex2) {
                this.plugin.getLogger().log(Level.SEVERE, null, ex2);
            }
            try {
                if (fout != null) {
                    fout.close();
                }
            }
            catch (IOException ex2) {
                this.plugin.getLogger().log(Level.SEVERE, null, ex2);
            }
        }
        try {
            if (in != null) {
                in.close();
            }
        }
        catch (IOException ex2) {
            this.plugin.getLogger().log(Level.SEVERE, null, ex2);
        }
        try {
            if (fout != null) {
                fout.close();
            }
        }
        catch (IOException ex2) {
            this.plugin.getLogger().log(Level.SEVERE, null, ex2);
        }
    }
    
    private URL followRedirects(String location) throws IOException {
        while (true) {
            final URL resourceUrl = new URL(location);
            final HttpURLConnection conn = (HttpURLConnection)resourceUrl.openConnection();
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(15000);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("User-Agent", "Mozilla/5.0...");
            switch (conn.getResponseCode()) {
                case 301:
                case 302: {
                    final String redLoc = conn.getHeaderField("Location");
                    final URL base = new URL(location);
                    final URL next = new URL(base, redLoc);
                    location = next.toExternalForm();
                    continue;
                }
                default: {
                    return conn.getURL();
                }
            }
        }
    }
    
    private void deleteOldFiles() {
        final File[] list = this.listFilesOrError(this.updateFolder);
        final File[] arrayOfFile1;
        final int i = (arrayOfFile1 = list).length;
        for (byte b = 0; b < i; ++b) {
            final File xFile = arrayOfFile1[b];
            if (xFile.getName().endsWith(".zip")) {
                this.fileIOOrError(xFile, xFile.mkdir(), true);
            }
        }
    }
    
    private void unzip(final String file) {
        final File fSourceZip = new File(file);
        try {
            final String zipPath = file.substring(0, file.length() - 4);
            final ZipFile zipFile = new ZipFile(fSourceZip);
            final Enumeration<? extends ZipEntry> e = zipFile.entries();
            while (e.hasMoreElements()) {
                final ZipEntry entry = (ZipEntry)e.nextElement();
                final File destinationFilePath = new File(zipPath, entry.getName());
                this.fileIOOrError(destinationFilePath.getParentFile(), destinationFilePath.getParentFile().mkdirs(), true);
                if (!entry.isDirectory()) {
                    final BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
                    final byte[] buffer = new byte[1024];
                    final FileOutputStream fos = new FileOutputStream(destinationFilePath);
                    final BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
                    int b;
                    while ((b = bis.read(buffer, 0, 1024)) != -1) {
                        bos.write(buffer, 0, b);
                    }
                    bos.flush();
                    bos.close();
                    bis.close();
                    final String name = destinationFilePath.getName();
                    if (!name.endsWith(".jar") || !this.pluginExists(name)) {
                        continue;
                    }
                    final File output = new File(this.updateFolder, name);
                    this.fileIOOrError(output, destinationFilePath.renameTo(output), true);
                }
            }
            zipFile.close();
            this.moveNewZipFiles(zipPath);
        }
        catch (IOException e2) {
            this.plugin.getLogger().log(Level.SEVERE, "The auto-updater tried to unzip a new update file, but was unsuccessful.", e2);
            this.result = UpdateResult.FAIL_DOWNLOAD;
            return;
        }
        finally {
            this.fileIOOrError(fSourceZip, fSourceZip.delete(), false);
        }
        this.fileIOOrError(fSourceZip, fSourceZip.delete(), false);
    }
    
    private void moveNewZipFiles(final String zipPath) {
        final File[] list = this.listFilesOrError(new File(zipPath));
        final File[] arrayOfFile1;
        final int i = (arrayOfFile1 = list).length;
        for (byte b = 0; b < i; ++b) {
            final File dFile = arrayOfFile1[b];
            if (dFile.isDirectory() && this.pluginExists(dFile.getName())) {
                final File oFile = new File(this.plugin.getDataFolder().getParent(), dFile.getName());
                final File[] dList = this.listFilesOrError(dFile);
                final File[] oList = this.listFilesOrError(oFile);
                final File[] arrayOfFile2;
                final int j = (arrayOfFile2 = dList).length;
                for (byte b2 = 0; b2 < j; ++b2) {
                    final File cFile = arrayOfFile2[b2];
                    boolean found = false;
                    final File[] arrayOfFile3;
                    final int k = (arrayOfFile3 = oList).length;
                    for (byte b3 = 0; b3 < k; ++b3) {
                        final File xFile = arrayOfFile3[b3];
                        if (xFile.getName().equals(cFile.getName())) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        final File output = new File(oFile, cFile.getName());
                        this.fileIOOrError(output, cFile.renameTo(output), true);
                    }
                    else {
                        this.fileIOOrError(cFile, cFile.delete(), false);
                    }
                }
            }
            this.fileIOOrError(dFile, dFile.delete(), false);
        }
        final File zip = new File(zipPath);
        this.fileIOOrError(zip, zip.delete(), false);
    }
    
    private boolean pluginExists(final String name) {
        final File[] plugins = this.listFilesOrError(new File("plugins"));
        final File[] arrayOfFile1;
        final int i = (arrayOfFile1 = plugins).length;
        for (byte b = 0; b < i; ++b) {
            final File file = arrayOfFile1[b];
            if (file.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean versionCheck() {
        final String title = this.versionName;
        if (this.type != UpdateType.NO_VERSION_CHECK) {
            final String localVersion = this.plugin.getDescription().getVersion();
            if (title.split("^v|[\\s_-]v").length < 2) {
                final String authorInfo = this.plugin.getDescription().getAuthors().isEmpty() ? "" : (" (" + this.plugin.getDescription().getAuthors().get(0) + ")");
                this.plugin.getLogger().warning("The author of this plugin" + authorInfo + " has misconfigured their Auto Update system");
                this.result = UpdateResult.FAIL_NOVERSION;
                return false;
            }
            final String remoteVersion = title.split("^v|[\\s_-]v")[title.split("^v|[\\s_-]v").length - 1].split(" ")[0];
            if (this.hasTag(localVersion) || !this.shouldUpdate(localVersion, remoteVersion)) {
                this.result = UpdateResult.NO_UPDATE;
                return false;
            }
        }
        return true;
    }
    
    public boolean shouldUpdate(final String localVersion, final String remoteVersion) {
        return !localVersion.equalsIgnoreCase(remoteVersion);
    }
    
    private boolean hasTag(final String version) {
        final String[] arrayOfString;
        final int i = (arrayOfString = Updater.NO_UPDATE_TAG).length;
        for (byte b = 0; b < i; ++b) {
            final String string = arrayOfString[b];
            if (version.contains(string)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean read() {
        try {
            final URLConnection conn = this.url.openConnection();
            conn.setConnectTimeout(5000);
            if (this.apiKey != null) {
                conn.addRequestProperty("X-API-Key", this.apiKey);
            }
            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setDoOutput(true);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final String response = reader.readLine();
            final JSONArray array = (JSONArray)JSONValue.parse(response);
            if (array.isEmpty()) {
                this.plugin.getLogger().warning("The updater could not find any files for the project id " + this.id);
                this.result = UpdateResult.FAIL_BADID;
                return false;
            }
            final JSONObject latestUpdate = (JSONObject)array.get(array.size() - 1);
            this.versionName = (String)latestUpdate.get("name");
            this.versionLink = (String)latestUpdate.get("downloadUrl");
            this.versionType = (String)latestUpdate.get("releaseType");
            this.versionGameVersion = (String)latestUpdate.get("gameVersion");
            return true;
        }
        catch (IOException e) {
            if (e.getMessage().contains("HTTP response code: 403")) {
                this.plugin.getLogger().severe("[Updater] dev.bukkit.org rejected the API key.");
                this.result = UpdateResult.FAIL_APIKEY;
            }
            else {
                this.plugin.getLogger().severe("The updater could not contact curseforge/dev.bukkit.org for updating.");
                this.plugin.getLogger().severe("If you have not recently modified your configuration, try again later.");
                this.result = UpdateResult.FAIL_DBO;
            }
            this.plugin.getLogger().log(Level.SEVERE, null, e);
            return false;
        }
    }

    private void fileIOOrError(final File file, final boolean result, final boolean create) {
        if (!result) {
            this.plugin.getLogger().severe("The updater could not " + (create ? "create" : "delete") + " file at: " + file.getAbsolutePath());
            this.plugin.getLogger().severe("Please update the permissions of the folder and subfolders your server is running from!");
            
        }
    }
    
    private File[] listFilesOrError(final File folder) {
        final File[] contents = folder.listFiles();
        if (contents == null) {
            this.plugin.getLogger().severe("The updater could not access files at: " + this.updateFolder.getAbsolutePath());
            this.plugin.getLogger().severe("Please update the permissions of the folder and subfolders your server is running from!");
            return new File[0];
        }
        return contents;
    }
    
    private void runUpdater() {
        if (this.url != null && this.read() && this.versionCheck()) {
            if (this.versionLink != null && this.type != UpdateType.NO_DOWNLOAD) {
                String name = this.file.getName();
                if (this.versionLink.endsWith(".zip")) {
                    name = this.versionLink.substring(this.versionLink.lastIndexOf("/") + 1);
                }
                this.saveFile(name);
            }
            else {
                this.result = UpdateResult.UPDATE_AVAILABLE;
            }
        }
        if (this.callback != null) {
            new BukkitRunnable() {
                public void run() {
                    Updater.this.runCallback();
                }
            }.runTask(this.plugin);
        }
    }
    
    private void runCallback() {
        this.callback.onFinish(this);
    }
    
    public enum ReleaseType
    {
        ALPHA("ALPHA", 0), 
        BETA("BETA", 1), 
        RELEASE("RELEASE", 2);
        
        private ReleaseType(final String name, final int ordinal) {
        }
    }
    
    public enum UpdateResult
    {
        SUCCESS("SUCCESS", 0), 
        NO_UPDATE("NO_UPDATE", 1), 
        DISABLED("DISABLED", 2), 
        FAIL_DOWNLOAD("FAIL_DOWNLOAD", 3), 
        FAIL_DBO("FAIL_DBO", 4), 
        FAIL_NOVERSION("FAIL_NOVERSION", 5), 
        FAIL_BADID("FAIL_BADID", 6), 
        FAIL_APIKEY("FAIL_APIKEY", 7), 
        UPDATE_AVAILABLE("UPDATE_AVAILABLE", 8);
        
        private UpdateResult(final String name, final int ordinal) {
        }
    }
    
    public enum UpdateType
    {
        DEFAULT("DEFAULT", 0), 
        NO_VERSION_CHECK("NO_VERSION_CHECK", 1), 
        NO_DOWNLOAD("NO_DOWNLOAD", 2);
        
        private UpdateType(final String name, final int ordinal) {
        }
    }
    
    private class UpdateRunnable implements Runnable
    {
        @Override
        public void run() {
            Updater.this.runUpdater();
        }
    }
    
    public interface UpdateCallback
    {
        void onFinish(final Updater p0);
    }
}
