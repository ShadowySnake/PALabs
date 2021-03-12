package compulsoryPackage;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
         Initialization/ creation of a linked list using streams.
         */
        List<String> studentNames = Arrays.asList("S1","S0","S3","S2");
        LinkedList<Student> studentLinkedList = studentNames
                .stream()
                .map(Student::new)
                .sorted(Comparator.comparing(Student::getStudentName))
                .collect(Collectors.toCollection(LinkedList::new));

        for (Student student : studentLinkedList){
           System.out.println(student.getStudentName());
        }

        /*
         Initialization of a normal list for schools, using streams,
         and then setting this list in a TreeSet.
         */
        List<String> schoolNames = Arrays.asList("H2","H1","H0");
        List<School> schoolsList = schoolNames
                .stream()
                .map(School::new)
                .sorted(Comparator.comparing(School::getSchoolName))
                .collect(Collectors.toList());

        TreeSet<School> schoolTreeSetList = new TreeSet<>(Comparator.comparing(School::getSchoolName));
        schoolTreeSetList.addAll(schoolsList);
        for (School school : schoolTreeSetList){
            System.out.println(school.getSchoolName());
        }

    }
}
