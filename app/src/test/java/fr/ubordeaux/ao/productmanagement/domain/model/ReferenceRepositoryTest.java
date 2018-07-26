package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.jdbc.ReferenceRepositoryImpl;

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
        Reference reference = new Reference(id, name, description);
        System.out.println("test add reference");
        repository.addReference(reference);
        assertEquals(1, repository.size());
        Reference ref = repository.findReferenceById(id);
        assertEquals("name of reference is ok", name, ref.getName());
    }

}