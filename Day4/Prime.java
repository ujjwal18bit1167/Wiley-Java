package Day4;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int j = 2; j <= n; j++) {
            int flag = 0;
            for (int i = 2; i < j; i++) {
                if (j % i == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)

                System.out.println(j + " is prime");
            else {
                int original = j;
                int temp = j;
                int sum = 0;
                while (temp > 0) {
                    int rem = temp % 10;
                    sum += Math.pow(rem, 3);
                    temp = temp / 10;

                }
                if (sum == original)
                    System.out.println(j + " is Armstrong");
                else
                    System.out.println(j + " is not Not Armstrong");
            }
        }

    }
}
