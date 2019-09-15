package fr.ubordeaux.ao;

import static org.junit.Assert.*;

import fr.ubordeaux.ao.Shape;

import org.junit.Before;
import org.junit.Test;

public class TestTransformer {
    @Test
    public void testTransformer() {

        Transformer t = new Transformer();
        t.transform(new Shape());

        Transformer t2 = new RectangleTransformer();
        t2.transform(new Shape());

        

    }

}