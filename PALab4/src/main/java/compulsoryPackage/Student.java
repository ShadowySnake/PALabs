package compulsoryPackage;

import java.util.List;

public class Student {
    String studentName;
    List<String> schoolsPreferenceList;

    public Student(String givenStudentName){
        this.studentName = givenStudentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setSchoolsPreferenceList(List<String> schoolsPreferenceList) {
        this.schoolsPreferenceList = schoolsPreferenceList;
    }

    public List<String> getSchoolsPreferenceList() {
        return schoolsPreferenceList;
    }
}
