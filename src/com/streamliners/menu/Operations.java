package com.streamliners.menu;

import com.streamliners.model.Transaction;

import java.util.ArrayList;
import java.util.Scanner;


public class Operations {

    private static Scanner scanner = new Scanner(System.in);

    public static Transaction newTransaction() {

        //to initialise transaction
        Transaction transaction = null;

        // Printing the menu
        String menu = "Please choose from the given options:" +
                "\n0: Go Back" +
                "\n1: Expense" +
                "\n2: Income";

        while (true) {
            System.out.print(menu);
            int chooseOption = scanner.nextInt();

            switch (chooseOption) {
                case 0:
                    return transaction;
                case 1:
                    transaction = newExpenseTransaction();
                    return transaction;
                case 2:
                    transaction = newIncomeTransaction();
                    return transaction;
                default:
                    System.out.println("Incorrect Option");
            }
        }
    }

    //new income transaction
    public static Transaction newIncomeTransaction() {
        System.out.print("Enter amount of transaction: ");
        float amt = scanner.nextFloat();

        System.out.print("Enter date of transaction (dd-mm-yy): ");
        String date = scanner.nextLine();

        System.out.print("\nEnter description of transaction: ");
        String description = scanner.nextLine();

        //A transaction with the input
        Transaction transaction = new Transaction(date, description, amt, Transaction.TYPE_INCOME);

        return transaction;
    }

    //new expense transaction
    public static Transaction newExpenseTransaction() {
        System.out.print("Enter amount of transaction: ");
        float amt = scanner.nextFloat();

        System.out.print("Enter date of transaction (dd-mm-yy): ");
        String date = scanner.next();

        System.out.println("");

        System.out.print("Enter description of transaction: ");
        String description = scanner.next();

        //A transaction with the input
        Transaction transaction = new Transaction(date, description, amt, Transaction.TYPE_EXPENSE);

        return transaction;
    }

    //edit a transaction
    public static void editTransaction(Transaction transaction) {
        // Taking new details for the transaction
        System.out.print("Enter new amount of transaction: ");
        float newAmount = scanner.nextFloat();

        System.out.print("Enter new date of transaction: ");
        String newDate = scanner.nextLine();

        // Making sure that the user must enter something
        while (newDate.isEmpty()) newDate = scanner.nextLine();


        System.out.print("Enter new description of transaction: ");
        String newDescription = scanner.nextLine();

        Scanner scanner = new Scanner(System.in);
        String menu = "Please choose from new type: " +
                "\n1: Income" +
                "\n2: Expense" +
                "\n" +
                "\nYour response: ";
        int chooseOption = 0;

        // Return the loop when user select 1 or 2 option
        while (!(chooseOption == 1 || chooseOption == 2)) {
            // Printing menu
            System.out.print(menu);
            chooseOption = scanner.nextInt();

            // taking the type for the transaction and updating the transaction
            switch (chooseOption) {
                case 1:
                    transaction.setType(Transaction.TYPE_INCOME);
                    transaction.setAmt(newAmount);
                    break;
                case 2:
                    transaction.setType(Transaction.TYPE_EXPENSE);
                    transaction.setAmt(-newAmount);
                    break;
                default:
                    System.out.println("ERROR! Incorrect option.\n");
            }
        }

        //transaction.setDate(newDate);
        // transaction.setDescription(newDescription);
    }

    //to see all transaction
    public static void allTransactions(ArrayList<Transaction> transactions) {
        // Making sure that the list contains at least one transaction
        if (transactions.isEmpty()) {
            System.out.println("ERROR! No transactions available.\n");
            return;
        }

        // Declaring fields
        float totalExpenses = 0, totalIncomes = 0;
        int noOfTransactions = 0, index = 1;

        // Calling function to print the whole list of transactions
        listingTransactions(transactions, index);

        // Traversing the list for the totals
        for (Transaction transaction : transactions) {
            // Checking type of transaction
            if (transaction.getType() == Transaction.TYPE_EXPENSE) totalExpenses += transaction.getAmt();
            else totalIncomes += transaction.getAmt();
            noOfTransactions++;
        }


    }

    public static Transaction getTransaction(ArrayList<Transaction> transactions) {
        // Making sure that the list contains at least one transaction
        if (transactions.isEmpty()) {
            System.out.println("ERROR! No transactions available.\n");
            return null;
        }

        Scanner scanner = new Scanner(System.in);

        int index = 1;
        while (true) {
            System.out.print("\nSelect Transaction: " +
                    "\n0: Go Back");

            // Calling function to list all the transaction in the given list
            listingTransactions(transactions, index);

            // Taking response from the user
            System.out.print("\n\nYour response: ");
            index = scanner.nextInt();

            if (index == 0) return null;

            try {
                // Return the transaction by using its index in the actual list
                return transactions.get(index - 1);
            } catch (Exception e) {
                // Error handling if the user choose wrong option
                System.out.println("ERROR! Incorrect option.\n");
            }
        }
    }

    private static void listingTransactions(ArrayList<Transaction> transactions, int index) {

    }
}