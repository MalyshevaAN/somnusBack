package com.example.demo1.service;
//import org.springframework.stereotype.Service;

import com.example.demo1.repository.HelloWorldMessageEntity;

//@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String getHelloWorldString(String name) {
        return "Hello World, " + name;
    }

    @Override
    public HelloWorldMessageEntity findHelloWorldEntity(int id) {
        return null;
    }
}
