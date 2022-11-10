package zoo.entities.foods;

public class Vegetable extends BaseFood {

    private final static int CALORIES = 50;
    private final static double PRICE = 5.0;

    public Vegetable() {
        super(CALORIES, PRICE);
    }

}