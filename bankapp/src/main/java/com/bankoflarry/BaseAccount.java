package com.bankoflarry;
/*
Resource: "#Java OOP Simple #Bank #Account Application
#Inheritance and Is a #Relationship, author: CodingHelpLine,
published on Oct 6, 2020, on Youtube, url: https://www.youtube.com/watch?v=-HZSyjuuOsc
 */
// Here is the base class
// It will be abstract
public abstract class BaseAccount {

    // Account number variable
    private int accountNumber;

    // Account balance variable
    // protected access modifier so it can be edited in child class
    protected double balance;

    // default constructor
    public BaseAccount() {

    }

    // Here is the constructor
    public BaseAccount(int accountNum) {
        this.accountNumber = accountNum;
        balance = 0;
    }

    // getter methods
    /* no set balance methods because a basic bank account
    contract can only have deposit || increase and withdrawal || decrease */
    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

// here are the abstract methods

    /* Deposit function to deposit money into
    * an account as long as the amount to deposit is > 0
    * Also applying a transaction fee for the checking account
    * at parameter amount value to be deposited */
    public abstract void deposit(double amount);

    /* Withdraw function to withdraw funds from the
    * account as long as the amount to withdraw is > 0
    * and the amount to withdraw must be <= balance */
    public abstract void withdraw(double amount);
}
