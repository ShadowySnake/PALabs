package compulsoryPackage.catalogPackage;

import java.awt.*;
import java.io.*;

public class IOClass{
    String localPath;
    Desktop desktop;

    public IOClass(String pathName){
        this.localPath = pathName;
        this.desktop = Desktop.getDesktop();
    }

    public void play(String filePath){
        try {
            File file = new File(localPath + filePath);
            desktop.open(file);
        } catch (IOException e) {
            System.out.println("Unexpected error at 'playing' the file!");
            e.printStackTrace();
        }
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

    public Catalog load(String filePath){
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);
            Catalog foundCatalog = (Catalog) in.readObject();
            in.close();
            file.close();
            return foundCatalog;
        } catch (IOException e) {
            System.out.println("File may not exist!");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e){
            System.out.println("This class does not exist!");
            e.printStackTrace();
            return null;
        }
    }
}
