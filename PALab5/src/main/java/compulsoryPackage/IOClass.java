package compulsoryPackage;

import java.awt.*;
import java.io.*;

public class IOClass implements Serializable{
    private String localPath;
    private Desktop desktop;

    public IOClass(String pathName){
        this.localPath = pathName;
    }


    public void save(Catalog catalog, String filePath){
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(catalog);
            out.close();
            file.close();
        } catch (IOException e) {
            System.out.println("There was a problem with creating the file!");
            e.printStackTrace();
        }
    }

    public void load(Catalog catalog, String filePath){
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);
            catalog = (Catalog) in.readObject();
            in.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File may not exist!");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("This class does not exist!");
            e.printStackTrace();
        }
    }
}
