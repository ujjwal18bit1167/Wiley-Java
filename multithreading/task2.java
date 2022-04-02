package multithreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Shakespeare {
    synchronized public void writeEpicStuff(String str) throws IOException {

        FileWriter writer = new FileWriter("multithreading/play.txt", true);
        int n = str.length();

        for (int i = 0; i < str.length(); i++) {
            writer.write(str.charAt(i));

            writer.flush(); // we need some delay so we used this

        }
        writer.close();
    }

    // Uncomment this below code to compare the output of unsynchronised with
    // synchonised

    // public void writeEpicStuff(String str) throws IOException {

    // FileWriter writer = new FileWriter("multithreading/play.txt", true);
    // int n = str.length();

    // for (int i = 0; i < n; i++) {
    // writer.write(str.charAt(i));
    // writer.flush();

    // }
    // writer.close();
    // }
}

class MyNewThread extends Thread {
    private String content;
    private Shakespeare shakespeare;

    MyNewThread(String content, Shakespeare s) {
        this.content = content;
        this.shakespeare = s;
    }

    @Override
    public void run() {
        try {
            this.shakespeare.writeEpicStuff(this.content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class task2 {
    public static void main(String[] args) throws InterruptedException {
        Shakespeare s = new Shakespeare();
        MyNewThread t1 = new MyNewThread("Et tu Brute!", s);
        MyNewThread t2 = new MyNewThread("Hamlet is a small village.", s);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        File f = new File("multithreading/play.txt");
        try (Scanner fileReader = new Scanner(f);) {
            while (fileReader.hasNextLine()) {
                String temp = fileReader.nextLine();
                System.out.println(temp);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
