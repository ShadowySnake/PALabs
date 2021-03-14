package optionalPackage;


public class School {
    String schoolName;
    int Capacity;

    public School(String givenSchoolName){
        this.schoolName = givenSchoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }
}
