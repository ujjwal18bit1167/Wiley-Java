import java.util.Scanner;

public class displayValueOfm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n;
        if(m>0)
            n = 1;
        else if(m==0)
            n =0;
        else
            n = -1;
        System.out.println(n);
    }
}
