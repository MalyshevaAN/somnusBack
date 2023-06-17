package nastia.authorization2.controller;

import nastia.authorization2.entity.User;
import nastia.authorization2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class IndexController {
        @Autowired
        private UserService userService;

        @GetMapping("/index")
        public String registration (Model model){
            model.addAttribute("userForm", new User());

            return "index";
        }

    }
