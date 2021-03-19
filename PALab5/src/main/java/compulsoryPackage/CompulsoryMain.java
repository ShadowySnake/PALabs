package compulsoryPackage;

import compulsoryPackage.catalogPackage.Catalog;

import java.io.IOException;

public class CompulsoryMain {
    public static void main(String[] args) throws IOException, CustomException{
        Catalog itemsCatalog = new Catalog("D:\\Facultate\\An 2\\Sem 2\\PA\\HERE");

        itemsCatalog.save("catalog.data");
        itemsCatalog.load("catalog.data");
    }
}
