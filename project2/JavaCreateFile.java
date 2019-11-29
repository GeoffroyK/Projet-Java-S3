package project2;

import java.io.File;
import java.io.IOException;

public class JavaCreateFile {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\lespi\\desktop\\mypizza.reine");

        if (file.createNewFile()) {
            
            System.out.println("File has been created.");
        } else {
        
            System.out.println("File already exists.");
        }
    }
}


