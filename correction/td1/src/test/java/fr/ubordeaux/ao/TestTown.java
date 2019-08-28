package fr.ubordeaux.ao;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTown {

    @Test
    public void testEgality() {

        Town t1 = new Town("Talence", 33400);
        Town t2 = new Town("Talence", 33400);

        Assert.assertFalse(t1 == t2);
        Assert.assertTrue(t1.equals(t2));

    }

}