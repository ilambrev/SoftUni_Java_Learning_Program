package Vehicles;

public class Truck extends AbstractVehicle {

    private static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {

        return "Truck" + super.drive(distance);
    }

    @Override
    public void refuel(double fuelInLiters) {
        super.refuel(fuelInLiters * 0.95);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }

}