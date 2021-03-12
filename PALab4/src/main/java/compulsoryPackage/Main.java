package compulsoryPackage;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> studentNames = Arrays.asList("S1","S0","S3","S2");
        List<String> schoolNames = Arrays.asList("H2","H1","H0");

        List<Integer> schoolCapacities = Arrays.asList(1,2,2); // must be given for the alfabetical order of school names
        List<List<String>> studentsPreferences =
                Arrays.asList(Arrays.asList("H0", "H1", "H2"), Arrays.asList("H0", "H1", "H2"),
                        Arrays.asList("H0","H1"), Arrays.asList("H0","H2"));
        List<List<String>> schoolsPreferences =
                Arrays.asList(Arrays.asList("S3", "S0", "S1", "S2"), Arrays.asList("S0", "S2", "S1"),
                Arrays.asList("S0", "S1", "S3"));

        ClassesInitializer theInitializer = new ClassesInitializer(studentNames,schoolNames,schoolCapacities);
        theInitializer.setSchoolsPreferences(schoolsPreferences);
        theInitializer.setStudentsPreferences(studentsPreferences);
        System.out.println(theInitializer.toString());

    }
}
