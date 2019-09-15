package fr.ubordeaux.ao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPoint {
    @Test
    public void testPoint() {

        Point p1 = new Point(1, 1);
        assertEquals(1, p1.getX());

    }

}