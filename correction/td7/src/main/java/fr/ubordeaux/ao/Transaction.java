package fr.ubordeaux.ao;

import java.util.Date;
import java.util.UUID;
import java.util.Objects;

public class Transaction {
    private UUID id;
    private Date date;
    private String title;
    private int amount;

    public Transaction(String title, int amount) {
        if (amount == 0) throw new IllegalArgumentException("amount must be positive!");

        this.id = UUID.randomUUID();
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

    @Override
    public boolean equals(Object other) {
        if (other instanceof Transaction) {
            Transaction otherTransaction = (Transaction) other;
            return this.id.equals(otherTransaction.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Transaction "+this.title+" (id="+this.id+"), mount = "+this.amount+ ", date="+this.date.toString();
    }
}