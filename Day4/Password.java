package Day4;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        int lowercase = 0, uppercase = 0, digits = 0;
        for (int i = 0; i < n; i++) {
            char mychar = str.charAt(i);
            if (mychar >= 65 && mychar <= 90)
                uppercase++;
            else if (mychar >= 97 && mychar <= 122)
                lowercase++;
            else if (mychar >= 48 && mychar <= 57)
                digits++;
        }
        System.out.println("Uppercase " + uppercase);
        System.out.println("LowerCase " + lowercase);
        System.out.println("Digits " + digits);

    }
}
