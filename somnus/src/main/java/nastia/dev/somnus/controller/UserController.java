package nastia.dev.somnus.controller;


import nastia.dev.somnus.model.Dream;
import nastia.dev.somnus.model.User;
import nastia.dev.somnus.model.UserLogin;
import nastia.dev.somnus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User userInfo){
            return userService.addUser(userInfo);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLogin userLogin){
        return userLogin.getLogin();
    }

    @GetMapping("all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("mydreams/{userId}")
    public Set<Dream> getAllDreams(@PathVariable Long userId){
        return userService.getUserDreams(userId);
    }
}
