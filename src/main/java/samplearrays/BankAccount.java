package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int transactionCount = 0;


    public BankAccount(String name, int startingBalance) {
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount) {
        currentBalance += amount;
        transactions[transactionCount++] = amount;
    }

    public void withdraw(double amount) {
        currentBalance -= amount;
        transactions[transactionCount++] = -amount;
    }

    public void displayTransactions() {
        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i] >= 0) {
                System.out.println("You have deposited the amount: " + transactions[i]);
            } else {
                System.out.println("You have Withdrawn the amount: " + (-transactions[i]));
            }
        }
    }

    public void displayBalance() {
        System.out.println("Your balance is now: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
