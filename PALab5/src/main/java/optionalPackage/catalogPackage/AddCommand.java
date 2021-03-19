package optionalPackage.catalogPackage;

import optionalPackage.itemsPackage.*;

import java.util.Scanner;

public class AddCommand {

    public AddCommand(Catalog givenCatalog)
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What file do you want to add?");
        String fileName = myObj.nextLine();
        System.out.println("A short description for the file.");
        String fileDescription = myObj.nextLine();
        System.out.println("What is the folder path?");
        String filePath = myObj.nextLine();
        System.out.println("What is the extension? (either .txt or .PNG)");
        String fileExtension = myObj.nextLine();

        if( fileExtension.equals(".txt") ) givenCatalog.add(new TextFile(fileName, fileDescription, filePath));
        else givenCatalog.add(new PNG_image(fileName, fileDescription, filePath));
    }

}
