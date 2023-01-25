package restaurant.entities.healthyFoods.interfaces;

public abstract class Food implements HealthyFood {

    private String name;
    private double portion;
    private double price;


    public Food(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
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
    public double getPortion() {
        return this.portion;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException("Portion cannot be less or equal to zero!");
        } else {
            this.portion = portion;
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

}