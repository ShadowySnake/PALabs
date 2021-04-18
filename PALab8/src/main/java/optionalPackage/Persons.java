package optionalPackage;

abstract class Persons {
    protected int id;
    protected String name;
    protected String job;
    protected int starringIn;

    public Persons(int id, String name, String job, Integer starring) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.starringIn = starring;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public int getStarringIN() {
        return this.starringIn;
    }

}
