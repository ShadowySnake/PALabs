package optionalPackage;

public class OptionalMain {
    public static void main(String[] args){
        ClassExplorer clsExp = new ClassExplorer();
        clsExp.loadPath(null);
        clsExp.printStats();
    }
}
