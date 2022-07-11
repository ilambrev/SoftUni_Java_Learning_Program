package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    private final static BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);
    private final static double CAKE_GRAMS = 250;
    private final static double CAKE_CALORIES = 1000;

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }

}