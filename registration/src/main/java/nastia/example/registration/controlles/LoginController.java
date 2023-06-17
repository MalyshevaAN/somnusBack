package nastia.example.registration.controlles;


import nastia.example.registration.model.AuthorizeData;
import nastia.example.registration.model.SimpleUser;
import nastia.example.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    UserService service;


    @GetMapping
    public String getLogin(){
        return "please, write down your login and password";
    }

    @PostMapping
    public @ResponseBody SimpleUser tryLogin(@RequestBody AuthorizeData data){
        return service.authorize(data).get();
    }
}
