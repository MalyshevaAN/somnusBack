package nastia.authorization2;

import nastia.authorization2.entity.User;
import nastia.authorization2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Authorization2Application {


	public static void main(String[] args) {
		SpringApplication.run(Authorization2Application.class, args);

	}

}
