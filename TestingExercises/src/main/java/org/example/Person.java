package org.example;

public class Person {
    private String name;
    private String surname;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Person() {
    }

    public Person(String name, String surname, String street, String city, String state, String zip) {
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return String.format("%s %s lives in %s, %s. Zip code is %s",
                this.getName(),
                this.getSurname(),
                this.getCity(),
                this.getState(),
                this.getZip());
    }
}
