package optionalPackage;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    Problem theProblem;

    public Solution(Problem givenProblem){
        this.theProblem = givenProblem;
    }

    /**
     * Method used for verifying whether a list of given school names is found amongst the preferences list of the student.
     * @param studentName is the name of the student we want to check their list.
     * @param schoolNamesList is the list of school names.
     * @return returns true IF ALL school names in the given list are found amongst the preference list of the student, otherwise returns false.
     */
    boolean containsList(String studentName, List<String> schoolNamesList){
        for (String schools : schoolNamesList){
            if(!theProblem.getStudentsMap().get(studentName).contains(schools)) return false;
        }
        return true;
    }

    /**
     * Method used for printing on screen which schools find a given student as their top performer and which student finds the
     * given school list amongst ( the school list given could be accepted by a student) their preference list.
     * @param studentName the student name we search as top performer.
     * @param schoolsName the list of school names.
     */
    public void acceptablePreference(String studentName,List<String> schoolsName){
        System.out.print("\nFor the given list " + schoolsName + " the students that find these schools acceptable are: ");
        theProblem.studentLinkedList.stream()
                .filter(x -> containsList(x.getStudentName(), schoolsName))
                .forEach(x -> System.out.print(x.getStudentName() + " "));
        System.out.print("\nThe schools that find the student " + studentName + " as their top performer are: ");
        theProblem.schoolTreeSetList.stream()
                .filter(x -> (theProblem.getSchoolsMap().get(x.getSchoolName()).get(0).equals(studentName)))
                .forEach(x -> System.out.print(x.getSchoolName() + " "));
        System.out.println();
    }

    /**
     * Method that creates fake names for schools and students.
     * @return returns a string with the new names for both schools and students.
     */
    String changeToFakeNames(){
        Faker fakeNames = new Faker();
        StringBuilder namesAfterChange = new StringBuilder("\nThe students after creating the fake names will be: ");
        for (Student student : theProblem.studentLinkedList){
            student.setStudentName(fakeNames.name().nameWithMiddle());
            namesAfterChange.append(student.getStudentName()).append(", ");
        }
        namesAfterChange.append("\nThe schools after creating fake names will be: ");
        for (School school : theProblem.schoolTreeSetList){
            school.setSchoolName(fakeNames.university().name());
            namesAfterChange.append(school.getSchoolName()).append(", ");
        }
        return namesAfterChange.toString();
    }

    /**
     * Method used for creating a matching based on the preference list of both the student and the school.
     * @return returns a map containing all the best matches for each student.
     * ( A matching is made if the current student is the most requested in the current school or if the student
     * is more requested in a certain school than all others )
     */
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
