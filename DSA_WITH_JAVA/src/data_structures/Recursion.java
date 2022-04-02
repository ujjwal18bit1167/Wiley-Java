package DSA_WITH_JAVA.src.data_structures;

public class Recursion {
    public static int fibo(int n) {
        if (n == 1 || n == 2)
            return n - 1;
        else
            return fibo(n - 1) + fibo(n - 2);

    }

    public static void main(String[] args) {
        System.out.println(fibo(7));
    }

}
