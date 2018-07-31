package fr.ubordeaux.ao;

import java.util.Date;

public class Transaction {
    private Date date;
    private String title;
    private int amount;

    public Transaction(String title, int amount) {
        if (amount == 0) throw new IllegalArgumentException("amount must be positive!");

        this.date = new Date();
        this.title = title;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }
}