package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplorer {
    public static void main(String[] args) {
        DisplayLocales display = new DisplayLocales();
        SetLocale set = new SetLocale();
        Info info = new Info();

        Locale currentLocale = Locale.getDefault();
        String baseName = "res.Messages";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, currentLocale);
        while (true) {
            Scanner commandScanner = new Scanner(System.in);
            System.out.println(resourceBundle.getString("prompt"));
            String command = commandScanner.nextLine();

            if (command.equals("stop")) break;

            switch (command) {
                case "all locales":
                case "toate locatiile":
                    display.display(resourceBundle);
                    break;
                case "set locale":
                case "seteaza locatia":
                    currentLocale = set.set(currentLocale);
                    resourceBundle = ResourceBundle.getBundle(baseName, currentLocale);
                    break;
                case "info":
                    info.info(resourceBundle);
                    break;
                default:
                    System.out.println(resourceBundle.getString("invalid"));
                    break;
            }
        }
    }
}
