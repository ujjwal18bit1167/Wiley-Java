package multithreading;

class PrintTable {
    int x;

    PrintTable(int x) {
        this.x = x;
    }

    synchronized void printTable() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(x + "*" + i + "=" + (x * i));
        }
    }
}

class ThreadPrintTable extends Thread {
    PrintTable t;

    ThreadPrintTable(PrintTable t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable();
    }
}

public class ThreadPrintTableDemo {
    public static void main(String[] args) {
        PrintTable t = new PrintTable(5);

        // Here t1 and t2 threads are trying to use the shared resouce i.e printTable()
        // method and
        // they do context switching while printing
        // to prevent the interference of other thread when one thread is using the
        // shared resource, we can set the method synchronised
        ThreadPrintTable t1 = new ThreadPrintTable(t);
        ThreadPrintTable t2 = new ThreadPrintTable(t);
        t1.start();
        t2.start();
    }

}
