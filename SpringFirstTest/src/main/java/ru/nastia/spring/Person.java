package ru.nastia.spring;

public class Person {
    String name;
    String surname;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFullName(){
        return this.name + " " + this.surname;
    }
}
