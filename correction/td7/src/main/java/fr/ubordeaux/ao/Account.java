package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;
import java.util.Set;
import java.util.Date;

public class Account {
    private double balance;
    private String id;
    private String name;
    private Set<Transaction> transactions;

    private Account(String id, String name) {
        this.balance = 0;
        transactions = new HashSet<Transaction>();
    }

    public static Account createAccount(String name) {
        return new Account(UUID.randomUUID().toString(),name);
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        balance = balance + transaction.getAmount();
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        balance = balance - transaction.getAmount();
    }
    
    public Set<Transaction> getTransactionSince(Date date) {
        Set<Transaction> copy = new HashSet<Transaction>();
        for (Transaction transaction : transactions) {
            if (date.before(transaction.getDate())) copy.add(transaction);
        }
        return copy;
    }


    @Override
    public boolean equals(Object other) {
        if (other instanceof Account) {
            Account otherAccount = (Account) other;
            return this.id.compareTo(otherAccount.id) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Account "+this.name+" (id="+this.id+"), balance = "+this.balance;
    }
    
}