package fr.ubordeaux.ao.domain.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.Price;

public class ReferenceTest {

    @Test(expected=IllegalArgumentException.class)
    public void shouldTestValuesTypes() {
        Reference ref = new Reference("id1", "chair", "Cheap wooden chair", new Price(-10));
    }
}
