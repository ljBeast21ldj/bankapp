package com.bankoflarry;

import java.util.Scanner;

public class AccountDriver {

    // this is the entry point of the program
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        // array of accounts
        BaseAccount accounts[] = new BaseAccount[10];
    }

    // account options method
    public static int accountMenu(Scanner userInput) {
        System.out.println("Select account type");
        System.out.println("1. New Checking Account");
        System.out.println("2. New Savings Account");

        int options;

        do {
            System.out.println("Choose options #1-2: ");
            options = userInput.nextInt();
        } while(options < 1 || options > 2);
        return options;
    }

    // method to make deposit on selected account
    public void makeDeposit(BaseAccount account [], int count, Scanner userInput) {
        // retrieve account number
    }

    // method to create a new account
    public static BaseAccount createAccount(Scanner userInput) {
        BaseAccount account = null;
        int options = accountMenu(userInput);

        int accountNumber;
        System.out.println("Enter Account Number: ");
        accountNumber = userInput.nextInt();

        if(options == 1) { //checking option create checking
            System.out.println("Enter Transaction fee: ");
            double fee = userInput.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else { // savings option create savings
            System.out.println("Enter Interest Rate: ");
            double interest = userInput.nextDouble();
            account = new SavingsAccount(accountNumber, interest);
        }
        return account;
    }


    /*
    * Here is the menu that displays options and selections
    * */
    public static int mainMenu(Scanner userInput) {
        System.out.println("Welcome to my Bank! Main Menu");
        System.out.println("===================================");
        System.out.println("1. Create New Banking Account");
        System.out.println("2. Make a Deposit");
        System.out.println("3. Make a Withdrawal");
        System.out.println("4. Exit");

        int options;

        do {
            System.out.println("Enter Option #1-4: ");
            options = userInput.nextInt();
        } while(options < 1 || options > 4);
        return options;
    }
}
