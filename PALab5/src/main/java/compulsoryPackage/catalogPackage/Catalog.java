package compulsoryPackage.catalogPackage;


import compulsoryPackage.exceptionsThrower.MyChecker;
import compulsoryPackage.itemsPackage.Items;

import java.io.Serializable;
import java.util.HashMap;

public class Catalog implements Serializable {
    String localPath;
    transient IOClass inputOutput;
    HashMap<String, Items> itemsMap;
    MyChecker errorChecker;

    public  Catalog(String pathName){
     this.localPath = pathName;
     this.inputOutput = new IOClass(pathName);
     this.itemsMap = new HashMap<>();
     this.errorChecker = new MyChecker(pathName);
    }

    public void add(Items item){
        try
        {
            errorChecker.checkValidity(item);
            this.itemsMap.put(item.getCatalogNameFile(), item);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
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

    public Catalog load(String fileName){
        return this.inputOutput.load(localPath + "/" + fileName);
    }
}
