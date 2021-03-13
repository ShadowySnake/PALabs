package optionalPackage;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    LinkedList<Student> studentLinkedList;
    TreeSet<School> schoolTreeSetList = new TreeSet<>(Comparator.comparing(School::getSchoolName));
    Map<String, List<String>> studentsMap = new HashMap<>();
    Map<String, List<String>> schoolsMap = new TreeMap<>();

    public Problem(List<String> studentNames, List<String> schoolNames, List<Integer> schoolCapacities) {
        this.studentLinkedList = studentNames
                .stream()
                .map(Student::new)
                .sorted(Comparator.comparing(Student::getStudentName))
                .collect(Collectors.toCollection(LinkedList::new));

        List<School> schoolsList = schoolNames
                .stream()
                .map(School::new)
                .sorted(Comparator.comparing(School::getSchoolName))
                .collect(Collectors.toList());

        this.schoolTreeSetList.addAll(schoolsList);

        int index = 0;
        for (School school : schoolTreeSetList){
            school.setCapacity(schoolCapacities.get(index));
            index = index + 1;
        }
    }

    public void setSchoolsMap(List<List<String>> schoolsPreferences){
        int index = 0;
        for (School school : schoolTreeSetList){
            schoolsMap.put(school.getSchoolName(),schoolsPreferences.get(index));
            index = index + 1;
        }
    }

    public Map<String, List<String>> getSchoolsMap() {
        return schoolsMap;
    }

    public void setStudentsMap(List<List<String>> studentsPreferences){
        int index = 0;
        for (Student student : studentLinkedList){
            studentsMap.put(student.getStudentName(),studentsPreferences.get(index));
            index = index + 1;
        }
    }

    public Map<String, List<String>> getStudentsMap() {
        return studentsMap;
    }

    public void printMaps(){
        System.out.println("Student map is the following:");
        studentsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
        System.out.println("School map is the following:");
        schoolsMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Override
    public String toString() {
        StringBuilder listPrinter = new StringBuilder("The contents are the following:\n---Students: ");

        for (Student student : studentLinkedList){
            listPrinter.append(student.getStudentName()).append(" ");
        }
        listPrinter.append("\n---Schools: ");
        for (School school : schoolTreeSetList){
            listPrinter.append(school.getSchoolName()).append(" ");
        }
        listPrinter.append("\n");
        return listPrinter.toString();
    }
}
