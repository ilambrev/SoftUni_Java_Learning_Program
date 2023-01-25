package christmasRaces.entities.cars;

public class SportsCar extends BaseCar {

    private static final double CUBIC_CENTIMETERS = 3000;
    private static final int MIN_HORSEPOWER = 250;
    private static final int MAX_HORSEPOWER = 450;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower > MAX_HORSEPOWER || horsePower < MIN_HORSEPOWER) {
            String message = String.format("Invalid horse power: %d.", horsePower);
            throw new IllegalArgumentException(message);
        } else {
            super.setHorsePower(horsePower);
        }
    }

}