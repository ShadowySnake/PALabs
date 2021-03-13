package optionalPackage;


import java.util.Arrays;
import java.util.List;

public class OptionalMain {
    public static void main(String[] args) {

        List<String> studentNames = Arrays.asList("S1","S0","S3","S2");
        List<String> schoolNames = Arrays.asList("H2","H1","H0");

        List<Integer> schoolCapacities = Arrays.asList(1,2,2); // must be given for the alphabetical order of school names
        List<List<String>> studentsPreferences =
                Arrays.asList(Arrays.asList("H0", "H1", "H2"), Arrays.asList("H0", "H1", "H2"),
                        Arrays.asList("H0","H1"), Arrays.asList("H0","H2"));
        List<List<String>> schoolsPreferences =
                Arrays.asList(Arrays.asList("S3", "S0", "S1", "S2"), Arrays.asList("S0", "S2", "S1"),
                Arrays.asList("S0", "S1", "S3"));

        Problem theProblem = new Problem(studentNames,schoolNames,schoolCapacities);
        theProblem.setSchoolsMap(schoolsPreferences);
        theProblem.setStudentsMap(studentsPreferences);
        System.out.println(theProblem.toString());
        theProblem.printMaps();

        Solution theSolution = new Solution(theProblem);
        System.out.println(theSolution.matchingMaker());

    }
}
