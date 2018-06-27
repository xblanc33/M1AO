package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReferenceTest {

    @Test
    public void testReferenceCreation() {
        ReferenceId id = new ReferenceId();
        String name = "First Test Reference";
        String description = "This is the first ever created reference";
        Reference ref = new Reference(id, name, description );
        assertEquals(ref.getDescription(),description);
    }

}