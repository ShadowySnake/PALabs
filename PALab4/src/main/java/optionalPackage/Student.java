package optionalPackage;

public class Student {
    String studentName;

    public Student(String givenStudentName){
        this.studentName = givenStudentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
