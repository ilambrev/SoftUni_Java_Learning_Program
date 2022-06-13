package CatLady;

public class Cat {
    private String name;
    private Breed breed;

    public Cat(String name, Breed breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breed.getName(), this.name, this.breed.getCharacteristic());
    }

}