package Serialization;

import java.io.Serializable;

class BankAccount implements Serializable {
    int accNum;
    String accHolder;
    int accBalance;

    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolder=" + accHolder + ", accNum=" + accNum + "]";
    }

    public void displayBalance() {
        System.out.println("The balance is " + accBalance);
    }

    public BankAccount(int accNum, String accHolder, int accBalance) {
        this.accNum = accNum;
        this.accHolder = accHolder;
        this.accBalance = accBalance;
    }

}