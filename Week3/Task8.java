package Week3;

import java.util.Scanner;

class BankAccount {
    String accNo;
    String accHolderName;
    Double accBalance;

    public BankAccount() {
        this.accNo = "";
        this.accHolderName = "New member";
        this.accBalance = 0.0;
    }

    public BankAccount(String accNo, String accHolderName) {
        this();
        this.accNo = accNo;
        this.accHolderName = accHolderName;
    }

    public BankAccount(String accNo, String accHolderName, Double accBalance) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.accBalance = accBalance;
    }

    public String getAccNo() {
        return this.accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return this.accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public Double getAccBalance() {
        return this.accBalance;
    }

    public void setAccBalance(Double accBalance) {
        this.accBalance = accBalance;
    }

    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolderName=" + accHolderName + ", accNo=" + accNo + "]";
    }

    public void additionalFeature() {
    }

    public BankAccount getStatement() {
        System.out.println("Name is " + this.accHolderName + " and type is GeneralAccount");
        return new BankAccount();
    }
    // public BankAccount copyObject(BankAccount obj)
    // {
    // return new T (obj.)
    // }
}

class SavingsAccount extends BankAccount {
    static double rateOfInterest = 7.4;

    public SavingsAccount(String accNo, String accHolderName) {
        super(accNo, accHolderName);
    }

    public double getYearlyInterest() {
        return (this.accBalance * rateOfInterest);
    }

    public double getComputedInterest(int years) {
        return this.getYearlyInterest() * years;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    SavingsAccount copyObject(SavingsAccount obj) {
        return new SavingsAccount(obj.accNo, accHolderName);
    }

    @Override
    public SavingsAccount getStatement() {
        System.out.println("Name is " + this.accHolderName + " and type is SavingAccount");
        return new SavingsAccount("123", "savingMem");
    }

}

class CurrentAccount extends BankAccount {
    protected double avgDailyTransaction;

    public CurrentAccount(String accNo, String accHolderName, double avgDailyTransaction) {
        super(accNo, accHolderName);
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public CurrentAccount(String accNo, String accHolderName) {
        super(accNo, accHolderName);
        this.avgDailyTransaction = 0.0;
    }

    public double getAvgDailyTransaction() {
        return this.avgDailyTransaction;
    }

    public void setAvgDailyTransaction(double avgDailyTransaction) {
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public double getTotalTransactionAmount(int days) {
        return this.avgDailyTransaction * days;
    }

    public double getYearlyTransaction() {
        return this.getTotalTransactionAmount(365);
    }

    @Override
    public String toString() {
        return super.toString() + "\nCurrentAccount [avgDailyTransaction=" + avgDailyTransaction + "]";
    }

    @Override
    public CurrentAccount getStatement() {
        System.out.println("Name is " + this.accHolderName + " and type is CurrrentAccount");
        return new CurrentAccount("123", "savingMem");
    }
}

public class Task8 {

    public static void main(String[] args) {
        // BankAccount generalAcc = new BankAccount("1234SBI", "Kamini");
        // SavingsAccount savingsAcc = new SavingsAccount("2345SVACC", "Abc");
        // CurrentAccount currentAcc = new CurrentAccount("234DHSB1", "Xyz", 456.87);
        // // details
        // System.out.println(generalAcc.toString());
        // System.out.println(savingsAcc.toString());
        // System.out.println(currentAcc.toString());
        // // svaing accounts
        // // ->yearly interest
        // System.out.println("Yearly interest is " + savingsAcc.getYearlyInterest());
        // // ->computed yearly interest
        // System.out.println("Computed interest is " +
        // savingsAcc.getComputedInterest(3));
        // // current account
        // // ->yearly transaction
        // System.out.println("Yearly transaction is " +
        // currentAcc.getYearlyTransaction());
        // // ->get total transaction
        // System.out.println("Total transaction is " +
        // currentAcc.getTotalTransactionAmount(60));
        // // ------------------anonymous class
        // BankAccount salaryAcc = new BankAccount() {
        // double salary = 20000;
        // double pfAmt = 1500;
        // double incomeTaxRate = 2.2;

        // public double getYearlyTax() {
        // return (this.salary * 12 * this.incomeTaxRate) / 100 * 12;
        // }

        // public double getInHandYearlySalary() {
        // return this.salary - this.pfAmt - (this.getYearlyTax() / 12);
        // }
        // };
        // salaryAcc.getInHandYearlySalary();
        // -------------------task8.2
        // Take an integer 'n' as input from the user. Create 'n' objects of each of the
        // aforementioned account types.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  value of n : ");
        int n = sc.nextInt();
        BankAccount[] bankAccounts = new BankAccount[n];
        SavingsAccount[] savingsAccounts = new SavingsAccount[n];
        CurrentAccount[] currentAccounts = new CurrentAccount[n];
        BankAccount[] salaryAccounts = new BankAccount[n];
        for (int i = 0; i < n; i++) {
            bankAccounts[i] = new BankAccount("" + i + 1, "GeneralAccountMember" + i + 1);
            savingsAccounts[i] = new SavingsAccount("" + i + 1, "SavingAccountMember" + i + 1);
            currentAccounts[i] = new CurrentAccount("" + i + 1, "CurrentAccountMember" + i + 1, 1200.0);
            salaryAccounts[i] = new BankAccount("" + i + 1, "SalaryAccount" + i + 1) {
                double salary = 20000;
                double pfAmt = 1500;
                double incomeTaxRate = 2.2;

                public void additionalFeature() {
                    System.out.println("yearly tax is " + this.getYearlyTax() + " in hand salary is "
                            + this.getInHandYearlySalary());
                }

                public double getYearlyTax() {
                    return (this.salary * 12 * this.incomeTaxRate) / 100 * 12;
                }

                public double getInHandYearlySalary() {
                    return this.salary - this.pfAmt - (this.getYearlyTax() / 12);
                }
            };
        }

        SavingsAccount sav = new SavingsAccount("123422", "Ujjwal");
        System.out.println(sav.getStatement());

    }
}
