package L06DefiningClasses.L03BankAccount;

public class BankAccount {
    private final static double DEFAULT_INTERESTING_RATE = 0.02;
    private static double interestRate = DEFAULT_INTERESTING_RATE;
    private static int idNumber = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = idNumber;
        idNumber++;
        this.balance = 0.0;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setId() {
        this.id = idNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setInterestRate(double newRate) {
        interestRate = newRate;
    }

    public double getInterest(int years) {
        return years * interestRate * this.balance;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

}