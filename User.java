
package BankingSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    private String username;
    private String passwordHash;
    private Double balance;
    private ArrayList<Transaction> transactions;

    public User(String username, String password) {
        this.username = username.toLowerCase();
        this.passwordHash = hashPassword(password);
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPassword(String password) {
        return this.passwordHash.equals(hashPassword(password));
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: ₹" + balance);
        transactions.add(new Transaction(amount, "deposit"));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount.");
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println(" Withdraw successful. New balance: ₹" + balance);
            transactions.add(new Transaction(amount, "withdraw"));
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String newPassword) {
        this.passwordHash = hashPassword(newPassword);
        System.out.println("Password changed successfully.");
    }
}
