package com.example.springpractice.exceptions;

/**
 * En esta clase defino una excepcion controlada para indicar
 * que no se ha encontrado una persona.
 */
public class PersonNotFoundException extends RuntimeException {

    /**
     * En este constructor recibo el mensaje del error.
     *
     * @param message mensaje descriptivo
     */
    public PersonNotFoundException(String message) {
        super(message);
    }
}
