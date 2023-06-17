package malysheva.AN.contentcalendar;

import malysheva.AN.contentcalendar.model.Content;
import malysheva.AN.contentcalendar.model.Status;
import malysheva.AN.contentcalendar.model.Type;
import malysheva.AN.contentcalendar.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(x -> System.out.println(x));
		//Object restTemplate = context.getBean("restTemplate");
		//System.out.println(restTemplate);
	}

	@Bean
	CommandLineRunner commandLineRunner(@Autowired  ContentRepository repository){
		return args -> {
			//insert some data into database
			Content c = new Content(null,
					"My second post",
					"Hello Nastia",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					"gglkjfglj");
            repository.save(c);
		};


	}

	// write more code

}