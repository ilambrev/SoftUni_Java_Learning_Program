package christmasRaces.entities.cars;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        if (model == null || model.trim().length() < 4) {
            String message = String.format("Model %s cannot be less than 4 symbols.", model);
            throw new IllegalArgumentException(message);
        } else {
            this.model = model;
        }
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters / this.horsePower * laps;
    }

}
