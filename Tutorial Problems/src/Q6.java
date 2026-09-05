class Account {
    String accountNumber;
    String holderName;
    double balance;

    Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountNumber, String holderName,
                   double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }
    void displayDetails() {
        System.out.println("Savings Account");
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountNumber, String holderName,
                   double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    void displayDetails() {
        System.out.println("Current Account");
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

interface PaymentQ6 {
    void pay(double amount);
}

interface SecurePayment extends PaymentQ6 {
    void verifyPayment();
}

interface OnlineTransaction {
}
class UPIPaymentQ6 implements SecurePayment, OnlineTransaction {

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }

    public void verifyPayment() {
        System.out.println("UPI payment verified");
    }
}

class CardPayment implements Payment, OnlineTransaction {

    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

public class Q6 {
    public static void main(String[] args) {
        Account a;
        a = new SavingsAccount("S101", "Rahul", 50000, 5.5);
        a.displayDetails();

        System.out.println();

        a = new CurrentAccount("C101", "Arun", 75000, 20000);
        a.displayDetails();

        System.out.println();

        Payment p;

        p = new UPIPayment();

        if (p instanceof SecurePayment) {
            SecurePayment s = (SecurePayment) p;
            s.verifyPayment();
        }

        p.pay(2500);

        System.out.println();
        p = new CardPayment();
        p.pay(5000);

        System.out.println();

        if (p instanceof OnlineTransaction) {
            System.out.println("Card payment is an online transaction");
        }
    }
}