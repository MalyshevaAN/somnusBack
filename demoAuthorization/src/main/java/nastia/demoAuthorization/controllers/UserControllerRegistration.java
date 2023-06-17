package nastia.demoAuthorization.controllers;


import nastia.demoAuthorization.model.User;
import nastia.demoAuthorization.service.SecurityService;
import nastia.demoAuthorization.service.UserService;
import nastia.demoAuthorization.validators.UserValidatro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class UserControllerRegistration {

    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidatro userValidatro;

    @GetMapping
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("userForm")User userForm, BindingResult bindingResult){
        userValidatro.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()){
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }
}
