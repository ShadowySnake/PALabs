package compulsoryPackage;

import compulsoryPackage.catalogPackage.Catalog;
import compulsoryPackage.exceptionsThrower.CustomException;
import compulsoryPackage.itemsPackage.PNG_image;
import compulsoryPackage.itemsPackage.TextFile;

import java.io.IOException;

public class CompulsoryMain {
    public static void main(String[] args) throws IOException, CustomException {
        Catalog itemsCatalog = new Catalog("D:\\Facultate\\An 2\\Sem 2\\PA\\HERE");

        itemsCatalog.add(new TextFile("SomeFile","This is a text file!","\\newItems"));
        itemsCatalog.save("catalog.data");
        itemsCatalog.add(new PNG_image("SomePNG","This is a PNG!", "\\newItems"));
        itemsCatalog.list();
        itemsCatalog.play("SomePNG");

        itemsCatalog = itemsCatalog.load("catalog.data");
        itemsCatalog.list();
    }
}
