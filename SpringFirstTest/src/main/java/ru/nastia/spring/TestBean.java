package ru.nastia.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBean {


    @Autowired
    private String Name;

    public TestBean() {
    }

    public String getName(){
        return this.Name;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void hello(){
        System.out.println("Hello " + this.Name);
    }
}
