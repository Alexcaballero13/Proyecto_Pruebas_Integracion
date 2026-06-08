package edu.unisabana.proyecto.delivery.rest;

import edu.unisabana.proyecto.application.usecase.Registry;
import edu.unisabana.proyecto.domain.model.Gender;
import edu.unisabana.proyecto.domain.model.Person;
import edu.unisabana.proyecto.domain.model.RegisterResult;
import edu.unisabana.proyecto.domain.model.rq.PersonDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistryController {

    private final Registry registry;

    public RegistryController(Registry registry) {
        this.registry = registry;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String register(@RequestBody PersonDTO dto) {
        Gender gender;
        try {
            gender = Gender.valueOf(dto.getGender());
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new IllegalArgumentException("Género inválido: " + dto.getGender());
        }
        Person p = new Person(dto.getName(), dto.getId(), dto.getAge(), gender, dto.isAlive());
        return registry.registerVoter(p).name();
    }
}
