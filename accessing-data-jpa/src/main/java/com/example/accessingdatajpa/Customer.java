package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // jpa entity, mapped to a table named Customer
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    protected Customer(){} // for the sake of jpa

    public Customer(String name, String surname){ // the one we use t create instance of Customer and save it
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString(){
        return String.format(
                "Customer[id=%d, name='%s',surname='%s']",
                id, name, surname
        );
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
}
