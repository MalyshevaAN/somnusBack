package nastia.api1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomAnimalClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomAnimalClient.class);

    private final RestTemplate restTemplate;

    public RandomAnimalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Animal> random1(){
        LOGGER.info("Sending request for animal {}");
        return restTemplate.getForEntity("http://proxy/random/random", Animal.class);
    }
}
