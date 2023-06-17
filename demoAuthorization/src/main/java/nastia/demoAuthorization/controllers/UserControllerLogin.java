package nastia.demoAuthorization.controllers;


import nastia.demoAuthorization.model.User;
import nastia.demoAuthorization.service.SecurityService;
import nastia.demoAuthorization.service.UserService;
import nastia.demoAuthorization.validators.UserValidatro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserControllerLogin {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidatro userValidatro;

    @GetMapping
    public String registrtion(Model model, String error, String logout){
        if (error != null){
            model.addAttribute("error", "Your email and password is invalid");
        }
        if (logout != null){
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }
    //postController is provided by Spring

}
