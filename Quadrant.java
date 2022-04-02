import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the coordinates ");
    int x = sc.nextInt();
    int y = sc.nextInt();
    if(x>0 && y>0)
        System.out.println("First quadrant");
    else if(x<0 && y>0)
        System.out.println("Second quadrant");
    else if(x<0 && y<0)
        System.out.println("Third quadrant");
    else
        System.out.println("Fourth quadrant");

    }
}
