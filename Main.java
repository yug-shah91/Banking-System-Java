package BankingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n=== Welcome to Banking System ===");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    boolean success = bank.signUp(username, password);
                    if (success) System.out.println("Account created!");
                    else System.out.println("Username already exists.");
                }

                case 2 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (bank.login(username, password)) {
                        System.out.println("Login successful!");

                        while (true) {
                            System.out.println("\n1. Deposit\n2. Withdraw\n3. Balance\n4. Transactions\n5. Logout");
                            int opt = scanner.nextInt();

                            switch (opt) {
                                case 1 -> {
                                    System.out.print("Enter deposit amount: ");
                                    double amt = scanner.nextDouble();
                                    bank.deposit(amt);
                                }
                                case 2 -> {
                                    System.out.print("Enter withdraw amount: ");
                                    double amt = scanner.nextDouble();
                                    bank.withdraw(amt);
                                }
                                case 3 -> System.out.println("Balance: ₹" + bank.checkBalance());
                                case 4 -> bank.showTransactions();
                                case 5 -> {
                                    bank.logout();
                                    System.out.println("Logged out.");
                                    break;
                                }
                                default -> System.out.println("Invalid choice.");
                            }

                            if (opt == 5) break;
                        }

                    } else {
                        System.out.println("Invalid credentials.");
                    }
                }

                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
