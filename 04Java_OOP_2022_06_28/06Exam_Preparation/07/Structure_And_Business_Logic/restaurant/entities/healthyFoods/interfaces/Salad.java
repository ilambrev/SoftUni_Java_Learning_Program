package restaurant.entities.healthyFoods.interfaces;

public class Salad extends Food {

    private static final double PORTION = 150.0;

    public Salad(String name, double price) {
        super(name, PORTION, price);
    }

}