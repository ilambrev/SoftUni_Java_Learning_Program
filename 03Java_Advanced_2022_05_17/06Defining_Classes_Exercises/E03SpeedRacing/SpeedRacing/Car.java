package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsPerKM;
    private int distance;

    public Car(String model, double fuelAmount, double fuelConsPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsPerKM = fuelConsPerKM;
        this.distance = 0;
    }

    public boolean drive(int distanceToTravel) {
        if (this.fuelAmount - distanceToTravel * this.fuelConsPerKM >= 0) {
            this.fuelAmount -= distanceToTravel * this.fuelConsPerKM;
            this.distance += distanceToTravel;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distance);
    }

}