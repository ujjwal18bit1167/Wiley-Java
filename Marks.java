import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float total = 0;
        total += sc.nextFloat();
        total += sc.nextFloat();
        total += sc.nextFloat();
        // float total = physics+chemistry+maths;
        float per = total / 3;
        System.out.println("The total marks are " + total);
        if (per >= 90)
            System.out.println("A");
        else if (per >= 80)
            System.out.println("B");
        else if (per >= 70)
            System.out.println("C");
        else if (per >= 60)
            System.out.println("D");
        else
            System.out.println("F");

    }
}
