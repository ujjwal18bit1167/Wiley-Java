package file_handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws IOException {
        File f1 = new File("file_handling/playground.txt");

        try (Scanner sc = new Scanner(f1);) {
            while (sc.hasNextLine()) {
                String mystr = sc.nextLine();
                System.out.println(mystr);
                StringBuilder sb = new StringBuilder(mystr);
                int n = mystr.length();
                sb.insert(5, '@');
                int count = 0;
                int i;
                for (i = 0; i < n; i++) {
                    if (sb.charAt(i) == ' ')
                        count++;
                    if (count == 2)
                        break;

                }
                sb.insert(i, "123");
                System.out.println(sb);
                FileWriter writer = new FileWriter("file_handling/playground.txt");
                // FileWriter writer = new FileWriter(f1); //we can do this also
                writer.write(sb.toString());
                writer.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
