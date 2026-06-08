package edu.unisabana.proyecto.application.port.out;

import edu.unisabana.proyecto.infrastructure.persistence.RegistryRecord;
import java.util.Optional;

public interface RegistryRepositoryPort {
    void initSchema() throws Exception;
    boolean existsById(int id) throws Exception;
    void save(int id, String name, int age, boolean isAlive) throws Exception;
    Optional<RegistryRecord> findById(int id) throws Exception;
    void deleteAll() throws Exception;
}
