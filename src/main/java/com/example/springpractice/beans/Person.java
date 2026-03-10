package com.example.springpractice.beans;

/**
 * En esta clase defino el bean Person.
 * Aqui guardo los datos de una persona y actualizo automaticamente
 * el nombre completo cuando modifico sus datos.
 */
public class Person {

    private String dni;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String fullName;
    private String birthDate;
    private String sex;

    /**
     * En este constructor vacio permito que Spring pueda crear
     * objetos Person cuando reciba datos en el cuerpo de la peticion.
     */
    public Person() {
    }

    /**
     * En este constructor recibo los datos sin DNI.
     * Lo uso para los ejercicios anteriores.
     */
    public Person(String name, String firstSurname, String secondSurname, String birthDate, String sex) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.sex = sex;
        updateFullName();
    }

    /**
     * En este constructor recibo todos los datos de la persona,
     * incluido el DNI.
     */
    public Person(String dni, String name, String firstSurname, String secondSurname, String birthDate, String sex) {
        this.dni = dni;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.sex = sex;
        updateFullName();
    }

    /**
     * En este metodo actualizo el nombre completo a partir
     * del nombre y los apellidos.
     */
    private void updateFullName() {
        this.fullName = name + " " + firstSurname + " " + secondSurname;
    }

    /**
     * Devuelvo el DNI.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Modifico el DNI.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelvo el nombre.
     */
    public String getName() {
        return name;
    }

    /**
     * Modifico el nombre y actualizo el nombre completo.
     */
    public void setName(String name) {
        this.name = name;
        updateFullName();
    }

    /**
     * Devuelvo el primer apellido.
     */
    public String getFirstSurname() {
        return firstSurname;
    }

    /**
     * Modifico el primer apellido y actualizo el nombre completo.
     */
    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
        updateFullName();
    }

    /**
     * Devuelvo el segundo apellido.
     */
    public String getSecondSurname() {
        return secondSurname;
    }

    /**
     * Modifico el segundo apellido y actualizo el nombre completo.
     */
    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
        updateFullName();
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
     * Modifico la fecha de nacimiento.
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Devuelvo el sexo.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Modifico el sexo.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
}