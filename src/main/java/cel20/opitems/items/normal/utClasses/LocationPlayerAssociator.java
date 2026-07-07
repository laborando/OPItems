package cel20.opitems.items.normal.utClasses;


import org.bukkit.Location;

/**
 * Class for bidirectional association of a player and a location
 */
public class LocationPlayerAssociator {

    String name;
    Location location;

    public LocationPlayerAssociator(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
