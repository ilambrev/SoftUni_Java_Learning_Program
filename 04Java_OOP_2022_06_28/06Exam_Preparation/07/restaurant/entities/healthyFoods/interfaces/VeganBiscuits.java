package restaurant.entities.healthyFoods.interfaces;

public class VeganBiscuits extends Food {

    private static final double PORTION = 205.0;


    public VeganBiscuits(String name, double price) {
        super(name, PORTION, price);
    }

}