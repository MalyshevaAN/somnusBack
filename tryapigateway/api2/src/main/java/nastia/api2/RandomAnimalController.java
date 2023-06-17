package nastia.api2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomAnimalController {

    @Autowired
    private final AnimalDao animalDao;

    public RandomAnimalController(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @GetMapping("/random")
    public Animal randomAnimal(){
        return animalDao.random();
    }
}
