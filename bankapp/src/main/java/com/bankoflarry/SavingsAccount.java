package com.bankoflarry;

// This is the savings account child class
// Savings account has an interest rate
// Includes a method to apply interest for using account

public class SavingsAccount extends BaseAccount {

    // interest rate
    private double interestRate;

    // default constructor
    public SavingsAccount() {
        super(); // calls parent class constructor
    }

    /*
      Parameter constructor to initialize savings account
      with a custom account number and interest rate.
    */
    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // here is the getter method to get interest
    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    // method to apply interest to balance
    public void applyInterest() {
        double interest = calcInterest();
        System.out.println("Interest amount added: " + interest);
        deposit(interest);
    }

    @Override
    public void deposit(double amount) {
        // Create conditional statement to check amount
        // if condition is met then apply amount and send customer confirmation
        if(amount > 0 && amount <= 600) {
            balance += amount;
            // notify customer of successful deposit transaction
            System.out.println("Your deposit was successful! Amount deposited : " + amount);
            System.out.println("Your total savings account balance is: " + balance);
        } else {
            System.out.println("Invalid deposit amount entered");
        }
    }

    @Override
    public void withdraw(double amount) {
        // Create conditional statement to check amount
        // if condition is met then apply amount and send customer confirmation
        if ((amount > 0 && amount <= 600) && balance > 21.5) {
            System.out.println("Amount withdrawn from savings: " + amount);
            balance -= amount;
            System.out.println("Current savings account balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Cannot withdraw amount entered.");
        }
    }
}
