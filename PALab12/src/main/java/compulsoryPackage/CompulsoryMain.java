package compulsoryPackage;

public class CompulsoryMain {
    public static void main(String[] args) {
        ClassExplorer clExp = new ClassExplorer();
        clExp.loadPath();
        clExp.printClassDetails();
        clExp.invokeMethods();
    }
}
