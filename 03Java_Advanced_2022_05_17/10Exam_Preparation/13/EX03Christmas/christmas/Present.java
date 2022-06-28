package christmas;

public class Present {
    private String name;
    private double weight;
    private String gender;

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return String.format("Present %s (%.2f) for a %s", this.name, this.weight, this.gender);
    }

}