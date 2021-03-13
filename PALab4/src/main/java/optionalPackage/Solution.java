package optionalPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {
    Problem theProblem;

    public Solution(Problem givenProblem){
        this.theProblem = givenProblem;
    }

    public Map<String, String> matchingMaker(){
        System.out.println("\nA possible solution could be:");
        Map<String,String> matchingMap = new TreeMap<>();
        Map<String, List<String>> studentsPreference = theProblem.getStudentsMap();
        Map<String, List<String>> schoolsPreference = theProblem.getSchoolsMap();
        List<School> schoolsArrayList = new ArrayList<>(theProblem.schoolTreeSetList);

        List<String> schoolNamesList = theProblem.schoolTreeSetList
                .stream()
                .map(School::getSchoolName)
                .collect(Collectors.toList());

        String schoolCapacityChange = null;
        int finalIndex;
        int currentIndex;
        for (String keyString : studentsPreference.keySet()){
            finalIndex = -1;
            List<String> currentPreference = studentsPreference.get(keyString);

            for (String schoolName : currentPreference) {
                int schoolIndex = schoolNamesList.indexOf(schoolName);

                if (schoolsArrayList.get(schoolIndex).getCapacity() > 0) {
                    currentIndex = schoolsPreference.get(schoolName).indexOf(keyString);
                    if (currentIndex == 0) {
                        schoolCapacityChange = schoolName;
                        break;
                    } else if (finalIndex < 0) {
                        finalIndex = currentIndex;
                        schoolCapacityChange = schoolName;
                    } else if (currentIndex < finalIndex) {
                        finalIndex = currentIndex;
                        schoolCapacityChange = schoolName;
                    }
                }
            }
        schoolsArrayList.get(schoolNamesList.indexOf(schoolCapacityChange))
                .setCapacity(schoolsArrayList.get(schoolNamesList.indexOf(schoolCapacityChange)).getCapacity() - 1);
        matchingMap.put(keyString,schoolCapacityChange);
        }
        return  matchingMap;
    }
}
