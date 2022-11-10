package zoo.entities.foods;

public class Meat extends BaseFood {

    private final static int CALORIES = 70;
    private final static double PRICE = 10.0;

    public Meat() {
        super(CALORIES, PRICE);
    }

}