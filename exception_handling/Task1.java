package exception_handling;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a,b and c: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        try {
            int result1 = a / b;
            int result2 = result1 / c;
            System.out.println(result2);
            int arr[] = new int[result2];
            System.out.println("Enter array elements...");
            for (int i = 0; i < result2; i++)
                arr[i] = scanner.nextInt();
            System.out.println("Third element of the array is " + arr[2]);

        } catch (ArithmeticException e) {
            System.out.println("Sorry! Integer division by zero not possible.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! Index of out bounds....");
        }

    }
}
