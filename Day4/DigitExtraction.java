package Day4;

import java.util.Scanner;

public class DigitExtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n > 0) {
            int rem = n % 10;
            System.out.println(rem);
            n = n / 10;
        }

    }
}
