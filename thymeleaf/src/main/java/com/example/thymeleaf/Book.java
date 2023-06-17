package com.example.thymeleaf;

public class Book {
    public String name;
    public String author;

    public String getAuthor(){
        return author;
    }
    public String getName(){
        return name;
    }

    public Book(){

    }

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
