package com.Donis.apirest.Person;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes de Angular app
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    // Endpoint para crear una nueva persona
    @PostMapping
    public void createPersona(@RequestBody Person person) {
        personService.createPersona(person);
    }

    // Endpoint para obtener una persona por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonaById(@PathVariable Integer id) {
        Person person = personService.getPersonaById(id);
        return ResponseEntity.ok(person);
    }

    // Endpoint para obtener todas las personas
    @GetMapping
    public ResponseEntity<List<Person>> getAllPersonas() {
        List<Person> persons = personService.getAllPersonas();
        return ResponseEntity.ok(persons);
    }

    // Endpoint para actualizar los datos de una persona
    @PutMapping
    public ResponseEntity<Person> updatePersona(@RequestBody Person updatedPerson) {
        // Verifica si el ID de la persona a actualizar no es nulo
        if (updatedPerson.getId() == null) {
            return ResponseEntity.badRequest().build(); // O manejar según corresponda
        }
        // Actualiza los datos de la persona y obtén la persona actualizada
        personService.updatePersona(updatedPerson);
        Person updated = personService.getPersonaById(updatedPerson.getId());
        return ResponseEntity.ok(updated);
    }

    // Endpoint para eliminar una persona por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        personService.deletePersona(id);
        return ResponseEntity.ok().build(); // Consider using ResponseEntity.noContent() for delete operations
    }
}
