package optionalPackage;

public class Genres {
    private int id;
    private final String name;

    public Genres(String name){
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
