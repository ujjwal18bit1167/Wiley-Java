package Day4;

public class aditionalProgram {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Used For Loop");
        for (int i = 1; i <= 10; i++) {
            int sum = 0;
            sum = i * (i + 1) / 2;
            System.out.println(sum);
        }
        int sum1 = 0;
        int i = 1;
        System.out.println("Used While Loop");
        while (sum1 < 100) {
            sum1 = i * (i + 1) / 2;
            if (sum1 < 100) {
                System.out.println(sum1);
            }
            i++;

        }

    }
}
