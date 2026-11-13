package cel20.opitems.utis.update;

public record VersionNumber(int major, int minor, int patch) {

    public boolean isHigherThan(VersionNumber other) {

        if (this.major > other.major) {
            return true;
        }
        if (this.major < other.major) {
            return false;
        }
        if (this.minor > other.minor) {
            return true;
        }
        if (this.minor < other.minor) {
            return false;
        }
        if (this.patch > other.patch) {
            return true;
        }
        if (this.patch < other.patch) {
            return false;
        }

        return false;
    }

    public String toString() {
        return major + "." + minor + "." + patch;
    }

    /**
     * Expects i.i.i
     *
     */
    public static VersionNumber toVersionNumber(String version) {
        String[] parts = version.split("\\.");

        VersionNumber vn = new VersionNumber(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

        return vn;
    }
}
