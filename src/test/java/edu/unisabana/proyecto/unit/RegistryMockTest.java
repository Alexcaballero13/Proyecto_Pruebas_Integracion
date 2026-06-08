package edu.unisabana.proyecto.unit;

import edu.unisabana.proyecto.application.port.out.RegistryRepositoryPort;
import edu.unisabana.proyecto.application.usecase.Registry;
import edu.unisabana.proyecto.domain.model.Gender;
import edu.unisabana.proyecto.domain.model.Person;
import edu.unisabana.proyecto.domain.model.RegisterResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RegistryMockTest {

    private RegistryRepositoryPort repo;
    private Registry registry;

    @Before
    public void setUp() {
        repo = mock(RegistryRepositoryPort.class);
        registry = new Registry(repo);
    }

    @Test
    public void shouldReturnDuplicatedWhenRepoSaysExists() throws Exception {
        when(repo.existsById(7)).thenReturn(true);
        RegisterResult result = registry.registerVoter(new Person("Ana", 7, 25, Gender.FEMALE, true));
        assertEquals(RegisterResult.DUPLICATED, result);
        verify(repo, never()).save(anyInt(), anyString(), anyInt(), anyBoolean());
    }

    @Test
    public void shouldInvokeSaveWhenPersonIsValid() throws Exception {
        when(repo.existsById(10)).thenReturn(false);
        RegisterResult result = registry.registerVoter(new Person("Carlos", 10, 25, Gender.MALE, true));
        assertEquals(RegisterResult.VALID, result);
        verify(repo).save(10, "Carlos", 25, true);
    }

    @Test
    public void shouldPropagatePersistenceErrorWhenSaveFails() throws Exception {
        when(repo.existsById(11)).thenReturn(false);
        doThrow(new java.sql.SQLException("Connection refused")).when(repo)
                .save(anyInt(), anyString(), anyInt(), anyBoolean());
        try {
            registry.registerVoter(new Person("Maria", 11, 30, Gender.FEMALE, true));
            fail("Se esperaba IllegalStateException");
        } catch (IllegalStateException ex) {
            assertTrue(ex.getMessage().contains("Persistencia"));
        }
    }
}
