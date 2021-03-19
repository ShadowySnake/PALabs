package optionalPackage.itemsPackage;

public class TextFile extends Items {

    public TextFile(String fileName,String fileDescription,String pathToFile){
        super(fileName,fileDescription,pathToFile);
        setFileExtension(".txt");
    }
}
