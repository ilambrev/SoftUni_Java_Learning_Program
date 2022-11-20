package restaurant.entities.tables.interfaces;

public class InGarden extends BaseTable {

    private static final double PRICE_PER_PERSON = 4.50;

    public InGarden(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }

}