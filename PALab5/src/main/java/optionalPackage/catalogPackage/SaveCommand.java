package optionalPackage.catalogPackage;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SaveCommand {

    public SaveCommand(Catalog catalog)
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("How shall the file be named?");
        String fileName = myObj.nextLine();
        catalog.save(fileName);
    }

}
