package edu.unisabana.proyecto.application.usecase;

import edu.unisabana.proyecto.application.port.out.RegistryRepositoryPort;
import edu.unisabana.proyecto.domain.model.Person;
import edu.unisabana.proyecto.domain.model.RegisterResult;

public class Registry {

    public static final int MIN_AGE = 18;

    private final RegistryRepositoryPort repo;

    public Registry(RegistryRepositoryPort repo) {
        this.repo = repo;
    }

    public RegisterResult registerVoter(Person p) {
        if (p == null) return RegisterResult.INVALID;
        if (p.getId() <= 0) return RegisterResult.INVALID;
        if (!p.isAlive()) return RegisterResult.DEAD;
        if (p.getAge() < MIN_AGE) return RegisterResult.UNDERAGE;

        try {
            if (repo.existsById(p.getId())) return RegisterResult.DUPLICATED;
            repo.save(p.getId(), p.getName(), p.getAge(), p.isAlive());
            return RegisterResult.VALID;
        } catch (Exception e) {
            throw new IllegalStateException("Persistencia: " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
        }
    }
}
