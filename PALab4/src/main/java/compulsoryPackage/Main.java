package compulsoryPackage;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> studentNames = Arrays.asList("S1","S0","S3","S2");
        List<String> schoolNames = Arrays.asList("H2","H1","H0");

        ClassesInitializer theInitializer = new ClassesInitializer(studentNames,schoolNames);
        System.out.println(theInitializer.toString());

    }
}
