package optionalPackage;

public class Genres {
    private final String name;
    private int id;

    public Genres(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
