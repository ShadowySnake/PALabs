package compulsoryPackage.itemsPackage;

import java.io.Serializable;

public abstract class Items implements Serializable {
    String catalogNameFile;
    String fileDescription;
    String filePath;
    String fileExtension;

    public Items(String givenName, String givenDescription, String pathToFile){
        this.catalogNameFile = givenName;
        this.fileDescription = givenDescription;
        this.filePath = pathToFile;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getCatalogNameFile() {
        return catalogNameFile;
    }

    public String getFullPath(){
        return (this.getFilePath() + "\\" + this.getCatalogNameFile() + this.getFileExtension());
    }
}