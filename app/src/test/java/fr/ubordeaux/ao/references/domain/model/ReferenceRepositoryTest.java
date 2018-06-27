package fr.ubordeaux.ao.references.domain.model;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.references.infrastructure.persistence.InMemoryReferenceRepository;

public class ReferenceRepositoryTest {
    ReferenceRepository repository;

    @Before
    public void createRepository() {
        repository = new InMemoryReferenceRepository();
    }

    @Test
    public void testAddReferenceInTheRepository() {
        ReferenceId id = new ReferenceId();
        String name = "First Test Reference";
        String description = "This is the first ever created reference";
        repository.addReference(id, name, description);
        assertEquals(1, repository.size());
        Optional<Reference> maybeReference = repository.findReferenceById(id);
        Reference ref = maybeReference.get();
        assertEquals("name of reference is ok", name, ref.getName());
    }

}