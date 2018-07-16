package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ReferenceRepositoryImpl;

public class ReferenceRepositoryTest {
    ReferenceRepository repository;

    @Before
    public void createRepository() {
        repository = new ReferenceRepositoryImpl();
    }

    @Test
    public void testAddReferenceInTheRepository() {
        ReferenceId id = new ReferenceId();
        String name = "First Test Reference";
        String description = "This is the first ever created reference";
        repository.addReference(id, name, description);
        assertEquals(1, repository.size());
        Reference ref = repository.findReferenceById(id);
        assertEquals("name of reference is ok", name, ref.getName());
    }

}