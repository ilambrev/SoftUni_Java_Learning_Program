package VehiclesExtension;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private final int tankCapacity;

    public AbstractVehicle(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected boolean fuelForDistance(double distance) {
        return distance * this.fuelConsumption <= this.fuelQuantity;
    }

    @Override
    public String drive(double distance) {
        String message;

        if (fuelForDistance(distance)) {
            this.fuelQuantity -= distance * this.fuelConsumption;
            DecimalFormat df = new DecimalFormat("#.##");
            message = String.format(" travelled %s km", df.format(distance));
        } else {
            message = " needs refueling";
        }

        return message;
    }

    @Override
    public void refuel(double fuelInLiters) {
        if (fuelInLiters > this.tankCapacity - fuelQuantity) {
            System.out.println("Cannot fit fuel in tank");
        } else if (fuelInLiters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantity += fuelInLiters;
        }
    }

}