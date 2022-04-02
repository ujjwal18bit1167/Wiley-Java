package file_handling;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class copy {
    public static void main(String[] args) throws IOException {
        File f = new File("file_handling/test1.txt");
        FileWriter writer = new FileWriter("file_handling/test3.txt", true);
        try (Scanner fileReader = new Scanner(f);) {
            while (fileReader.hasNextLine()) {
                String temp = fileReader.nextLine();
                System.out.println(temp);
                writer.write(temp);

            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
