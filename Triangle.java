import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a == b && a == c)
            System.out.println("Equilateral");
        else if ((a == b && a != c) || (b == c && a != b) || (a == c && a != b))
            System.out.println("isoceles");
        else
            System.out.println("Scalene");
    }
}
