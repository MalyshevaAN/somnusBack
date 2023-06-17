package nastia.example.registrationAgain.controller;

import jakarta.validation.Valid;
import nastia.example.registrationAgain.model.UserData;
import nastia.example.registrationAgain.service.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserRegistration {
    @Autowired
    private UserServise userServise;

    @GetMapping("/register")
    public String register(final Model model){
        model.addAttribute("userData", new UserData());
        return "register";
    }

    @PostMapping("/register")
    public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult, final Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "register";
        }
        try {
            userServise.register(userData);
        } catch (Exception e) {
            bindingResult.rejectValue("email", "userData.email","An account already exists");
            model.addAttribute("registrationForm", userData);
            return "register";
        }
        return "";
    }

}
