package com.example.springpractice.controllers;

import com.example.springpractice.beans.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * En este controlador expongo los endpoints REST de los ejercicios.
 * Aqui devuelvo una persona en formato JSON y tambien recibo datos
 * enviados desde el navegador para almacenarlos en memoria.
 */
@RestController
public class PersonController {

    /**
     * En este atributo guardo en memoria la ultima persona recibida
     * desde el endpoint POST.
     */
    private Person storedPerson;

    /**
     * En este metodo devuelvo una persona de ejemplo en formato JSON.
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

    /**
     * En este metodo recibo los datos enviados por URL mediante un POST,
     * creo un objeto Person, lo guardo en memoria y lo muestro por consola
     * de forma estructurada.
     */
    @PostMapping("/envioFormulario")
    public Person sendForm(
            @RequestParam("nombre") String name,
            @RequestParam("apellido1") String firstSurname,
            @RequestParam("apellido2") String secondSurname,
            @RequestParam("fechaNacimiento") String birthDate,
            @RequestParam("sexo") String sex
    ) {

        storedPerson = new Person(name, firstSurname, secondSurname, birthDate, sex);

        System.out.println("----- PERSON RECEIVED -----");
        System.out.println("Name: " + storedPerson.getName());
        System.out.println("First surname: " + storedPerson.getFirstSurname());
        System.out.println("Second surname: " + storedPerson.getSecondSurname());
        System.out.println("Birth date: " + storedPerson.getBirthDate());
        System.out.println("Sex: " + storedPerson.getSex());
        System.out.println("Full name: " + storedPerson.getFullName());
        System.out.println("---------------------------");

        return storedPerson;
    }
}