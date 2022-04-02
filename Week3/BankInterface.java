package Week3;

interface RBI {
    double rateOfInterest = 4;

    double showBalance();

    double withdraw(double amount);

    double deposit(double amount);

    double calculateYearlyInterest();
}

class SBIAccount implements RBI {
    protected String accHolder;
    protected double accBalance;
    protected int accNumber;
    private static int count = 0;
    static int accOpeningBonus = 1000;

    public SBIAccount(String accHolder) {
        this.accHolder = accHolder;
        this.accNumber = ++count;
        this.accBalance = accOpeningBonus;
    }

    public SBIAccount(String accHolder, double accBalance) {
        this.accHolder = accHolder;
        this.accBalance = accBalance + accOpeningBonus;
        this.accNumber = ++count;
    }

    @Override
    public double showBalance() {
        return accBalance;
    }

    @Override
    public double withdraw(double amount) {
        if ((this.accBalance - amount) > 0)
            this.accBalance -= amount;
        return this.accBalance;
    }

    @Override
    public double deposit(double amount) {
        this.accBalance += amount;
        return this.accBalance;
    }

    @Override
    public double calculateYearlyInterest() {
        return (this.accBalance * RBI.rateOfInterest) / 100.0;
    }

    void displayFeatures() {
        System.out.println(" SBI users will get account opening bonus of " + accOpeningBonus);
    }

    @Override
    public String toString() {
        return "SBIAccount [accBalance=" + accBalance + ", accHolder=" + accHolder + ", accNumber=" + accNumber + "]";
    }

}

class ICICIAccount implements RBI {
    protected String accHolder;
    protected double accBalance;
    protected int accNumber;
    private static int count = 0;
    static double additionalIntrest = 2.0;

    public ICICIAccount(String accHolder) {
        this.accHolder = accHolder;
        this.accNumber = ++count;
        this.accBalance = 0;
    }

    public ICICIAccount(String accHolder, double accBalance) {
        this.accHolder = accHolder;
        this.accBalance = accBalance;
        this.accNumber = ++count;
    }

    @Override
    public double showBalance() {
        return accBalance;
    }

    @Override
    public double withdraw(double amount) {
        if ((this.accBalance - amount) > 0)
            this.accBalance -= amount;
        return this.accBalance;
    }

    @Override
    public double deposit(double amount) {
        this.accBalance += amount;
        return this.accBalance;
    }

    @Override
    public double calculateYearlyInterest() {
        return (this.accBalance * (RBI.rateOfInterest + additionalIntrest)) / 100.0;
    }

    void displayFeatures() {
        System.out.println("ICICI account holders will get additional interest of " + additionalIntrest);
    }

    @Override
    public String toString() {
        return " ICICI Account [accBalance=" + accBalance + ", accHolder=" + accHolder + ", accNumber=" + accNumber
                + "]";
    }

}

public class BankInterface {
    public static void main(String[] args) {
        SBIAccount sbi = new SBIAccount("Ujjwal", 25000);
        System.out.println(sbi.toString());

        ICICIAccount icici = new ICICIAccount("Ram", 15000);
        System.out.println(icici.toString());
    }
}