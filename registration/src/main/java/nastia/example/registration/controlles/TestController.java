package nastia.example.registration.controlles;


import jakarta.websocket.server.PathParam;
import nastia.example.registration.model.SimpleUser;
import nastia.example.registration.repository.SimpleUserRepository;
import nastia.example.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reg")
public class TestController {


    @Autowired
    UserService service;
    @GetMapping("/{id}")
    public String getRegistrated(@PathVariable("id") Long id){
        System.out.println(id);
        if (service.get(id).isEmpty()){
            return "User do not Exist";
        }
        return service.get(id).get().toString();
    }

    @GetMapping
    public String registr(){
        return "please enter information about you";
    }

    @PostMapping
    public String registration(@RequestBody SimpleUser user) {
        return service.create(user);
    }

}
