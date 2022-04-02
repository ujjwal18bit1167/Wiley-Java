package Week3;

import java.util.*;

interface in1 {
    void display(int a);
}

class testClass implements in1 {

    public boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                prime = false;
        }
        return prime;
    }

    public int count(int p) {
        int res = 0;
        for (int i = 2; i <= p; i++) {
            if (isPrime(i))
                res++;
        }
        return res;
    }

    public void display(int p) {
        System.out.println(count(p));
    }
}

public class InterfacePrime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter no of test Cases:");
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            testClass test = new testClass();
            test.display(s.nextInt());
        }

    }
}