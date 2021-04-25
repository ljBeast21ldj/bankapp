package com.bankoflarry;

import java.util.Scanner;

public class AccountDriver {

    // this is the entry point of the program
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        // array of accounts
        BaseAccount accounts[] = new BaseAccount[10];
        int numOption = 0;

        int options;

        do {
            options = mainMenu(userInput);
            System.out.println();

            if(options == 1) {
                accounts[numOption++] = createAccount(userInput);
            } else if(options == 2) {
                makeDeposit(accounts, numOption, userInput);
            } else if(options == 3) {
                makeWithdrawal(accounts, numOption, userInput);
            } else if(options == 4) {
                applyInterest(accounts, numOption, userInput);
            } else {
                System.out.println("Thanks for Visiting!");
            }
            System.out.println();
        } while(options != 5);
    }

    // account options method
    public static int accountMenu(Scanner userInput) {
        System.out.println("Select account type");
        System.out.println("1. New Checking Account");
        System.out.println("2. New Savings Account");

        int options;

        do {
            System.out.println("Choose an option #1-2: ");
            options = userInput.nextInt();
        } while(options < 1 || options > 2);
        return options;
    }

    public static int searchAccount(BaseAccount accounts [], int count, int accountNumber) {
        for(int i = 0; i< count; i++) {
            if(accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    // method to make deposit on selected account
    public static void makeDeposit(BaseAccount accounts [], int count, Scanner userInput) {
        // retrieve account number
        System.out.println("Please enter account number: ");
        int accountNumber = userInput.nextInt();

        // search for account using account number
        int index = searchAccount(accounts, count, accountNumber);
        if(index >= 0) {
            // enter deposit amount
            System.out.println("Please enter deposit amount: ");
            double amount = userInput.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No records match account number: " + accountNumber);
        }
    }

    // method to make a withdrawal on selected account
    public static void makeWithdrawal(BaseAccount accounts [], int count, Scanner userInput) {
        // retrieve account number
        System.out.println("Please enter account number: ");
        int accountNumber = userInput.nextInt();

        // search for account using account number
        int index = searchAccount(accounts, count, accountNumber);
        if(index >= 0) {
            // enter deposit amount
            System.out.println("Please enter withdraw amount: ");
            double amount = userInput.nextDouble();

            accounts[index].withdraw(amount);
        } else {
            System.out.println("No records match account number: " + accountNumber);
        }
    }

    // apply interest to savings account
    public static void applyInterest(BaseAccount accounts [], int count, Scanner userInput) {
        // retrieve account number
        System.out.println("Please enter account number: ");
        int accountNumber = userInput.nextInt();

        // search for account using account number
        int index = searchAccount(accounts, count, accountNumber);
        if(index >= 0) {
            // making sure it is an instance of savings account
            // casting in order to use the apply interest method
            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No records match account number: " + accountNumber);
        }
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
            System.out.println("Success! Your checking account has been created.");
        } else { // savings option create savings
            System.out.println("Enter Interest Rate: ");
            double interest = userInput.nextDouble();
            account = new SavingsAccount(accountNumber, interest);
            System.out.println("Success! Your savings account has been created.");
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
        System.out.println("4. Apply Interest");
        System.out.println("5. Exit");

        int options;

        do {
            System.out.println("Enter an Option #1-5: ");
            options = userInput.nextInt();
        } while(options < 1 || options > 5);
        return options;
    }
}
