import java.util.Scanner;

public class LargestAndSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a > b && a > c)
            System.out.println("The largest of 3 numbers is " + a);
        else if (b > a && b > c)
            System.out.println("The largest of 3 numbers is " + b);
        else
            System.out.println("The largest of 3 numbers is " + c);

        if (a < b && a < c)
            System.out.println("The smallest of 3 numbers is " + a);
        else if (b < a && b < c)
            System.out.println("The smallest of 3 numbers is " + b);
        else
            System.out.println("The smallest of 3 numbers is " + c);

    }
}
