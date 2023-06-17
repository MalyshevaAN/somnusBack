package nastia.example.registrationAgain.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class ConfigReg implements WebMvcConfigurer {
    public void addViewController(ViewControllerRegistry registry){
        //registry.addViewController("/register").setViewName("src/main/resources/templates/registration.html ");
    }
}
