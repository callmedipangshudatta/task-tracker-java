//Keep our task tracker file unchanged

import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args){
        try{
            FileWriter writer =  new FileWriter("notes.txt");

            writer.write("Hello Dipangshu Datta");

            writer.close();
            System.out.println("File Created");
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}
