package Week3;

import java.util.Scanner;

public class ArrayTask {
    public static int fifthElement(int arr[]) {
        return arr[4];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int fifthElement = fifthElement(arr);
        System.out.println(fifthElement);
    }

}
