package aquarium.entities.decorations;

public abstract class BaseDecoration implements Decoration {

    private int comfort;
    private double price;

    public BaseDecoration(int comfort, double price) {
        this.comfort = comfort;
        this.price = price;
    }

    @Override
    public int getComfort() {
        return this.comfort;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

}