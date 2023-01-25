package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, price);
        setKg(5.50);
    }

    @Override
    public void eat() {
        setKg(getKg() + 5.70);
    }

}