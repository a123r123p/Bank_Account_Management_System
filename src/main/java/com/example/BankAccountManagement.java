package com.example;

import java.util.Scanner;

public class BankAccountManagement {
    private static final int MAX_ACCOUNTS = 100;
    private static BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];
    private static int accountCount = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n====== Bank Account Management System ======");
            System.out.println("1. Create New Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Search Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    searchAccount();
                    break;
                case 6:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    private static void createAccount() {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Cannot create more accounts! Limit reached.");
            return;
        }
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial balance: ₹");
        double balance = sc.nextDouble();

        accounts[accountCount++] = new BankAccount(accNum, name, balance);
        System.out.println("Account created successfully!");
    }

    private static void viewAllAccounts() {
        if (accountCount == 0) {
            System.out.println("No accounts found!");
            return;
        }
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccountInfo();
        }
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        BankAccount account = findAccount(accNum);
        if (account != null) {
            System.out.print("Enter deposit amount: ₹");
            double amount = sc.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        BankAccount account = findAccount(accNum);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ₹");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void searchAccount() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        BankAccount account = findAccount(accNum);
        if (account != null) {
            account.displayAccountInfo();
        } else {
            System.out.println("Account not found!");
        }
    }

    private static BankAccount findAccount(int accNum) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNum) {
                return accounts[i];
            }
        }
        return null;
    }
}
