package com.Donis.apirest.Person;

import jakarta.persistence.Entity; // Importación de la anotación Entity de JPA
import jakarta.persistence.GeneratedValue; // Importación de la anotación GeneratedValue de JPA
import jakarta.persistence.GenerationType; // Importación de la enumeración GenerationType de JPA
import jakarta.persistence.Id; // Importación de la anotación Id de JPA
import lombok.AllArgsConstructor; // Importación de la anotación AllArgsConstructor de Lombok
import lombok.Data; // Importación de la anotación Data de Lombok
import lombok.NoArgsConstructor; // Importación de la anotación NoArgsConstructor de Lombok

@Data // Anotación de Lombok para generar automáticamente métodos toString(), equals(), hashCode(), getter y setter
@AllArgsConstructor // Anotación de Lombok para generar un constructor con todos los argumentos
@NoArgsConstructor // Anotación de Lombok para generar un constructor sin argumentos
@Entity // Anotación que especifica que la clase es una entidad JPA
public class Person {
    @Id // Anotación que especifica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotación para generar automáticamente valores para la clave primaria
    private Integer id; // Campo que representa la clave primaria de la entidad
    
    private String firstName; // Campo para el nombre de la persona
    private String lastName; // Campo para el apellido de la persona
    private String email; // Campo para el correo electrónico de la persona
}
