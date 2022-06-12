package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new Tire[4];
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Tire[] getTires() {
        return this.tires;
    }

    public boolean pressureLimit(int limit) {
        boolean tirePressureUnderLimit = false;
        for (Tire t : this.tires) {
            if (t.getPressure() < limit) {
                tirePressureUnderLimit = true;
                break;
            }
        }

        return tirePressureUnderLimit;
    }

    @Override
    public String toString() {
        return String.format("%s", this.model);
    }

}