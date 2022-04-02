package multithreading;

class EvenOdd {
    static int LIMIT = 100;
    int i = 1;

    synchronized void printEven() {
        while (i <= LIMIT) {
            if (i % 2 == 0) {
                System.out.println("Even " + i);
                i++;

                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    synchronized void printOdd() {

        while (i <= LIMIT) {
            if (i % 2 != 0) {
                System.out.println("Odd " + i);
                i++;
                notifyAll();
            } else
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}

public class PrintEvenOdd {
    public static void main(String[] args) {
        final EvenOdd evenOdd = new EvenOdd();

        Thread t1 = new Thread() {
            public void run() {
                evenOdd.printEven();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                evenOdd.printOdd();
            }
        };

        long startTime = System.nanoTime();

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
}
