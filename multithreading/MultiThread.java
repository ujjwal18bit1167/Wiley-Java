package multithreading;

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("5*" + i + "=" + (5 * i));
        }
        System.out.println("t1 terminating...");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        String[] arr = new String[] { "Ram", "Shyam", "Shwetank", "Rohan", "Shivank" };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
        System.out.println("t2 terminating...");
    }

}

public class MultiThread {
    public static void main(String[] args) {
        System.out.println("Main thread running....");
        MyThread t1 = new MyThread();
        MyThread2 t = new MyThread2();
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        System.out.println("Ujjwal");
        System.out.println("India");
        System.out.println("Playing badminton..");
        System.out.println("Main terminating...");

    }
}
