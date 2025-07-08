package BankingSystem;

import java.util.HashMap;

public class Bank {
    private HashMap<String, User> users;
    private User currentuser;

    public Bank() {
        users = new HashMap<>();
        currentuser = null;
    }

    public boolean signUp(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password));
        return true;
    }

    public boolean login(String username, String password) {
        if (!users.containsKey(username)) {
            return false; // username not found
        }

        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            currentuser = user;
            return true;
        }
        return false; // password mismatch
    }


    public void deposit(double amount) {
        if (currentuser != null) {
            currentuser.deposit(amount);
        }
    }

    public void withdraw(double amount) {
        if (currentuser != null) {
            currentuser.withdraw(amount);
        }
    }

    public double checkBalance() {
        return currentuser != null ? currentuser.getBalance() : 0.0;
    }

    public void logout() {
        currentuser = null;
    }

    public void showTransactions() {
        if (currentuser != null) {
            for (Transaction t : currentuser.getTransactions()) {
                System.out.println(t);
            }
        }
    }
}
