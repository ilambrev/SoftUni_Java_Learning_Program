package Google;

public class Car {
    private String model;
    private int speed;

    public Car() {

    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.model, this.speed);
    }

}