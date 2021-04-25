package optionalPackage.app;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner myScanner = new Scanner(System.in);
        String response;

        System.out.println("Please select which way to commence: JDBC or JPA");
        response = myScanner.nextLine();
        switch (response){
            case "JDBC":
                StarterJDBC.begin();
                break;
            case "JPA":
                StarterJPA.start();
                break;
            default:
                System.out.println("Unknown type, exiting program immediately!");
                break;
        }
    }
}
