package CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power, displacement);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacementNew = "n/a";
        if (this.displacement > -1) {
            displacementNew = String.valueOf(this.displacement);
        }
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s", this.model, this.power, displacementNew, this.efficiency);
    }

}