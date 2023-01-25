package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, price);
        setKg(2.50);
    }

    @Override
    public void eat() {
        setKg(getKg() + 7.50);
    }

}