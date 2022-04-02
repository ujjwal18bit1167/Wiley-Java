package Week3;

import java.util.Scanner;

public class RockPaperScissor {
    static int randomNo(int min, int max) {
        return ((int) Math.floor((Math.random() * (max - min + 1)) + min));
    }

    static String winner(int randomChoice, int choice) {
        if ((randomChoice == 1 && choice == 3) || (randomChoice == 2 && choice == 1)
                || (randomChoice == 3 && choice == 2)) {
            return ("Computer Won");
        } else if ((randomChoice == 1 && choice == 2) || (randomChoice == 2 && choice == 3)
                || (randomChoice == 3 && choice == 1)) {
            return ("You Won");
        } else {
            return (" Draw");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char option;
        int choice;
        int randomChoice;
        System.out.println("Enter your choice 1. Rock\n2. Paper\n3.Scissor");
        do {
            randomChoice = randomNo(1, 3);

            System.out.print("Choose your Pick : ");
            do {
                choice = sc.nextInt();
                if (choice <= 3 && choice >= 1) {
                    break;
                }
                System.out.print("Wrong Choice. Choose again : ");
            } while (true);

            System.out.println("-----" + winner(randomChoice, choice) + "-----\n");

            System.out.println("Do you want to play again?(Y/n)");
            option = sc.next().charAt(0);

        } while (option == 'Y' || option == 'y');
        sc.close();
    }
}