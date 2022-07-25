package Vehicles;

public class Car extends AbstractVehicle {

    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {

        return "Car" + super.drive(distance);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }

}