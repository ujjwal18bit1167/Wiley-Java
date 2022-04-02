package Day4;

import java.util.Scanner;

public class Armsstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int original = n;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += Math.pow(rem, 3);
            n = n / 10;

        }
        if (sum == original)
            System.out.println("Armstrong");
        else
            System.out.println("Not Armstrong");
    }
}
