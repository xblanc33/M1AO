package fr.ubordeaux.ao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTowns {
    private final int MAX = 36700;

    @Test
    public void addAllTowns() {
        Towns towns = new Towns();
        TownFactory tf = new TownFactory();
        for (int i=0 ; i<MAX; i++) {
            towns.addTown(tf.getNextTown());
        }
        //Curiously there are 2 duplicates in the file
        assertEquals(MAX-2, towns.size());

    }

}