package utis.update;

public class CVersion {

    public enum UpdateType {
        alpha,
        beta,
        release
    }

    public String loaders;
    public String id;
    public String authorID;
    public String author;
    public String verName;
    public String version;
    public String changelog;
    public String date;
    public long downloads;
    public UpdateType type;

    public String fileURL;
    public long fileSize;

    public String toString(){
        return "ID: " + id + "\n"
                + "version: " + version + "\n"
                + "author: " + author + "\n"
                + "downloads: " + downloads + "\n"
                + "size: " + fileSize + "\n"
                + "type" + type + "\n"
                + "changelog: " + changelog + "\n";
    }
}
