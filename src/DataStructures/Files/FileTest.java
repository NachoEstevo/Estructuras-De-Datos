package DataStructures.Files;

import java.io.File;

public class FileTest {

    public FileTest(String path){
        File newFile = new File(path);

        if (newFile.exists()){
            System.out.println("The file exists");
        }
        else{
            System.out.println("The file does not exist");
        }
    }

    public static void main(String[] args) {
        FileTest test1 = new FileTest("C:\\Users\\nacho\\OneDrive\\Escritorio\\Enunciado.pdf");
        FileTest test2 = new FileTest("C:\\Users\\nacho\\OneDrive\\Escritorio\\ningunArchivo.txt");
    }
}
