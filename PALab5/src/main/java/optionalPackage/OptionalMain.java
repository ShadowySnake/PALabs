package optionalPackage;

import optionalPackage.catalogPackage.Catalog;
import optionalPackage.exceptionsThrower.CustomException;

import java.io.IOException;

public class OptionalMain {
    public static void main(String[] args) throws IOException, CustomException {
        Catalog itemsCatalog = new Catalog("D:\\Facultate\\An 2\\Sem 2\\PA\\HERE");

        Shell someShell = new Shell(itemsCatalog);
        someShell.run();
    }
}
