package com.example.demo.controller;


import com.example.demo.MyUser;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody MyUser user){
        return "";
    }

    @GetMapping("/try")
    public String login(){
        return "ping";
    }
}
