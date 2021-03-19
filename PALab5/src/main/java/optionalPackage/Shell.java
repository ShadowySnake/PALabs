package optionalPackage;

import optionalPackage.catalogPackage.*;
import java.io.Serializable;
import java.util.Scanner;

public class Shell implements Serializable {
    Catalog theCatalog;

    public Shell(Catalog catalog) {
        this.theCatalog = catalog;
    }

    public void run(){

        Scanner myObj = new Scanner(System.in);
        label:
        while (true){
            System.out.println("Type your command of choice: 'add' 'list' 'save' 'load' 'play' or 'quit' to exit ");
            String givenInput;
            givenInput = myObj.nextLine();
            switch (givenInput) {
                case "add":
                    new AddCommand(theCatalog);
                    break;
                case "list":
                    new ListCommand(theCatalog);
                    break;
                case "load":
                    LoadCommand loader = new LoadCommand(theCatalog);
                    theCatalog = loader.loadCatalog();
                    break;
                case "save":
                    new SaveCommand(theCatalog);
                    break;
                case "play":
                    new PlayCommand(theCatalog);
                    break;
                case "quit":
                    break label;
                default:
                    System.out.println("This command doesn't exist, try again!");
                    break;
            }
        }
    }
}
