package VehiclesExtension;

public class Bus extends AbstractVehicle {

    private static final double AIR_CONDITIONER_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }

    public String driveEmpty(double distance) {
        super.setFuelConsumption(super.getFuelConsumption() - AIR_CONDITIONER_CONSUMPTION);
        String message = "Bus" + super.drive(distance);
        super.setFuelConsumption(super.getFuelConsumption() + AIR_CONDITIONER_CONSUMPTION);
        return message;
    }

    @Override
    public String drive(double distance) {

        return "Bus" + super.drive(distance);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }

}