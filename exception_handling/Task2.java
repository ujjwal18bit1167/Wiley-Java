package exception_handling;

import java.util.Scanner;

class MathUtils {
    // -------------------------------------------------------------
    // Returns the factorial of the argument given
    // -------------------------------------------------------------

    public static int factorial(int n) throws IllegalArgumentException { // here throws not needed becoz by default
                                                                         // throws RuntimeException
        if (n < 0) {
            throw new IllegalArgumentException("Please neter a positive number....");
        }
        if (n > 16) {
            throw new IllegalArgumentException("Please enter value less than 17....");
        }
        int fac = 1;
        for (int i = n; i > 0; i--)
            fac *= i;
        return fac;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            System.out.println("Factorial of " + n + " is :" + MathUtils.factorial(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
