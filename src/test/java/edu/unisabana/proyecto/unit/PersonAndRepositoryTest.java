package edu.unisabana.proyecto.unit;

import edu.unisabana.proyecto.domain.model.Gender;
import edu.unisabana.proyecto.domain.model.Person;
import edu.unisabana.proyecto.infrastructure.persistence.RegistryRecord;
import edu.unisabana.proyecto.infrastructure.persistence.RegistryRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonAndRepositoryTest {

    private RegistryRepository repo;

    @Before
    public void setup() throws Exception {
        repo = new RegistryRepository("jdbc:h2:mem:unittest;DB_CLOSE_DELAY=-1");
        repo.initSchema();
        repo.deleteAll();
    }

    @Test
    public void shouldExposePersonFields() {
        Person p = new Person("Ana", 1, 25, Gender.FEMALE, true);
        assertEquals("Ana", p.getName());
        assertEquals(Gender.FEMALE, p.getGender());
    }

    @Test
    public void shouldFindSavedRecord() throws Exception {
        repo.save(3, "Luis", 40, true);
        RegistryRecord record = repo.findById(3).orElseThrow();
        assertEquals("Luis", record.getName());
        assertTrue(record.isAlive());
    }
}
