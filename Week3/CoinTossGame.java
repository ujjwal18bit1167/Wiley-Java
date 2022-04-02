package Week3;

import java.util.Scanner;

class Coin {
    String sideUp;

    Coin() {
        toss();
    }

    void toss() {
        int ran = (int) ((Math.random() * (2)) + 1);

        if (ran == 1)
            sideUp = "heads";
        else
            sideUp = "tails";
        System.out.println("The side up is: " + sideUp);

    }

    String getSideUp() {
        return sideUp;
    }
}

public class CoinTossGame {
    static double value;
    static String cointype;
    static double balance;

    static void findcoin() {
        int c = (int) ((Math.random() * (3)) + 1);
        if (c == 1) {
            cointype = "quater";
            value = .25;
        } else if (c == 2) {
            cointype = "dime";
            value = .15;
        } else {
            cointype = "nickel";
            value = .10;
        }
        System.out.println("You selected: " + cointype);
    }

    static void winningFunction() {
        balance += value;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coin cb = new Coin();
        boolean choice = true;
        while (choice) {
            while (balance < 1) {

                System.out.println("Enter 1 to select a coin!");
                int n = sc.nextInt();
                if (n == 1) {
                    findcoin();
                    System.out.println("Now press 2 to toss the coin!");
                    int ct = sc.nextInt();
                    if (ct == 2) {
                        cb.toss();
                        if (cb.sideUp == "heads") {
                            winningFunction();
                        }
                        System.out.println("The balance for this round is: " + balance);

                    } else {
                        System.out.println("Wrong input!");
                        System.exit(0);
                    }

                } else {
                    System.out.println("Wrong input!");
                    System.exit(0);
                }
            }
            if (balance == 1)
                System.out.println("YOU WIN!!");
            else if (balance > 1)
                System.out.println("YOU LOSE!");
            System.out.println("Do you want to play again?(Y/N)");
            if (sc.next().charAt(0) == 'Y') {
                choice = true;
                balance = 0;
            } else
                choice = false;
        }

    }

}
