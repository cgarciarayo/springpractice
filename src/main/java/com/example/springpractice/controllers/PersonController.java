package com.example.springpractice.controllers;

import com.example.springpractice.beans.Person;
import com.example.springpractice.beans.Persons;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * En este controlador expongo los endpoints REST de los ejercicios.
 * Aqui mantengo los ejercicios anteriores y ademas gestiono una lista
 * de personas para buscar y actualizar por DNI.
 */
@RestController
public class PersonController {

    private Person storedPerson;
    private Persons persons;

    /**
     * En este constructor cargo en memoria 10 personas ficticias.
     */
    public PersonController() {
        persons = new Persons();

        persons.getPersonList().add(new Person("53483476L", "Ana", "Lopez", "Garcia", "1990-01-10", "Female"));
        persons.getPersonList().add(new Person("76387538B", "Luis", "Perez", "Martin", "1988-03-22", "Male"));
        persons.getPersonList().add(new Person("73813576F", "Marta", "Sanchez", "Ruiz", "1995-07-14", "Female"));
        persons.getPersonList().add(new Person("35174316S", "Carlos", "Fernandez", "Diaz", "1992-11-05", "Male"));
        persons.getPersonList().add(new Person("31747367E", "Elena", "Romero", "Gil", "1991-09-18", "Female"));
        persons.getPersonList().add(new Person("87426766T", "Javier", "Navarro", "Torres", "1987-02-27", "Male"));
        persons.getPersonList().add(new Person("98765466J", "Laura", "Ortega", "Moreno", "1996-06-30", "Female"));
        persons.getPersonList().add(new Person("87364659L", "David", "Castro", "Vega", "1993-04-12", "Male"));
        persons.getPersonList().add(new Person("78145637H", "Sara", "Molina", "Herrera", "1994-08-08", "Female"));
        persons.getPersonList().add(new Person("12312312E", "Carmen", "Garcia", "Rayo", "1991-01-26", "Female"));
    }

    /**
     * En este metodo devuelvo una persona de ejemplo en formato JSON.
     */
    @GetMapping("/person")
    public Person getPerson() {
        return new Person(
                "Carmen",
                "Garcia",
                "Rayo",
                "1991-01-26",
                "Female"
        );
    }

    /**
     * En este metodo recibo los datos enviados por URL mediante un POST,
     * creo un objeto Person, lo guardo en memoria y lo muestro por consola.
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

    /**
     * En este metodo busco una persona por DNI y la devuelvo.
     */
    @GetMapping("/personByDni")
    public Person getPersonByDni(@RequestParam("dni") String dni) {

        for (Person person : persons.getPersonList()) {
            if (person.getDni().equalsIgnoreCase(dni)) {
                return person;
            }
        }

        return null;
    }

    /**
     * En este metodo actualizo los datos de una persona localizada por DNI.
     * Recibo los nuevos datos en el cuerpo de la peticion con RequestBody.
     */
    @PutMapping("/personByDni")
    public Person updatePersonByDni(
            @RequestParam("dni") String dni,
            @RequestBody Person updatedPerson
    ) {

        for (int i = 0; i < persons.getPersonList().size(); i++) {
            if (persons.getPersonList().get(i).getDni().equalsIgnoreCase(dni)) {
                updatedPerson.setDni(dni);
                persons.getPersonList().set(i, updatedPerson);
                return updatedPerson;
            }
        }

        return null;
    }
}