package Day6;

import java.util.Scanner;

class BankAccount {
    int accNo;
    String accHolderName;
    int accBalance;

    public BankAccount() {
        this.accNo = 0;
        this.accHolderName = "";
        this.accNo = 5;
    }

    public BankAccount(int accNo, String accHolderName, int accBalance) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.accBalance = accBalance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public int getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }

    public void MoreFeatures() {
    }

    public BankAccount copy(BankAccount obj) {
        return new BankAccount(this.accNo, this.accHolderName, this.accBalance);
    }

    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolderName=" + accHolderName + ", accNo=" + accNo + "]";
    }

}

class SavingsAccount extends BankAccount {

    double rateOfInterest;

    public SavingsAccount(double rateOfInterest, int accBalance, String accHolderName, int accNo) {
        super(accBalance, accHolderName, accNo);
        this.rateOfInterest = rateOfInterest;

    }

    public SavingsAccount(int accNo, String accHolderName, int accBalance) {
        super(accNo, accHolderName, accBalance);
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public double getComputedInterest(int year) {
        return ((accBalance * rateOfInterest * year) / 100);
    }

    public double getYearlyInterest() {
        return this.getComputedInterest(1);
    }

    @Override
    public String toString() {
        return "SavingsAccount [Yearly interest = " + getYearlyInterest() + ", Computed interest: "
                + getComputedInterest(5) + "]";
    }

}

class CurrentAccount extends BankAccount {
    int avgDailyTransaction;

    public CurrentAccount(int avgDailyTransaction, int accBalance, String accHolderName, int accNo) {
        super(accNo, accHolderName, accNo);
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public CurrentAccount(int accNo, String accHolderName, int accBalance) {
        super(accNo, accHolderName, accBalance);
    }

    public int getAvgDailyTransaction() {
        return avgDailyTransaction;
    }

    public void setAvgDailyTransaction(int avgDailyTransaction) {
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public int getYearlyTransaction() {
        return getTotalTransactionAmount(365);
    }

    public int getTotalTransactionAmount(int days) {
        return avgDailyTransaction * days;
    }

    @Override
    public String toString() {
        System.out.println("CurrentAccount: ");
        return super.toString() + String.format("%nCurrentAccount: Avg Daily Transaction= %d", avgDailyTransaction);
    }

}

public class DriverClass {
    public static BankAccount salaryAccount(int accNo, String accHolderName, int accBalance) {
        return new BankAccount(accNo, accHolderName, accBalance) {
            int salary = 5000;
            int pfAmount = 200;
            double incomeTaxRate = 5;

            public double getYearlyTax() {
                return salary * 12 * incomeTaxRate / 100;
            }

            public double getInHandSalary() {
                return (salary * 12) - getYearlyTax() - (pfAmount * 12);
            }

            @Override
            public void MoreFeatures() {
                // System.out.println(this);
                System.out.println("Yearly tax: " + this.getYearlyTax());
                System.out.println("Inhand Salary: " + this.getInHandSalary());

            }

            @Override
            public String toString() {
                System.out.print("SalaryAccount: ");
                return super.toString() + String.format("%nSalary: %d%n pfAmount: %d%n incomeTaxRate: %f%n", salary,
                        pfAmount, incomeTaxRate);
            }
        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of objects to create: ");
        int n = s.nextInt();
        BankAccount[] BankAccountArr = new BankAccount[n];
        SavingsAccount[] savingsAccountArr = new SavingsAccount[n];
        CurrentAccount[] currentAccountArr = new CurrentAccount[n];
        BankAccount[] salaryAccountArr = new BankAccount[n];

        for (int i = 0; i < n; i++) {
            BankAccountArr[i] = new BankAccount(i + 1, "GeneralAccount", 50000);
            savingsAccountArr[i] = new SavingsAccount(i + 1, "SavingsAccount", 50000);
            currentAccountArr[i] = new CurrentAccount(i + 1, "CurrentAccount", 50000);
            salaryAccountArr[i] = salaryAccount(i + 1, "GeneralAccount", 50000);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(BankAccountArr[i]);
            System.out.println(savingsAccountArr[i]);
            System.out.println(currentAccountArr[i]);
            System.out.println(salaryAccountArr[i]);
        }
        System.out.println(BankAccountArr[0]);
        System.out.println("Copy of general Bank Account: " + BankAccountArr[0].copy(BankAccountArr[0]));
        System.out.println("Copy of Savings Account: " + BankAccountArr[0].copy(savingsAccountArr[0]));
        System.out.println("Copy of Current Account: " + BankAccountArr[0].copy(currentAccountArr[0]));

    }

}
