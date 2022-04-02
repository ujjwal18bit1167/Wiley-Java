package Week3;

import java.util.Scanner;

public class HappyNumber {
    public static int happy(int number) {
        int rem = 0;
        int temp = 0;
        while (number > 0) {
            rem = number % 10;
            temp = temp + (rem * rem);
            number = number / 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        int k;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k value");
        k = sc.nextInt();
        int result = k;
        while (result != 1 && result != 4) {
            result = happy(result);
            System.out.println(result);
        }
        if (result == 1) {
            System.out.println("it is nice number ");
        } else {
            System.out.println("It is not a happy number " + result);
        }
        sc.close();
    }
}