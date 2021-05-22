package compulsoryPackage;

public class SomeClass {
    public String jobName;
    private int id;
    private String name;

    @Test
    public static void aStaticMethod() {
        System.out.print("Hello... ");
    }

    @Test
    public static void aSecondStaticMethod() {
        System.out.println("From static methods we give you...");
    }

    @Test
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobName() {
        return jobName;
    }

    @Test
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
