package fr.ubordeaux.ao;

import static org.junit.Assert.*;

import fr.ubordeaux.ao.Shape;

import org.junit.Before;
import org.junit.Test;

public class TestShape {
    @Test
    public void testShape() {

        Rectangle s1 = new Rectangle(new Point(0,0), new Point(1,0), new Point(1,4), new Point(0,4));
        //int width = s1.getWidth();
        //assertEquals(1, width);
        //s1.transform().getWidth();
        //Shape s2 = s1.move(new Point(0,0), new Point(1,1));
        Rectangle s2 = s1.move(new Point(0,0), new Point(1,1));
        s2.getWidth();

    }

}