package Serialization;

import java.io.IOException;
import java.io.*;

public class ATM {
    public static void main(String[] args) throws IOException {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("Serialization/account.txt");
            in = new ObjectInputStream(fin);
            BankAccount bankAccount = (BankAccount) in.readObject();
            System.out.println(bankAccount);
            bankAccount.displayBalance();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            in.close();
            fin.close();
        }
    }
}
