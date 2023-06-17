package nastia.dev.JWTattempt;

import nastia.dev.JWTattempt.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class JwTattemptApplication {

	public static void main(String[] args) {

		SpringApplication.run(JwTattemptApplication.class, args);
	}

}
