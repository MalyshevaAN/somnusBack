package com.example.demo1.service;

//import org.springframework.stereotype.Service;

import com.example.demo1.repository.HelloWorldMessageEntity;
import com.example.demo1.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceInformalImpl implements HelloWorldService {

    HelloWorldRepository repository;

    @Autowired
    public HelloWorldServiceInformalImpl(HelloWorldRepository repository) {
        this.repository = repository;
    }


    @Override
    public String getHelloWorldString(String name) {
        HelloWorldMessageEntity entity = new HelloWorldMessageEntity();
        entity.setMessage("Hi, World" + name);
        entity.setSenderName(name);
        var createdEntity = repository.save(entity);
        return "Hi World, " + name + " " + createdEntity.getId();
    }

    @Override
    public HelloWorldMessageEntity findHelloWorldEntity(int id) {
        return repository.findById(id);
    }


}
