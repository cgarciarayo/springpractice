package com.example.springpractice.beans;

/**
 * En esta clase defino el bean Person.
 * Aquí guardo los datos de una persona que después devolveré en el servicio REST.
 */
public class Person {

    private String name;
    private String firstSurname;
    private String secondSurname;
    private String fullName;
    private String birthDate;
    private String sex;

    /**
     * En este constructor recibo los datos de la persona
     * y construyo automáticamente el nombre completo.
     */
    public Person(String name, String firstSurname, String secondSurname, String birthDate, String sex) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.fullName = name + " " + firstSurname + " " + secondSurname;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    /**
     * Devuelvo el nombre de la persona.
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelvo el primer apellido.
     */
    public String getFirstSurname() {
        return firstSurname;
    }

    /**
     * Devuelvo el segundo apellido.
     */
    public String getSecondSurname() {
        return secondSurname;
    }

    /**
     * Devuelvo el nombre completo.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Devuelvo la fecha de nacimiento.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Devuelvo el sexo de la persona.
     */
    public String getSex() {
        return sex;
    }
}