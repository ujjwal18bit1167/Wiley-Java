package Week3;

import java.util.Scanner;
import java.util.Arrays;

public class UnionArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array 1 and array 2:");
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int[] res = new int[size1 + size2];
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < size1) {
            res[k++] = arr1[i++];
        }
        while (j < size2) {
            res[k++] = arr2[j++];
        }
        for (int l = 1; l < res.length; l++) {
            if (res[l] != res[l - 1]) {

                count++;
            }
        }

        count++;
        System.out.println(count);
    }
}