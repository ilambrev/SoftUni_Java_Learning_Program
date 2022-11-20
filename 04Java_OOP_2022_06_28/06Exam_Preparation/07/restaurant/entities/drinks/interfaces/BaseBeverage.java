package restaurant.entities.drinks.interfaces;

public abstract class BaseBeverage implements Beverages {

    private String name;
    private int counter;
    private double price;
    private String brand;

    public BaseBeverage(String name, int counter, double price, String brand) {
        setName(name);
        setCounter(counter);
        setPrice(price);
        setBrand(brand);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or white space!");
        } else {
            this.name = name;
        }
    }

    @Override
    public int getCounter() {
        return this.counter;
    }

    private void setCounter(int counter) {
        if (counter <= 0) {
            throw new IllegalArgumentException("Counter cannot be less or equal to zero!");
        } else {
            this.counter = counter;
        }
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be less or equal to zero!");
        } else {
            this.price = price;
        }
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or white space!");
        } else {
            this.brand = brand;
        }
    }

}