package com.Donis.apirest.Person;

import org.springframework.data.jpa.repository.JpaRepository; // Importación de la interfaz JpaRepository de Spring Data JPA
import org.springframework.stereotype.Repository; // Importación de la anotación Repository de Spring

@Repository // Anotación que marca la interfaz como un componente de repositorio
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Esta interfaz hereda métodos para operaciones CRUD sobre la entidad Person
}
