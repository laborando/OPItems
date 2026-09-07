package cel20.opitems.items.managers.abracator;

/**
 * Class for bidirectional association of a String and an int ID
 */
public class StringIDAssociator {

    public int id;
    public String name;

    public StringIDAssociator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
