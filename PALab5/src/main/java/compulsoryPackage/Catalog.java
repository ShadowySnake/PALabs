package compulsoryPackage;


import java.io.Serializable;

public class Catalog implements Serializable {
    private String localPath;
    private IOClass inputOutput;

    public  Catalog(String pathName){
     this.localPath = pathName;
     this.inputOutput = new IOClass(pathName);
    }

    public void add(){

    }

    public void list(){

    }

    public void play(){

    }

    public void save(String nameForFile){
        this.inputOutput.save(this, localPath + "/" + nameForFile);
    }

    public void load(String fileName){
        this.inputOutput.load(this, localPath + "/" + fileName);
    }
}
