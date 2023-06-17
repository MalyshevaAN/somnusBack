package com.example.demo1.repository;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "message")
public class HelloWorldMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "message")
    private String message;

    @Column(name = "sender_name")
    private String senderName;

    public HelloWorldMessageEntity(){

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getSenderName(){
        return senderName;
    }

    public void setSenderName(String s){
        this.senderName = s;
    }
}
