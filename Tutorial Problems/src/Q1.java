class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    public BankAccount(int accountNumber, String accountHolderName, double
            balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }

    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    public void displayDetails() {
        System.out.println("\nAccount Details");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance : " + balance);
    }
}
public class Q1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001, "John Doe", 5000);
        account.displayDetails();
        account.deposit(2000);
        account.withdraw(1500);
        account.displayDetails();
    }
}