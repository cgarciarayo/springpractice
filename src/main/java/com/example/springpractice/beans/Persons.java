package com.example.springpractice.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * En esta clase defino un contenedor de personas.
 * Aqui guardo una lista de objetos Person.
 */
public class Persons {

    private List<Person> personList;

    /**
     * En este constructor inicializo la lista vacia.
     */
    public Persons() {
        this.personList = new ArrayList<>();
    }

    /**
     * Devuelvo la lista de personas.
     */
    public List<Person> getPersonList() {
        return personList;
    }

    /**
     * Modifico la lista de personas.
     */
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}