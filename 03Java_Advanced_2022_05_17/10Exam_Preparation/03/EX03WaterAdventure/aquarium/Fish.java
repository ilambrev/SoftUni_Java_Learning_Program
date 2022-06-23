package aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getFins() {
        return this.fins;
    }

    @Override
    public String toString() {
        return String.format("Fish: %s%nColor: %s%nNumber of fins: %d", this.name, this.color, this.fins);
    }

}