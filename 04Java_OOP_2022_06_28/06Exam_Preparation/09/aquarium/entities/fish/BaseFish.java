package aquarium.entities.fish;

public abstract class BaseFish implements Fish {

    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        this.size = 0;
        setPrice(price);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Fish name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    private void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new NullPointerException("Fish species cannot be null or empty.");
        } else {
            this.species = species;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Fish price cannot be below or equal to 0.");
        } else {
            this.price = price;
        }
    }

    @Override
    public void eat() {
        this.size += 5;
    }

}