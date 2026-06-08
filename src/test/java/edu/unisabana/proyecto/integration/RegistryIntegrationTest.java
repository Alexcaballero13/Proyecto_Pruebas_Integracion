package edu.unisabana.proyecto.integration;

import edu.unisabana.proyecto.application.port.out.RegistryRepositoryPort;
import edu.unisabana.proyecto.application.usecase.Registry;
import edu.unisabana.proyecto.domain.model.Gender;
import edu.unisabana.proyecto.domain.model.Person;
import edu.unisabana.proyecto.domain.model.RegisterResult;
import edu.unisabana.proyecto.infrastructure.persistence.RegistryRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistryIntegrationTest {

    private RegistryRepositoryPort repo;
    private Registry registry;

    @Before
    public void setup() throws Exception {
        repo = new RegistryRepository("jdbc:h2:mem:proyectodb;DB_CLOSE_DELAY=-1");
        repo.initSchema();
        repo.deleteAll();
        registry = new Registry(repo);
    }

    @Test
    public void shouldRegisterValidPersonInH2() throws Exception {
        Person p = new Person("Ana", 100, 30, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(p);
        assertEquals(RegisterResult.VALID, result);
        assertTrue(repo.existsById(100));
    }

    @Test
    public void shouldReturnDuplicatedWhenIdExists() throws Exception {
        registry.registerVoter(new Person("Ana", 101, 30, Gender.FEMALE, true));
        RegisterResult result = registry.registerVoter(new Person("Otra", 101, 40, Gender.FEMALE, true));
        assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void shouldReturnUnderageAndNotPersist() throws Exception {
        RegisterResult result = registry.registerVoter(new Person("Niño", 102, 16, Gender.MALE, true));
        assertEquals(RegisterResult.UNDERAGE, result);
        assertFalse(repo.existsById(102));
    }

    @Test
    public void shouldReturnDeadAndNotPersist() throws Exception {
        RegisterResult result = registry.registerVoter(new Person("Luis", 103, 50, Gender.MALE, false));
        assertEquals(RegisterResult.DEAD, result);
        assertFalse(repo.existsById(103));
    }
}
