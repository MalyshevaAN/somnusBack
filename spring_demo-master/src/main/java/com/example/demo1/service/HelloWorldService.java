package com.example.demo1.service;

import com.example.demo1.repository.HelloWorldMessageEntity;

public interface HelloWorldService {

    String getHelloWorldString(String name);

    HelloWorldMessageEntity findHelloWorldEntity(int id);
}
