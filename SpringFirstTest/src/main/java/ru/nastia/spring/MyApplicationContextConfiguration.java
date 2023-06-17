package ru.nastia.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.nastia.spring.TestBean;

@Configuration
@ComponentScan
public class MyApplicationContextConfiguration {
   @Bean
   public String Name(){
       Person pers = new Person();
       pers.setName("Nastia");
       pers.setSurname("Kreker");
       return pers.getFullName();
   }
}
