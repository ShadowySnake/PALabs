package optionalPackage.catalogPackage;

import java.util.Scanner;

public class PlayCommand {

    public PlayCommand(Catalog catalog)
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What file do you want to play?");
        String fileName = myObj.nextLine();
        catalog.play(fileName);
    }

}
