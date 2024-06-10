package com.certidevs.model;

// No hace falta anotación
// Es una clase de datos
public class Customer {
    private String nif;
    private String firstName;
    private Integer age;
    private Boolean active;

    public Customer() {
    }

    public Customer(String nif, String firstName, Integer age, Boolean active) {
        this.nif = nif;
        this.firstName = firstName;
        this.age = age;
        this.active = active;
    }

    // ¡NECESARIO! Crear getter y setter
    // para que Spring/Jackson pueda acceder a los atributos
    // y convertirlo a json y viceversa
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
