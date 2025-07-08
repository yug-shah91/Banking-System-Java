package BankingSystem;

import java.time.LocalDateTime;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime date;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return type + " of ₹" + amount + " on " + date;
    }
}
