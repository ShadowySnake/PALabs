package compulsoryPackage;

import java.util.List;

public class School {
    String schoolName;
    int Capacity;
    List<String> studentPreferenceList;

    public School(String givenSchoolName){
        this.schoolName = givenSchoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setStudentPreferenceList(List<String> studentPreferenceList) {
        this.studentPreferenceList = studentPreferenceList;
    }

    public List<String> getStudentPreferenceList() {
        return studentPreferenceList;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}
