package fr.ubordeaux.ao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestAccount {

    @Test
    public void testAccount() {
        Date date = new Date();
        Account account = Account.createAccount("AO Account");

        Transaction t1 = new Transaction("salary",10000);
        Transaction t2 = new Transaction("food",-1000);
        Transaction t3 = new Transaction("book",-20000);
        Transaction t4 = new Transaction("book",-20000);

        account.addTransaction(t1);
        account.addTransaction(t2);
        account.addTransaction(t3);
        account.addTransaction(t4);


        Transaction t5 = new Transaction("book",-20000);
        account.removeTransaction(t5);

        assertEquals(4, account.getTransactionSince(date).size());
        int expectedBalance = 10000 - 1000 - 20000;
        assertEquals(expectedBalance, account.getBalance(),0);

    }

}