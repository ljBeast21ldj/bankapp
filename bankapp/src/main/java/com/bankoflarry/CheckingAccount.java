package com.bankoflarry;

// Here is the checking account
public class CheckingAccount extends BaseAccount {

    // transaction fee
    private static double fee = 1.5;

    // default constructor
    public CheckingAccount() {
        super(); // calls parent class constructor
    }

    /*
      Parameter constructor to initialize checking account
      with a custom account number and a customer account
      transaction fee.
    */
    public CheckingAccount(int accountNumber, double accountFee) {
        super(accountNumber);
        fee = accountFee;
    }

    @Override
    public void deposit(double amount) {
        // Create conditional statement to check amount
        // if condition is met then apply amount and send customer confirmation
        if(amount > 0 && amount <= 600) {
            balance += amount;
            // notify customer of successful deposit transaction
            System.out.println("Your deposit was successful! Amount deposited : " + amount);
            System.out.println("Current checking account balance is: " + balance);
        } else {
            System.out.println("Invalid deposit amount entered");
        }
    }

    @Override
    public void withdraw(double amount) {
        // Create conditional statement to check amount
        // if condition is met then apply amount and send customer confirmation
        if ((amount > 0 && amount <= 600) && balance > 21.5) {
            System.out.println("Amount withdrawn from checking: " + amount);
            balance -= amount;
            balance -= fee;
            System.out.println("Transaction fee: "+ fee);
            System.out.println("Current checking account balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Cannot withdraw amount entered.");
        }
    }
}
