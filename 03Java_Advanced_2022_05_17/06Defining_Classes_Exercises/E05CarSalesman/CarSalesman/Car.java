package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    @Override
    public String toString() {
        String weightNew = "n/a";
        if (this.weight > -1) {
            weightNew = String.valueOf(this.weight);
        }
        return String.format("%s:%n%s%nWeight: %s%nColor: %s", this.model, this.engine.toString(), weightNew, this.color);
    }

}