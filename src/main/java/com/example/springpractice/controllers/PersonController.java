package com.example.springpractice.controllers;

import com.example.springpractice.beans.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * En este controlador expongo un endpoint REST
 * que devuelve los datos de una persona en formato JSON.
 */
@RestController
public class PersonController {

    /**
     * En este método creo un objeto Person con los datos indicados
     * y lo devuelvo. Spring Boot lo convierte automáticamente a JSON.
     */
    @GetMapping("/person")
    public Person getPerson() {

        Person person = new Person(
                "Carmen",
                "Garcia",
                "Rayo",
                "1991-01-26",
                "Female"
        );

        return person;
    }
}