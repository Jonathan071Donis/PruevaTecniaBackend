package com.Donis.apirest.Person;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;

    // Método para crear una nueva persona en la base de datos
    public void createPersona(Person person) {
        personRepo.save(person);
    }

    // Método para actualizar los datos de una persona existente en la base de datos
    public void updatePersona(Person updatedPerson) {
        // Verifica si el ID de la persona a actualizar es nulo
        if (updatedPerson.getId() == null) {
            throw new IllegalArgumentException("El ID es necesario para actualizar la persona");
        }
        // Busca la persona existente en la base de datos por su ID
        Person existingPerson = personRepo.findById(updatedPerson.getId())
                                           .orElseThrow(() -> new IllegalArgumentException("Persona no encontrada con ID: " + updatedPerson.getId()));
        // Actualiza los campos de la persona existente con los nuevos valores
        existingPerson.setFirstName(updatedPerson.getFirstName());
        existingPerson.setLastName(updatedPerson.getLastName());
        existingPerson.setEmail(updatedPerson.getEmail());
        // Guarda los cambios en la base de datos
        personRepo.save(existingPerson);
    }

    // Método para eliminar una persona de la base de datos por su ID
    public void deletePersona(Integer id) {
        personRepo.deleteById(id);
    }

    // Método para recuperar una persona de la base de datos por su ID
    public Person getPersonaById(Integer id) {
        return personRepo.findById(id)
                         .orElseThrow(() -> new IllegalArgumentException("Persona no encontrada con ID: " + id));
    }

    // Método para recuperar todas las personas de la base de datos
    public List<Person> getAllPersonas() {
        return personRepo.findAll();
    }
}
