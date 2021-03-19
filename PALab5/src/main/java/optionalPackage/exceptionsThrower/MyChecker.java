package optionalPackage.exceptionsThrower;

import optionalPackage.itemsPackage.Items;

import java.io.File;
import java.io.Serializable;

public class MyChecker implements Serializable {
    String localPath;

    public MyChecker(String givenPath){
        this.localPath = givenPath;
    }

    /**
     * Method that checks to see if the file path exists
     * @param path this is the path to the file, including it's extension
     * @throws CustomException throws an exception only if the path is invalid of the file does not exist
     */
    public void checkPath(String path) throws CustomException {
        File file = new File(localPath + path);
        if( !file.isFile() ){
            throw new CustomException(path + " THE FILE MAY NOT EXIST OR THE PATH TO THE FILE IS INVALID!");
        }
    }

    /**
     * Method that checks if the file is a text file (.txt) or an image (.PNG)
     * @param extension this is the file extension
     * @throws CustomException throws an exception only if the extension is not a supported one
     * (anything other than .txt & .PNG)
     */
    public void checkExtension(String extension) throws CustomException {
        if ( !(extension.equals(".txt") || extension.equals(".PNG")) ){
            throw new CustomException(extension + " IS NOT A VALID EXTENSION!");
        }
    }

    /**
     * Method that checks if the file received is a valid one
     * @param item is the file we check the validity for
     * @throws CustomException throws one of the two exceptions above
     */
    public void checkValidity(Items item) throws CustomException {
        this.checkPath(item.getFullPath());
        this.checkExtension(item.getFileExtension());
    }
}
