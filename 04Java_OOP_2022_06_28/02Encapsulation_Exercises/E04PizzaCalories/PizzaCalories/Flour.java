package PizzaCalories;

public enum Flour {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private double modifier;

    Flour(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

}