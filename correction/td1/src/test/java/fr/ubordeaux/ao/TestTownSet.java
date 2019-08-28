package fr.ubordeaux.ao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTownSet {
    private final int MAX = 36700;

    @Test
    public void addAllTown() {
        TownSet townSet = new TownSet();
        TownFactory tf = new TownFactory();
        for (int i=0 ; i<MAX; i++) {
            townSet.addTown(tf.getNextTown());
        }
        //Curiously there are 2 duplicates in the file
        assertEquals(MAX-2, townSet.size());

    }

}