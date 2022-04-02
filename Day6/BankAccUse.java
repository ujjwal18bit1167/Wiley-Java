package Day6;

import Week3.BankAccount;
import Week3.CurrentAccount;
import Week3.SavingsAccount;

class BankAccount {
    private int accNo;
    private String accHoldername;
    private int accBalance;

    public BankAccount(int accNo, String accHoldername, int accBalance) {
        this.accNo = accNo;
        this.accHoldername = accHoldername;
        this.accBalance = accBalance;
    }

    public BankAccount(int accNo, String accHoldername) {
        this.accNo = accNo;
        this.accHoldername = accHoldername;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccHoldername() {
        return accHoldername;
    }

    public void setAccHoldername(String accHoldername) {
        this.accHoldername = accHoldername;
    }

    public int getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(int accBalance) {

        this.accBalance = accBalance;
    }

    public String toString() {
        return String.format("Account Number: %d %n AccountHolderName : %s %n Account Balance: %d", this.getAccNo(),
                this.getAccHoldername(), this.getAccBalance());
    }

}

class SavingsAccount extends BankAccount {
    private float rateOfInterest;

    public SavingsAccount(int accNo, String accHoldername, int accBalance, float rateOfInterest) {
        super(accNo, accHoldername, accBalance);
        this.rateOfInterest = rateOfInterest;
    }

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(float rateOfInterest) {

        this.rateOfInterest = rateOfInterest;
    }

    public float getYearlyInterest() {
        // return (getAccBalance() * this.getRateOfInterest()) / 100;
        return getComputedInterest(1);
    }

    public float getComputedInterest(int years) {
        return (getAccBalance() * this.getRateOfInterest() * years) / 100;
    }

    public String toString() {

        return super.toString() + String.format(" %nRate Of Interest : %f ", this.getRateOfInterest());
    }
}

class CurrentAccount extends BankAccount {
    private int avgDailyTransaction;

    public CurrentAccount(int accNo, String accHoldername, int accBalance, int avgDailyTransaction) {
        super(accNo, accHoldername, accBalance);
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public int getAvgDailyTransaction() {
        return avgDailyTransaction;
    }

    public void setAvgDailyTransaction(int avgDailyTransaction) {

        this.avgDailyTransaction = avgDailyTransaction;
    }

    public int getYearlyTransaction() {
        return getAvgDailyTransaction() * 365;
    }

    public int gettotalTransactionAmount(int days) {
        return getAvgDailyTransaction() * days;
    }

    public String toString() {

        return super.toString() + String.format(" %nAverage Daily Transaction : %d", this.getAvgDailyTransaction());
    }

}

public class BankAccUse {
    public static void main(String[] args) {
        BankAccount generalAcc = new BankAccount(1234, "Ujjwal Gupta", 25000);
        System.out.println(generalAcc.toString());
        System.out.println();

        SavingsAccount savingsAcc = new SavingsAccount(1235, "Rohan", 75000, 5);
        System.out.println(savingsAcc.toString());
        System.out.println();

        CurrentAccount currentAccount = new CurrentAccount(1236, "Sohan", 80000, 100);
        System.out.println(currentAccount.toString());

        BankAccount salaryAcc = new BankAccount(2231, "Ram", 4000) {
            int salary = 10000;
            int pfAmount = 2000;
            float incomeTaxRate = 10;

            float getYearlyTax() {
                return (salary * 12) * incomeTaxRate / 100;
            }

            float getInHandSalary() {
                float tax = salary * incomeTaxRate / 100;
                return salary - tax - pfAmount;
            }

            public String toString() {
                return String.format(
                        "Salary: %d %nPf Amount: %d %nIncome Tax Rate: %.1f %nYearly Tax: %.1f %nGet Inhand Salary: %.1f",
                        salary, pfAmount, incomeTaxRate, getYearlyTax(), getInHandSalary());
            }

        };

    }
}
