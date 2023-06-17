package nastia.api1;

public class Animal {

    private String animalType;
    public Animal(String animal) {
        this.animalType = animal;
    }

    public Animal(){

    }
    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
