package catHouse.entities.cat;

public abstract class BaseCat implements Cat {

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    public BaseCat(String name, String breed, double price) {
        setName(name);
        setBreed(breed);
        this.kilograms = 0;
        setPrice(price);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Cat name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    private void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new NullPointerException("Cat breed cannot be null or empty.");
        } else {
            this.breed = breed;
        }
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cat price cannot be below or equal to 0.");
        } else {
            this.price = price;
        }
    }

}