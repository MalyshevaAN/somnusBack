package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    List<MyUser> users;



    public void addUser(){
        users.add(new MyUser("12345", "hello", "user"));
    }
    public MyUser findByUsername(String username){

       return  users.stream().filter(user -> user.login() == username).findFirst().orElse(null);
    }

    public void createUser(String login, String password){
        users.add(new MyUser(login, password,"user"));
    }

}
