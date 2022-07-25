package Vehicles;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle {

    private double fuelQuantity;
    private final double fuelConsumption;

    public AbstractVehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
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
        this.fuelQuantity += fuelInLiters;
    }

}