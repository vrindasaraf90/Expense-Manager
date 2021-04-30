package com.streamliners;

import com.streamliners.menu.Operations;
import com.streamliners.model.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List for all the transactions
        ArrayList<Transaction> transactions = new ArrayList<>();

        String menu = "\nPlease choose: " +
                "\n0: Exit" +
                "\n1: New Transaction" +
                "\n2: Edit Transaction" +
                "\n3: Remove Transaction" +
                "\n4: See All Transactions" +
                "\nYour choice: ";

        // Loop until the user exit the application
        while (true) {
            System.out.print(menu);

            // Options chosen in the driven menu
            int chooseOption = scanner.nextInt();

            switch (chooseOption) {
                case 0:
                    System.out.println("You closed the application.");
                    return;
                case 1:
                    System.out.println("You select to add new transaction.");
                    Transaction transaction = Operations.newTransaction();

                    // Making sure that the transaction is not null
                    if (transaction != null) {
                        transactions.add(transaction);
                        System.out.println("DONE! Addition successful.\n");
                    }
                    break;

                case 2:
                    System.out.println("You select to edit a transaction.");
                    ArrayList<Transaction> transaction1 = Operations.getTransaction(transactions);

                    // Making sure that the transaction is not null
                    if (transaction1 != null) {
                        Operations.editTransaction(transaction1);
                        System.out.println("DONE! Editing successful.\n");
                    }
                    break;

                case 3:
                    System.out.println("You select to remove transaction.");
                    ArrayList<Transaction> transaction2 = Operations.getTransaction(transactions);

                    // Making sure that the transaction is not null
                    if (transaction2 != null) {
                        transactions.remove(transaction2);
                        System.out.println("DONE! Removed successfully.\n");
                    }
                    break;
                case 4:
                    System.out.println("You select to see all transactions.");
                    Operations.allTransactions(transactions);
                    break;

                default:
                    System.out.println("Incorrect option.\n");
            }
        }
    }
}
