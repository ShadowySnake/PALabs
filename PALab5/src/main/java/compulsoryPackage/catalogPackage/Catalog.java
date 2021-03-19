package compulsoryPackage.catalogPackage;


import compulsoryPackage.itemsPackage.Items;

import java.io.Serializable;
import java.util.HashMap;

public class Catalog implements Serializable {
    String localPath;
    IOClass inputOutput;
    HashMap<String, Items> itemsMap;

    public  Catalog(String pathName){
     this.localPath = pathName;
     this.inputOutput = new IOClass(pathName);
     this.itemsMap = new HashMap<>();
    }

    public void add(){

    }

    public void list(){
        System.out.println("In this catalog we have the following items:");
        itemsMap.forEach((key, value) -> System.out.println(key));
    }

    public void play(String fileName){
        this.inputOutput.play(itemsMap.get(fileName).getFullPath());
    }

    public void save(String nameForFile){
        this.inputOutput.save(this, localPath + "/" + nameForFile);
    }

    public void load(String fileName){
        this.inputOutput.load(this, localPath + "/" + fileName);
    }
}
