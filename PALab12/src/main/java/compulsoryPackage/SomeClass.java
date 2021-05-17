package compulsoryPackage;

import org.junit.Test;

public class SomeClass {
    private int id;
    private String name;
    public String jobName;

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

    @Test
    public static void aStaticMethod(){
        System.out.println("Hello from static method.");
    }
}
