package compulsoryPackage;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ClassesInitializer {
    LinkedList<Student> studentLinkedList;
    TreeSet<School> schoolTreeSetList = new TreeSet<>(Comparator.comparing(School::getSchoolName));

    public ClassesInitializer(List<String> studentNames, List<String> schoolNames, List<Integer> schoolCapacities) {
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

    public void setSchoolsPreferences(List<List<String>> schoolsPreferences){
        int index = 0;
        for (School school : schoolTreeSetList){
            school.setStudentPreferenceList(schoolsPreferences.get(index));
            index = index + 1;
        }
    }

    public void setStudentsPreferences(List<List<String>> studentsPreferences){
        int index = 0;
        for (Student student : studentLinkedList){
            student.setSchoolsPreferenceList(studentsPreferences.get(index));
            index = index + 1;
        }
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

        return listPrinter.toString();
    }
}
