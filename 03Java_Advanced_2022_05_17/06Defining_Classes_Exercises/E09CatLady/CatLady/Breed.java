package CatLady;

public class Breed {
    private String name;
    private double characteristic;

    public Breed(String name, double characteristic) {
        this.name = name;
        this.characteristic = characteristic;
    }

    public String getName() {
        return this.name;
    }

    public double getCharacteristic() {
        return this.characteristic;
    }

}