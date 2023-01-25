package zoo.entities.animals;

public abstract class BaseAnimal implements Animal {

    private String name;
    private String kind;
    private double kg;
    private double price;

    public BaseAnimal(String name, String kind, double price) {
        setName(name);
        setKind(kind);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Animal name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    private void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException("Animal kind cannot be null or empty.");
        } else {
            this.kind = kind;
        }
    }

    @Override
    public double getKg() {
        return kg;
    }

    protected void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Animal price cannot be below or equal to 0.");
        } else {
            this.price = price;
        }
    }

    @Override
    public abstract void eat();

}