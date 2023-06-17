package com.example.demo1.controller;

import com.example.demo1.service.HelloWorldService;
import com.example.demo1.service.HelloWorldServiceInformalImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    @Autowired
    HelloWorldServiceInformalImpl service;

    // Thymeleaf
    @GetMapping(value = "/world", produces= "text/html")
    public String sayHello() {
        return
                "<!DOCTYPE html>"+
                        "<html>"+
                        "	<head><title>Hello world!</title></head>"+
                        "	<body>Hello world!</body>"+
                        "</html>"
                ;
    }

    @GetMapping(value = "/world/{id}", produces= "text/html")
    public String sayHelloWithId(@PathVariable("id") int id) {
        return
                "<!DOCTYPE html>"+
                        "<html>"+
                        "	<head><title>Hello world! " + id + "</title></head>"+
                        "	<body>Hello world! " + id + "</body>"+
                        "</html>"
                ;
    }

    @GetMapping(value = "/world1", produces= "text/html")
    public String sayHelloWithIdAndParam(@PathParam("name") String name) {
        service.getHelloWorldString(name);
        System.out.println(service.findHelloWorldEntity(1).getSenderName());
        return
                "<!DOCTYPE html>"+
                        "<html>"+
                        "	<head><title>Hello world!</title></head>"+
                        "	<body>Hello world! " + name + "</body>"+
                        "</html>"
                ;
    }

    @PostMapping(value = "/world")
    public String postHello(@RequestBody HelloWorldRequest request) {
        return "Hello world " + request.name;
    }

    @PostMapping(value = "/world1")
    public HelloWorldResponse postHello1(@RequestBody HelloWorldRequest request) {
        var message = service.getHelloWorldString(request.name);
        return new HelloWorldResponse(message);
    }
}
