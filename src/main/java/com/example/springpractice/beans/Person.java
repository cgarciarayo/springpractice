package com.example.springpractice.beans;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * En esta clase defino el bean Person.
 * Aqui guardo los datos de una persona y genero automaticamente
 * el nombre completo cuando se crean o modifican sus datos.
 */
public class Person {

    /**
     * DNI de la persona.
     */
    @NotNull(message = "El DNI no puede ser nulo")
    @Size(min = 9, max = 9, message = "El DNI debe tener 9 caracteres")
    private String dni;

    /**
     * Nombre de la persona.
     */
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 2, max = 30, message = "El nombre debe tener entre 2 y 30 caracteres")
    private String name;

    /**
     * Primer apellido.
     */
    @NotNull(message = "El primer apellido es obligatorio")
    private String firstSurname;

    /**
     * Segundo apellido.
     */
    @NotNull(message = "El segundo apellido es obligatorio")
    private String secondSurname;

    /**
     * Fecha de nacimiento.
     */
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private String birthDate;

    /**
     * Sexo de la persona.
     */
    @NotNull(message = "El sexo es obligatorio")
    private String sex;

    /**
     * Nombre completo de la persona.
     */
    private String fullName;

    /**
     * Constructor vacio necesario para que Spring pueda crear el objeto.
     */
    public Person() {
    }

    /**
     * En este constructor recibo los datos sin DNI.
     */
    public Person(String name, String firstSurname, String secondSurname, String birthDate, String sex) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.sex = sex;
        this.fullName = name + " " + firstSurname + " " + secondSurname;
    }

    /**
     * En este constructor recibo todos los datos incluyendo el DNI.
     */
    public Person(String dni, String name, String firstSurname, String secondSurname, String birthDate, String sex) {
        this.dni = dni;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.sex = sex;
        this.fullName = name + " " + firstSurname + " " + secondSurname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateFullName();
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
        updateFullName();
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
        updateFullName();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFullName() {
        return fullName;
    }

    /**
     * En este metodo actualizo automaticamente el nombre completo
     * cuando se modifica alguno de los campos del nombre.
     */
    private void updateFullName() {
        this.fullName = name + " " + firstSurname + " " + secondSurname;
    }
}