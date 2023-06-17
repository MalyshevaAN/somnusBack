package nastia.demoAuthorization.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllersMainAndWelcome {
    @GetMapping({"/", "/welcome"})
    public String welcome(Model model){
        return "welcome";
    }
}
