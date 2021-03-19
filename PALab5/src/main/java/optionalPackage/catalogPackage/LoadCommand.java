package optionalPackage.catalogPackage;

import java.util.Scanner;

public class LoadCommand {
    Catalog catalog;
    String fileName;

    public LoadCommand(Catalog catalog)
    {
        this.catalog = catalog;
        Scanner myObj = new Scanner(System.in);
        System.out.println("What is the name of the catalog file to load? (including it's extension)");
        this.fileName = myObj.nextLine();
    }

    public Catalog loadCatalog(){
        return catalog.load(fileName);
    }
}
